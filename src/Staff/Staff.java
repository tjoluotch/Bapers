/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

/**
 *
 * @author Tweetie Pie
 */
public class Staff {
    String username;
    String forename;
    String surname;
    String role;

    public Staff(String username, String forename, String surname, String role) {
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }
    
    
    
}
