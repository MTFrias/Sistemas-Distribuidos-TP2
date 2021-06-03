/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.SessionBean;
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
    
    @EJB
    SessionBean userSession = new SessionBean();
    
    List<Utilizadores> UserList = new ArrayList<>();

    Utilizadores newUser = new Utilizadores();
    String nome;
    String email;
    String password;
    String salt = "123456789abcdef123456789abcdef";
    String confirmpassword;

    public SessionBean getUserSession() {
        return userSession;
    }

    public void setUserSession(SessionBean userSession) {
        this.userSession = userSession;
    }

    
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
        newUser.setIdTipo(2);
        
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
    public void logout(){
        userSession.setEmail("");
        userSession.setId(0);
        userSession.setPassword("");
    }
    public void login(){ 
        UserList = getUserList();
        for(Utilizadores item: UserList){
            if(item.getEmail().equals(email) && item.getPassword().equals(PBKDF2.hashPassword("sha512", password, 1000, 512))){
                userSession.setEmail(item.getEmail());
                userSession.setId(item.getIdUtilizador());
                userSession.setPassword(item.getPassword());
                System.out.println("Nome: " + item.getNome());
                break;
            }
        }
    }
}
