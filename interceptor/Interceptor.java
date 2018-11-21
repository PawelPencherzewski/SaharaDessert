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
public interface Interceptor {
    
    public void onPreMarshalRequest(UnMarshaledRequest context);
    
    public void onPostMarshalRequest(MarshaledRequest context);
}
