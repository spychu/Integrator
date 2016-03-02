/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.skrzynkasmaku.integrator.wfirma.service;

import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;

/**
 *
 * @author Spychu
 */
public interface WFirmaService {

    public void add(Invoice invoice);
    
    public void add(String command);
}
