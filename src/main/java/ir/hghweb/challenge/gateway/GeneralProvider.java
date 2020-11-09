package ir.hghweb.challenge.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;

public abstract class GeneralProvider implements GeneralProviderInterface{

    @Autowired
    RestTemplate restTemplate;

    private String providerName;

    private String baseUrl;

    private String apiNumberParamName;
    private String apiDestinationParamName;
    private String apiCvv2ParamName;
    private String apiExpDateParamName;
    private String apiPin2ParamName;
    private String apiDebitParamName;

    private String number;
    private String destination;
    private String cvv2;
    private String expDate;
    private String pin2;
    private Integer debit;

    public GeneralProvider() {
        this.baseUrl = this.defineBaseUrl();
        this.providerName = this.defineProviderName();
        this.apiNumberParamName = this.defineApiNumberParamName();
        this.apiDestinationParamName = this.defineApiDestinationParamName();
        this.apiCvv2ParamName = this.defineApiCvv2ParamName();
        this.apiExpDateParamName = this.defineApiExpDateParamName();
        this.apiPin2ParamName = this.defineApiPin2ParamName();
        this.apiDebitParamName = this.defineApiDebitParamName();
    }

    public ResponseEntity transfer(String number, String destination, String cvv2, String expDate, String pin2, Integer debit){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add(this.getApiNumberParamName(), this.getNumber());
        map.add(this.getApiCvv2ParamName(), this.getCvv2());
        map.add(this.getApiDestinationParamName(), this.getDestination());
        map.add(this.getApiExpDateParamName(), this.getExpDate());
        map.add(this.getApiPin2ParamName(), this.getPin2());
        map.add(this.getApiDebitParamName(), String.valueOf(this.getDebit()));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( this.baseUrl, request , String.class );
        return response;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getApiNumberParamName() {
        return apiNumberParamName;
    }

    public void setApiNumberParamName(String apiNumberParamName) {
        this.apiNumberParamName = apiNumberParamName;
    }

    public String getApiDestinationParamName() {
        return apiDestinationParamName;
    }

    public void setApiDestinationParamName(String apiDestinationParamName) {
        this.apiDestinationParamName = apiDestinationParamName;
    }

    public String getApiCvv2ParamName() {
        return apiCvv2ParamName;
    }

    public void setApiCvv2ParamName(String apiCvv2ParamName) {
        this.apiCvv2ParamName = apiCvv2ParamName;
    }

    public String getApiExpDateParamName() {
        return apiExpDateParamName;
    }

    public void setApiExpDateParamName(String apiExpDateParamName) {
        this.apiExpDateParamName = apiExpDateParamName;
    }

    public String getApiPin2ParamName() {
        return apiPin2ParamName;
    }

    public void setApiPin2ParamName(String apiPin2ParamName) {
        this.apiPin2ParamName = apiPin2ParamName;
    }

    public String getApiDebitParamName() {
        return apiDebitParamName;
    }

    public void setApiDebitParamName(String apiDebitParamName) {
        this.apiDebitParamName = apiDebitParamName;
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

    public String getPin2() {
        return pin2;
    }

    public void setPin2(String pin2) {
        this.pin2 = pin2;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }
}
