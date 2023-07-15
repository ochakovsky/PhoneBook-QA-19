package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class User {
    String email;
    String password;

//    public String getEmail() {
//        return email;
//    }
//    public String getPassword() {
//        return password;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public User withEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public User withPassword(String password) {
//        this.password = password;
//        return this;
//    }


}
