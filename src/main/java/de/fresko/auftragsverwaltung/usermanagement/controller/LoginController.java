/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fresko.auftragsverwaltung.usermanagement.controller;

import de.fresko.auftragsverwaltung.usermanagement.boundary.UserService;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    UserService userService;

    private String email;
    private String password;
    private FreskoUser user;

    public FreskoUser getUser() {
        return user;
    }

    @Produces
    @SessionScoped
    @Named
    FreskoUser loggedInUser() {
        return user;
    }

    public String login() {
        user = userService.loginUser(email, password);

        if (user != null)
            return "myJobs?faces-redirect=true";

        //Login fehlgeschlagen, Hinweis Meldung ausgeben
        String msg = "Login fehlgeschlagen.";

        FacesMessage m = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage("loginMessage", m);

        return "login.xhtml";
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
