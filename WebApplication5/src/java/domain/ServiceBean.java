/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractFacade.AbstractFacade;
import com.sun.faces.action.RequestMapping;
import entities.Service;
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
public class ServiceBean extends AbstractFacade<Service>  {

    private Service service;
    private List<Service> services;
        private ServiceService serviceService;

    

    public ServiceBean() {
        service =  new Service();
        services = new ArrayList<>();
    }
    
    @Override
    public void create(Service entity) {
        super.create(entity);
        System.out.println("domain.ServiceBean.create()");}
    
    public void onCreationAction(){
        services.add(service);
        service = new Service();
        
    }
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Service> getServices() {
            if (services == null) {
            services = serviceService.findAll();
        }
        return services;

    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    protected Class<Service> getEntityClass() {
       return Service.class;
//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
