package com.example.demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Main {
    public static void main(String[] args) {
        // List<Integer> elements = new ArrayList<>();

        // Flux.just(1, 2, 3, 4)
        // .log()
        // .subscribe(elements::add);

        // Flux.just(1, 2, 3, 4)
        // .log()
        // .subscribe(new Subscriber<Integer>() {
        // @Override
        // public void onSubscribe(Subscription s) {
        // s.request(Long.MAX_VALUE);
        // }

        // @Override
        // public void onNext(Integer integer) {
        // elements.add(integer);
        // }

        // @Override
        // public void onError(Throwable t) {
        // }

        // @Override
        // public void onComplete() {
        // }
        // });

        // Flux.just(1, 2, 3, 4)
        // .log()
        // .subscribe(new Subscriber<Integer>() {
        // private Subscription s;
        // int onNextAmount;

        // @Override
        // public void onSubscribe(Subscription s) {
        // this.s = s;
        // s.request(2);
        // }

        // @Override
        // public void onNext(Integer integer) {
        // elements.add(integer);
        // onNextAmount++;
        // if (onNextAmount % 2 == 0) {
        // s.request(2);
        // }
        // }

        // @Override
        // public void onError(Throwable t) {
        // }

        // @Override
        // public void onComplete() {
        // }
        // });

        // Flux.just(1, 2, 3, 4)
        // .log()
        // .map(i -> i * 2)
        // .subscribe(elements::add);

        // List<String> elements = new ArrayList<>();

        // Flux.just(1, 2, 3, 4)
        // .log()
        // .map(i -> i * 2)
        // .zipWith(Flux.range(0, Integer.MAX_VALUE),
        // (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
        // .subscribe(System.out::println);

        // ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
        // while (true) {
        // fluxSink.next(System.currentTimeMillis());
        // }
        // })
        // .publish();

        // ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
        // while (true) {
        // fluxSink.next(System.currentTimeMillis());
        // }
        // })
        // .sample(Duration.ofSeconds(2))
        // .publish();

        // publish.subscribe(System.out::println);
        // publish.connect();
        // List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .doOnNext(t -> {
                    System.out.println(t + " thread id: " + Thread.currentThread().getId());
                })
                .blockLast();

    }
}
