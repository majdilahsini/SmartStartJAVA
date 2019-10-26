/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Objects;

/**
 *
 * @author firos
 */
public class users {
    private int id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String tel;
    private String adresse;
    private String role;


    public users(String username, String password, String email, String fullname, String tel, String adresse, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.tel = tel;
        this.adresse = adresse;
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
 public users() {
    }
    public users(int id, String username, String password, String email, String tel, String adresse, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.role = role;
    }

    public users(String username, String password, String email, String tel, String adresse, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.role = role;
    }

    public users(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public users(String email, String tel, String adresse) {
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "users{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", tel=" + tel + ", adresse=" + adresse + ", role=" + role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final users other = (users) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }

   
    
}
