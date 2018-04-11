package ro.mindit.forum.domain;

import java.io.Serializable;

/**
 * User domain class
 *
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
public class User implements Serializable {
    int id;
    private String userName;
    private String email;
    private String password;

    public User() {
    }

    public User(int id,String userName, String email, String password) {
        this.id=id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
