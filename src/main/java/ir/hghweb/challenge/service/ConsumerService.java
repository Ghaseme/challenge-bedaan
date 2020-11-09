package ir.hghweb.challenge.service;

import ir.hghweb.challenge.gateway.SMSProvider;
import ir.hghweb.challenge.model.POJO.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "kafkaTopic", groupId = "group_id")
    public void consume(String message) throws Exception {
        if(message.contains("<>")){
           String[] arr = message.split("<>");
            KafkaMessage kafkaMessage = new KafkaMessage(arr[0], arr[1]);
            SMSProvider smsProvider = new SMSProvider();
            if(smsProvider.sendSms(kafkaMessage.getNumber(), kafkaMessage.getSms())){
                logger.info(String.format("$$$$ => Consumed message: %s", message));
            }else{
                logger.info(String.format("$$$$ => Retrying message: %s", message));
                throw new Exception("Retrying message: %s: " + message);
            }
        }
        logger.info(String.format("$$$$ => Consumed message: %s", message));
    }
}