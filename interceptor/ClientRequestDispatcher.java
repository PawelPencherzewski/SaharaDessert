/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import java.util.ArrayList;
import payment.PaymentType;

/**
 *
 * @author Pawel
 */
public class ClientRequestDispatcher {
    ArrayList <Interceptor> interceptors = new ArrayList<Interceptor>();
    
    public void registerClientRequestInterceptor(ClientRequestInterceptor i) {
        interceptors.add(i);
    }
    
    public void removeClientRequestInterceptor(ClientRequestInterceptor i) {
        interceptors.remove(i);
    }
    
    public void dispatchClientRequestInterceptorPreMarshal(UnMarshaledRequest context) {
        for(int i = 0; i < interceptors.size(); i++){
            ClientRequestInterceptor ic = (ClientRequestInterceptor)interceptors.get(i);
            ic.onPreMarshalRequest(context);
        }
    }
    
    public void process(PaymentType pt) {
        pt.applyPay();
    }
}
