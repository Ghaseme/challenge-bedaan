package ir.hghweb.challenge.model.POJO;

public class KafkaMessage {
    private String number;
    private String sms;

    public KafkaMessage(String number, String sms) {
        this.number = number;
        this.sms = sms;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return String.format("%s<>%s", getNumber(), getSms());
    }


}
