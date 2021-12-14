package com.epam.dsc2019.cloud.discovery.client.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public void sendOrder() {
        kafkaTemplate.send("jmtopic2","Сообщение из РЕСТ ФУЛ АПИ");
    }

    @KafkaListener(topics = "jmtopic2")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Получено сообщение: " + message
                        + " Из партиции: " + partition);

    }
/**
 //     * Получение сообщения из определенной партиции
 @KafkaListener(topicPartitions = @TopicPartition(topic = "topicName",
 partitionOffsets = {
 @PartitionOffset(partition = "0", initialOffset = "0"),
 @PartitionOffset(partition = "3", initialOffset = "0")}),
 containerFactory = "partitionsKafkaListenerContainerFactory")
 public void listenToPartition(
 @Payload String message,
 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
 System.out.println(
 "Received Message: " + message
 + "from partition: " + partition);
 }
 */
}
