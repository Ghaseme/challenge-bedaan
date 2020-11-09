package ir.hghweb.challenge.dao;

import ir.hghweb.challenge.model.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCardRepository extends JpaRepository<PaymentCard, Integer> {

    public PaymentCard findPaymentCardByNumberAndCvv2AndExpDate(String number, String cvv2, String expDate);

}
