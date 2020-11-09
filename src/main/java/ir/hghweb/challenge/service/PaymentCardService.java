package ir.hghweb.challenge.service;

import ir.hghweb.challenge.ChallengeApplication;
import ir.hghweb.challenge.dao.PaymentCardRepository;
import ir.hghweb.challenge.gateway.GeneralProvider;
import ir.hghweb.challenge.gateway.ProviderFactory;
import ir.hghweb.challenge.model.POJO.KafkaMessage;
import ir.hghweb.challenge.model.PaymentCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentCardService {

    public static Logger logger = LoggerFactory.getLogger(ChallengeApplication.class);

    private final PaymentCardRepository paymentCardRepository;
    private final ProducerService producerService;

    public PaymentCardService(PaymentCardRepository paymentCardRepository, ProducerService producerService) {
        this.paymentCardRepository = paymentCardRepository;
        this.producerService = producerService;
    }


    public List<PaymentCard> getCards() {
        return paymentCardRepository.findAll();
    }

    public PaymentCard createCard(PaymentCard paymentCard){
        if(paymentCard.getId()!=0){ // TO DO: find better solution
            paymentCard = null;
        }else{
            paymentCardRepository.save(paymentCard);
        }
        return paymentCard;
    }

    public PaymentCard getCard(Integer id) {
        Optional<PaymentCard> paymentCard = paymentCardRepository.findById(id);
        return paymentCard.get();
    }

    public void updateCard(PaymentCard paymentCard){
        paymentCardRepository.saveAndFlush(paymentCard);
    }

    public Boolean deleteCard(Integer id) {
        Optional<PaymentCard> paymentCard = paymentCardRepository.findById(id);
        if(!paymentCard.isEmpty()){
            paymentCardRepository.delete(paymentCard.get());
            return true;
        }
        return false;
    }

    public ResponseEntity fundTranster(String number, String cvv2, String expDate, String password, String destination, Integer debit) {
        PaymentCard paymentCard = paymentCardRepository.findPaymentCardByNumberAndCvv2AndExpDate(number, cvv2, expDate);
        // TO DO: handle password
        GeneralProvider provider = ProviderFactory.getProvider(number);
        ResponseEntity response = provider.transfer(number, destination, cvv2,expDate, password, debit);
        if(response.getStatusCode() == HttpStatus.OK){
            String userNumber = "123456789"; // TO DO: register user number
            KafkaMessage kafkaMessage = new KafkaMessage(userNumber, String.format("Successful Transfer: Amount of %d from %s to %s", debit, number, destination));
            producerService.sendMessage(kafkaMessage.toString());
        }
        return response;
    }
}
