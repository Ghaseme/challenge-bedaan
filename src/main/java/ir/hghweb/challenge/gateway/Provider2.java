package ir.hghweb.challenge.gateway;

public class Provider2 extends GeneralProvider{

    @Override
    public String defineBaseUrl() {
        return "https://second-payment-provider/cards/pay";
    }

    @Override
    public String defineProviderName() {
        return "Other Provider";
    }

    @Override
    public void mapExpDate(String rawExpDate) {
        this.setExpDate(rawExpDate.substring(0,2) + "/" + rawExpDate.substring(2));
    }

    @Override
    public String defineApiNumberParamName() {
        return "source";
    }

    @Override
    public String defineApiDestinationParamName() {
        return "target";
    }

    @Override
    public String defineApiCvv2ParamName() {
        return "cvv2";
    }

    @Override
    public String defineApiExpDateParamName() {
        return "expire";
    }

    @Override
    public String defineApiPin2ParamName() {
        return "pin2";
    }

    @Override
    public String defineApiDebitParamName() {
        return "amount";
    }

}
