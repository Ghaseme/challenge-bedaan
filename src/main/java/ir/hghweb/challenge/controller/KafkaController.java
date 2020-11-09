package ir.hghweb.challenge.controller;

import ir.hghweb.challenge.model.POJO.KafkaMessage;
import ir.hghweb.challenge.service.ProducerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public final class KafkaController {
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public void sendMessageToKafkaTopic(@RequestParam String number, @RequestParam String message) {
        KafkaMessage kafkaMessage = new KafkaMessage(number, message);
        System.out.println(kafkaMessage.toString());
        producerService.sendMessage(kafkaMessage.toString());
    }

    @RequestMapping(value = "/send_messsage", method = RequestMethod.GET)
    public void sendMessageToKafkaTopic2(@RequestParam String message) {
        producerService.sendMessage(message);
    }
}