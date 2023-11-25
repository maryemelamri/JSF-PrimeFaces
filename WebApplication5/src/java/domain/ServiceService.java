/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entities.Service;
import abstractFacade.AbstractFacade;
/**
 *
 * @author casper
 */
public class ServiceService extends AbstractFacade<Service> {

    public ServiceService(Class<Service> entityClass) {
        super(entityClass);
    }
    
}