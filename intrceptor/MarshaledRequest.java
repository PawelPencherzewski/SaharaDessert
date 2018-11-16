/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intrceptor;

import java.util.ArrayList;

/**
 *
 * @author Pawel
 */
public class MarshaledRequest {
    
    String[] split = new String[3];;
    
    public MarshaledRequest(String message) {
        this.split = message.split(",");
    }
    
    public String[] getObj() {
        return split;
    }
        
}
