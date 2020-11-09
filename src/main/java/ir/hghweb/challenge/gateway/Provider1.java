package ir.hghweb.challenge.gateway;

public class Provider1 extends GeneralProvider{

    @Override
    public String defineBaseUrl() {
        return "https://first-payment-provider/payments/transfer";
    }

    @Override
    public String defineProviderName() {
        return "Bank Meli";
    }

    @Override
    public void mapExpDate(String rawExpDate) {
            this.setExpDate(rawExpDate);
    }

    @Override
    public String defineApiNumberParamName() {
        return "source";
    }

    @Override
    public String defineApiDestinationParamName() {
        return "dest";
    }

    @Override
    public String defineApiCvv2ParamName() {
        return "cvv2";
    }

    @Override
    public String defineApiExpDateParamName() {
        return "expDate";
    }

    @Override
    public String defineApiPin2ParamName() {
        return "pin";
    }

    @Override
    public String defineApiDebitParamName() {
        return "amount";
    }

}
