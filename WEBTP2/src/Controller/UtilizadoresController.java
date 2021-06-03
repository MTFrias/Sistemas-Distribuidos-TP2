/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.UtilizadoresSessionBean;
import Entities.Utilizadores;
import Models.PBKDF2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author vinciusrodriguessilvacosta
 */
@Named (value = "UtilizadoresController") 
@RequestScoped
public class UtilizadoresController {
    
    @EJB
    UtilizadoresSessionBean users;
    List<Utilizadores> UserList = new ArrayList<>();

    Utilizadores newUser = new Utilizadores();
    String nome;
    String email;
    String password;
    String salt = "123456789abcdef123456789abcdef";
    String confirmpassword;

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    

    public Utilizadores getNewUser() {
        return newUser;
    }

    public void setNewUser(Utilizadores newUser) {
        this.newUser = newUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    
    public List<Utilizadores> getUserList() { 
        UserList = users.getUsers(); 
        return UserList;
    }
    
    public boolean validations(){
       
        newUser.setEmail(email);
        newUser.setNome(nome);
        
        if(!password.equals(confirmpassword)){
            return false;
        }
        
        newUser.setPassword(PBKDF2.hashPassword("sha512", password, 1000, 512));
        newUser.setSalt(salt);
        newUser.setDataRegisto(new Date());
        return true;
    }
    public void addUser(){ 
        if(validations()){
            users.addUser(newUser);
            newUser = new Utilizadores();
        }
    }
}
