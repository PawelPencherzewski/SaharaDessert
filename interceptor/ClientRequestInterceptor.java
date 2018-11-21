/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

/**
 *
 * @author Pawel
 */
public class ClientRequestInterceptor implements Interceptor{
    
    public ClientRequestInterceptor() {
        
    }
    
    @Override
    public void onPreMarshalRequest(UnMarshaledRequest context) {
        System.out.println(context.getObj() + " called");
    }
    
    @Override
    public void onPostMarshalRequest(MarshaledRequest context) {
        System.out.println(context.getObj() + " called");
    }
}
