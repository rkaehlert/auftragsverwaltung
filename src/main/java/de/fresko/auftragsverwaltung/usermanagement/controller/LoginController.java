package de.fresko.auftragsverwaltung.usermanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.usermanagement.service.FreskoUserService;
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
    FreskoUserService userService;

    private String username;
    private String password;
    private FreskoUser user;

    @Produces
    @LoggedInUser
    @SessionScoped
    @Named
    FreskoUser loggedInUser() {
        return user;
    }

    public LoginController() {
    }
    
    public String login() {
        user = userService.loginUser(username, password);
        if (user != null) {
            //return "myJobs?faces-redirect=true";
            return "listJobs?faces-redirect=true";
        }

        //Login fehlgeschlagen, Hinweis Meldung ausgeben
        String msg = "Login fehlgeschlagen.";

        FacesMessage m = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage("loginMessage", m);

        return "login.xhtml";
    }

    public FreskoUser getUser() {
        return user;
    }

    public String editUser() {
        return Pages.USER_EDIT;
    }

    public String logout() {
        return "login.xhtml";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
