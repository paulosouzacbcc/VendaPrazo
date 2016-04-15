/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Cliente;
import model.dao.ClienteDao;
import util.Conexao;

/**
 *
 * @author Paulo Soza
 */
public class ControllerCliente {

    public void saveCliente(Cliente cliente) {
        boolean save = false;

        ClienteDao clienteDao = new ClienteDao();

        save = clienteDao.salvar(cliente);

        if (save) 
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        else JOptionPane.showMessageDialog(null, "Erro ao Salvar");

    }

}
