/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author firos
 */
public class admin {
    int id;
    String username;
    String password;
    String email;
    int previliges;

    public admin() {
    }

    public admin(int id, String username, String password, String email, int previliges) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.previliges = previliges;
    }

    public admin(String username, String password, String email, int previliges) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.previliges = previliges;
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

    public int getPreviliges() {
        return previliges;
    }

    public void setPreviliges(int previliges) {
        this.previliges = previliges;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final admin other = (admin) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
