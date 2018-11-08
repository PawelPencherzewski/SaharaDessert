/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Mark
 */
public class RemoteControl {
    Command command;
    
    public RemoteControl(){
    
}
    public void setCommand(Command command){
        this.command = command;
    }
    
    public void runCommand(){
        command.execute();
    }
    
}
