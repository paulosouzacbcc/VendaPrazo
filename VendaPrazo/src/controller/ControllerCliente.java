/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.dao.ClienteDao;
import util.Conexao;

/**
 *
 * @author Paulo Soza
 */
public class ControllerCliente {
    
    public boolean saveCliente(Cliente cliente){
        
        
        ClienteDao clienteDao = new ClienteDao();
        try {
            clienteDao.salvar(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
}
