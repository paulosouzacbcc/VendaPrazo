/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
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
    
    public List<Cliente> getListClientesASC(){
        
        try {
            ClienteDao clienteDao = new ClienteDao();
            return clienteDao.selectAllClienteASCName();
        } catch (Exception e) {
            System.out.println("Error buscar list cliente");
        }
        return null;
    }
    
    public List<Cliente> getListClienteByNome(String nome){
        try {
            ClienteDao clienteDao = new ClienteDao();
            return clienteDao.selectClienteByName(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
