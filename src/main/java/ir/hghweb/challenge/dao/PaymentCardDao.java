package ir.hghweb.challenge.dao;

import ir.hghweb.challenge.model.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
public class PaymentCardDao {

    @PersistenceContext
    EntityManager entityManager;

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @Autowired
    PaymentCard paymentCard;

    public void persist(){


    }
}
