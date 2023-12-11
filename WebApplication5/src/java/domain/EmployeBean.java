/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractFacade.AbstractFacade;
import entities.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Lachgar
 */
@ManagedBean
@RequestScoped
public class EmployeBean extends AbstractFacade<Employe> {

    private Employe service;
    private List<Employe> services;
    
    
    public EmployeBean() {
        service =  new Employe();
        services = new ArrayList<>();
    }

    
    public void onCreationAction(){
        services.add(service);
        service = new Employe();
    }
    public Employe getEmploye() {
        return service;
    }

    public void setEmploye(Employe service) {
        this.service = service;
    }

    public List<Employe> getEmployes() {
        return services;
    }

    public void setEmployes(List<Employe> services) {
        this.services = services;
    }

    @Override
    protected Class<Employe> getEntityClass() {
return Employe.class;    }
    
    
    
}
