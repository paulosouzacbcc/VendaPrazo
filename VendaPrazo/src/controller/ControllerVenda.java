/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import jpa.VendaJpaController;
import model.Venda;
import util.Conexao;

/**
 *
 * @author maverick
 */
public class ControllerVenda {

    public boolean save(Venda venda) {

        try {
            VendaJpaController vendaJpaController = new VendaJpaController(Conexao.conectar());
            vendaJpaController.create(venda);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
