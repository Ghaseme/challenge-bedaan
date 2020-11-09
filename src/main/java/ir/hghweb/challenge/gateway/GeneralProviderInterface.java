package ir.hghweb.challenge.gateway;

public interface GeneralProviderInterface {

    public void mapExpDate(String rawExpDate);

    public String defineBaseUrl();

    public String defineProviderName();

    public String defineApiNumberParamName();

    public String defineApiDestinationParamName();

    public String defineApiCvv2ParamName();

    public String defineApiExpDateParamName();

    public String defineApiPin2ParamName();

    public String defineApiDebitParamName();
}
