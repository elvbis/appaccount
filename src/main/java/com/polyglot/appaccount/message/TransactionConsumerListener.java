package com.polyglot.appaccount.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polyglot.appaccount.dto.TransactionRequest;
import com.polyglot.appaccount.model.AccountModel;
import com.polyglot.appaccount.service.IAccountService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumerListener {

    private Logger log = LoggerFactory.getLogger(TransactionConsumerListener.class);
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IAccountService iAccountService;
    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        log.info("****************************************************************");
        log.info("ConsumerRecord : {}", consumerRecord.value());
        TransactionRequest emp2 = objectMapper.readValue(consumerRecord.value(), TransactionRequest.class);
        AccountModel findById = iAccountService.findById(emp2.getAccountId());
        findById.setTotalAmount(emp2.getAmount()+findById.getTotalAmount());
        iAccountService.update(findById);


    }
}