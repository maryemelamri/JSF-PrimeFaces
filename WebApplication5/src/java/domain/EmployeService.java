/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractFacade.AbstractFacade;
import entities.Employe;

/**
 *
 * @author casper
 */
public class EmployeService extends AbstractFacade<Employe> {

    @Override
    protected Class getEntityClass() {
        return Employe.class;
    }

}
