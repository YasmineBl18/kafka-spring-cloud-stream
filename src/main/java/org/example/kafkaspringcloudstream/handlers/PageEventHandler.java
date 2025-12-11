package org.example.kafkaspringcloudstream.handlers;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.example.kafkaspringcloudstream.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


@Component
public class PageEventHandler {
    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            System.out.println("*****************");
            System.out.println(input.toString());
            System.out.println("*****************");

        };

    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> {
            return new PageEvent(
                    Math.random() > 0.5 ? "P1" : "P2",   // name
                    Math.random() > 0.5 ? "U1" : "U2",   // user
                    new Date(),                          // date
                    10 + new Random().nextInt(10000)     // duration
            );
        };
    }

    @Bean
    public Function<KStream<String, PageEvent>, KStream<String, Long>> kStreamFunction() {
        return input ->
                input.filter((key, value) -> value.getDuration() > 100)
                        .map((key, value) -> new KeyValue<>(value.getName(), value.getDuration()));
    }
}



