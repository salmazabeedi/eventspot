/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.util.HashMap;

/**
 *
 * @author abodn
 */
public class userandpass {
     HashMap <String,String> logininfo=new HashMap<String,String>();
     public userandpass(){
         
     }
      public void creat(String user,String pass){
       
            logininfo.put(user,pass);
    }
      public boolean checkLogin(String user,String pass){
           if(logininfo.containsKey(user)){
                 if(logininfo.get(user).equals(pass)){
                
                  System.out.println("Login successful");
                   return true;
                
                  }
                
                 else{
                  
                  System.out.println("Wrong password");
                   }
             }
         
          else{
            
              System.out.println("ID not found");
          }
           return false;
      }
    
}
