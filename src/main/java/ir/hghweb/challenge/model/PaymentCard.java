package ir.hghweb.challenge.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "payment_card_tbl")
@Component
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @ManyToOne @JoinColumn(name="user_id")
//    private User user; // TO DO: sign up users, then detect current user id

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(length = 4)
    private String cvv2;

    @Column(name = "exp_month", length = 4)
    private String expDate;

    @Column(length = 16)
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PaymentCard{" +
                "id=" + id +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", expDate='" + expDate + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
