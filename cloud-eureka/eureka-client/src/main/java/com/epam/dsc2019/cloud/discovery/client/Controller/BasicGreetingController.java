package com.epam.dsc2019.cloud.discovery.client.Controller;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class BasicGreetingController {

  @Value("${app.service.name}")
  private String serviceName;

  @Value("${app.service.icon}")
  private int iconCode;

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  /**
   * Returns a greeting message with an icon.
   *
   * @return greeting message
   */
  @GetMapping
  public String getGreeting() {
   // sendMsg();
    final String greeting = new StringBuilder(new String(Character.toChars(iconCode)))
        .append(" ")
        .append("TEST - Hello from ")
        .append(serviceName)
        .toString();
    return greeting;
  }

  /**
   * Returns a greeting message with a given value.
   *
   * @param value message to show
   * @return greeting message
   */


  @GetMapping("/{value}")
  public String getGreeting(@PathVariable("value") String value) {
    final String greeting = new StringBuilder(new String(Character.toChars(iconCode)))
        .append(" ")
        .append("Hello from ")
        .append(serviceName)
        .append(", ")
        .append(value)
        .toString();
    return greeting;
  }
}
