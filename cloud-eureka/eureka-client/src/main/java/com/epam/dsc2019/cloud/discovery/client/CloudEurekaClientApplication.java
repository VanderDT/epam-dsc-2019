package com.epam.dsc2019.cloud.discovery.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@EnableKafka
@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class CloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaClientApplication.class);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            template.send("jmtopic2", "ЗАПУСТИЛСЯ МИКРОСЕРВИС CloudEurekaClientApplication");
        };
    }
}
