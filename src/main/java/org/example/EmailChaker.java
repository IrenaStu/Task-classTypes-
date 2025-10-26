package org.example;
//Anaonymouse class
public class EmailChaker implements Validator<String>{
    @Override
     public boolean test (String email){
        return email != null
                && email.contains("@")
                && email.indexOf('@') < email.lastIndexOf('.');
    }
}
