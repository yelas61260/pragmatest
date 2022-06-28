package com.pragma.reactive.app;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pragma.reactive.app.model.Comments;
import com.pragma.reactive.app.model.User;
import com.pragma.reactive.app.model.UserComments;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactiveAppApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(ReactiveAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReactiveAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//exampleIterable();
		//exampleFlagMap();
		//exampleToString();
		//exampleToCollectList();
		//exampleUserCommentsFlatMap();
		//exampleUserCommentsZipWith();
		//exampleUserCommentsZipWith2();
		//exampleZipWithRange();
		//exampleIntervals();
		//exampleDelayElements();
		//exampleIntervalInfinito();
		//exampleIntervalInfinitoCreate();
		//exampleContraPresion();
		exampleContraPresion2();
	}
	
	public void exampleContraPresion2() {
		Flux.range(1, 10)
		.log()
		.limitRate(5)
		.subscribe();
	}
	
	public void exampleContraPresion() {
		Flux.range(1, 10)
		.log()
		.subscribe(new Subscriber<Integer>() {
			
			private Subscription s;
			private Integer limit = 5;
			private Integer consumido = 0;

			@Override
			public void onSubscribe(Subscription s) {
				this.s = s;
				s.request(limit);
			}

			@Override
			public void onNext(Integer t) {
				log.info(t.toString());
				consumido++;
				if (consumido == limit) {
					consumido = 0;
					s.request(limit);
				}
			}

			@Override
			public void onError(Throwable t) {
				log.error(t.getMessage());
			}

			@Override
			public void onComplete() {
				log.info("fin");
			}
		});
	}
	
	public void exampleIntervalInfinitoCreate() {
		Flux.create(emmiter -> {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				private Integer cont = 0;
				
				@Override
				public void run() {
					emmiter.next(++cont);
					if (cont == 10) {
						timer.cancel();
						emmiter.complete();
					}
				}
				
			}, 1000, 1000);
		})
		.log()
		.subscribe(next -> log.info(next.toString()),
				error -> log.error(error.getMessage()),
				()-> log.info("fin"));
	}
	
	public void exampleIntervalInfinito() throws InterruptedException {
		
		Flux.interval(Duration.ofSeconds(1))
		.flatMap(i -> {
			if (i > 5) {
				return Flux.error(new InterruptedException("llego a 5"));
			}
			return Flux.just(i);
		})
		.map(i -> "Hola "+i)
		.retry(0)
		.log()
		.subscribe(
				s -> log.info(s),
				e -> log.error(e.getMessage()));
	}
	
	public void exampleDelayElements() {
		Flux<Integer> range = Flux.range(1, 12)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> log.info(i.toString()));
		range.subscribe();
	}
	
	public void exampleIntervals() {
		Flux<Integer> range = Flux.range(1, 12);
		Flux<Long> delay = Flux.interval(Duration.ofSeconds(1));
		
		range.zipWith(delay, (ra, re) -> ra)
		.doOnNext(i -> log.info(i.toString()))
		.subscribe();
	}
	
	public void exampleZipWithRange() {
		Flux.just(1,2,3,4)
		.map(i -> i*2)
		.zipWith(Flux.range(0, 4), (first, second) -> String.format("Primer Flux: %d, Segundo Flux %d", first, second))
		.subscribe(text -> log.info(text));
	}
	
	public void exampleUserCommentsZipWith2() {
		Mono<User> userMono = Mono.fromCallable(() -> {
			return User.builder()
					.nombre("Cristian")
					.apellido("Yela")
					.build();
		});
				
		
		Mono<Comments> commentsMono = Mono.fromCallable(() -> {
			Comments comments = new Comments();
			comments.addComment("comentario 1");
			comments.addComment("comentario 2");
			comments.addComment("comentario 3");
			comments.addComment("comentario 4");
			return comments;
		});

		Mono<UserComments> userComments = userMono
				.zipWith(commentsMono)
				.map(tuple -> {
					User u = tuple.getT1();
					Comments c = tuple.getT2();
					return UserComments.builder()
							.user(u)
							.comments(c)
							.build();
				});
		
		userComments.subscribe(uc -> log.info(uc.toString()));
	}
	
	public void exampleUserCommentsZipWith() {
		Mono<User> userMono = Mono.fromCallable(() -> {
			return User.builder()
					.nombre("Cristian")
					.apellido("Yela")
					.build();
		});
				
		
		Mono<Comments> commentsMono = Mono.fromCallable(() -> {
			Comments comments = new Comments();
			comments.addComment("comentario 1");
			comments.addComment("comentario 2");
			comments.addComment("comentario 3");
			comments.addComment("comentario 4");
			return comments;
		});

		Mono<UserComments> userComments = userMono
				.zipWith(commentsMono, (user, comments) -> UserComments.builder()
						.user(user)
						.comments(comments)
						.build()
				);
		
		userComments.subscribe(uc -> log.info(uc.toString()));
	}
	
	public void exampleUserCommentsFlatMap() {
		Mono<User> userMono = Mono.fromCallable(() -> {
			return User.builder()
					.nombre("Cristian")
					.apellido("Yela")
					.build();
		});
				
		
		Mono<Comments> commentsMono = Mono.fromCallable(() -> {
			Comments comments = new Comments();
			comments.addComment("comentario 1");
			comments.addComment("comentario 2");
			comments.addComment("comentario 3");
			comments.addComment("comentario 4");
			return comments;
		});
		
		userMono.flatMap(
				u -> commentsMono.map(
						c -> UserComments.builder()
								.user(u)
								.comments(c)
								.build()
						)
				)
		.subscribe(uc -> log.info(uc.toString()));
	}
	
	public void exampleToCollectList() {
		List<User> usersList = new ArrayList<>();
		usersList.add(User.builder()
				.nombre("Andres")
				.apellido("Reina")
				.build());
		usersList.add(User.builder()
				.nombre("Cristian")
				.apellido("Yela")
				.build());
		usersList.add(User.builder()
				.nombre("William")
				.build());
		usersList.add(User.builder()
				.nombre("Angelica")
				.apellido("Molina")
				.build());
		
		Flux.fromIterable(usersList)
			.collectList()
			.subscribe(
				users -> users.forEach(user -> log.info(user.toString()))
			);
	}
	
	public void exampleToString() {
		List<User> usersList = new ArrayList<>();
		usersList.add(User.builder()
				.nombre("Andres")
				.apellido("Reina")
				.build());
		usersList.add(User.builder()
				.nombre("Cristian")
				.apellido("Yela")
				.build());
		usersList.add(User.builder()
				.nombre("William")
				.build());
		usersList.add(User.builder()
				.nombre("Angelica")
				.apellido("Molina")
				.build());
		
		Flux.fromIterable(usersList)
				.map(user -> {
						return user.getNombre()
								.concat(user.getApellido() == null ? "" : " "+user.getApellido());
					}
				)
				.flatMap(nombre -> {
					if (nombre.contains(" ")) {
						return Mono.just(nombre);
					} else {
						return Mono.empty();
					}
				})
				.map(nombre -> {
					return nombre.toUpperCase();
					}
				)
				.subscribe(
				user -> log.info(user.toString())
				);
	}
	
	public void exampleFlagMap() {
		List<String> usersList = new ArrayList<>();
		usersList.add("Andres Reina");
		usersList.add("Pedro Yela");
		usersList.add("William");
		usersList.add("Cristian Molina");
		
		Flux.fromIterable(usersList)
				.map(name -> {
						String[] fullName = name.split(" ");
						return User.builder()
								.nombre(fullName[0])
								.apellido(fullName.length > 1 ? fullName[1] : null)
								.build();
					}
				)
				.flatMap(user -> {
					if (user.getApellido() == null) {
						return Mono.just(user);
					} else {
						return Mono.empty();
					}
				})
				.map(user -> {
					user.setNombre(user.getNombre().toUpperCase());
					return user;
					}
				)
				.subscribe(
				user -> log.info(user.toString())
				);
	}
	
	public void exampleIterable() {
		List<String> usersList = new ArrayList<>();
		usersList.add("Andres Reina");
		usersList.add("Pedro Yela");
		usersList.add("William");
		usersList.add("Cristian Molina");
		
		Flux<String> nombres = Flux.fromIterable(usersList);
		//Flux<String> nombres = Flux.just("Andres Reina", "Pedro Yela", "William", "Cristian Molina");
		
		Flux<User> users = nombres.map(name -> {
						String[] fullName = name.split(" ");
						return User.builder()
								.nombre(fullName[0])
								.apellido(fullName.length > 1 ? fullName[1] : null)
								.build();
					}
				)
				.doOnNext(user -> {
					if (user == null) {
						throw new RuntimeException("Nombre vacio");
					}
					System.out.println(user);
				})
				.filter(user -> user.getNombre().contains("r"))
				.map(user -> {
					user.setNombre(user.getNombre().toUpperCase());
					return user;
					}
				);
		
		nombres.subscribe(
				user -> log.info(user.toString()),
				error -> log.error(error.getMessage()),
				new Runnable() {
					
					@Override
					public void run() {
						log.info("finaliza proceso");
					}
				}
				);
		
		users.subscribe(
				user -> log.info(user.toString()),
				error -> log.error(error.getMessage()),
				new Runnable() {
					
					@Override
					public void run() {
						log.info("finaliza proceso");
					}
				}
				);
	}

}
