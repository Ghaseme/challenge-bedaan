package ir.hghweb.challenge.controller;

import ir.hghweb.challenge.ChallengeApplication;
import ir.hghweb.challenge.model.PaymentCard;
import ir.hghweb.challenge.service.PaymentCardService;
import ir.hghweb.challenge.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public final class PaymentController {

    public static Logger logger = LoggerFactory.getLogger(ChallengeApplication.class);

    private final ProducerService producerService;

    private final PaymentCardService paymentCardService;

    public PaymentController(ProducerService producerService, PaymentCardService paymentCardService) {
        this.producerService = producerService;
        this.paymentCardService = paymentCardService;
    }


    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentCard> getCards() {
        return paymentCardService.getCards();
    }

    @RequestMapping(value = "/cards", method = RequestMethod.POST)
    public ResponseEntity createCard(@RequestBody PaymentCard paymentCard){
        // TO DO: data validation such as length of payment number and expDate
        PaymentCard newCard = paymentCardService.createCard(paymentCard);
        HttpStatus status = newCard!=null ? HttpStatus.CREATED : HttpStatus.FORBIDDEN;
        return new ResponseEntity(paymentCard, status);
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.GET)
    public ResponseEntity getCard(@PathVariable("id") Integer id) {
        PaymentCard paymentCard = paymentCardService.getCard(id);
        HttpStatus status = paymentCard!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity(paymentCard, status);
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateCard(@RequestBody PaymentCard paymentCard){
        paymentCardService.updateCard(paymentCard);
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCard(@PathVariable("id") Integer id) {
        Boolean result = paymentCardService.deleteCard(id);
        String message = result ? "done" : "failed";
        HttpStatus status = result ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity(message, status);
    }

    @RequestMapping(value = "/cards/transfer", method = RequestMethod.POST)
    public ResponseEntity fundTranster(@RequestParam("number") String number,
                                       @RequestParam("cvv2") String cvv2,
                                       @RequestParam("exp_date") String expDate,
                                       @RequestParam("password") String password,
                                       @RequestParam("destination") String destination,
                                       @RequestParam("debit") Integer debit) {
            ResponseEntity api_response = paymentCardService.fundTranster(number, cvv2, expDate, password, destination, debit);
            String message = api_response.getStatusCode() == HttpStatus.OK ? "Success!" : "Failed"; // TO DO: better response message
            return new ResponseEntity(message, HttpStatus.OK);
    }

}
