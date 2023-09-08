package com.polyglot.appaccount.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumerListener {

    private Logger log = LoggerFactory.getLogger(TransactionConsumerListener.class);


    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord)
    {
        log.info("****************************************************************");
        log.info("ConsumerRecord : {}", consumerRecord.value());

    }
}