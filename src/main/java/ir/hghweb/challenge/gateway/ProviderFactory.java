package ir.hghweb.challenge.gateway;

public class ProviderFactory {
    public static GeneralProvider getProvider(String number){
        if(number.substring(5).equals("6037")){
            return new Provider1();
        }else {
            return new Provider2();
        }
    }
}
