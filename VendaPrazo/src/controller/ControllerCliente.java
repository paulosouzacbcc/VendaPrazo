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

/**
 *
 * @author Paulo Soza
 */
public class ControllerCliente {

    public void saveCliente(Cliente cliente) {
        boolean save = false;

        ClienteDao clienteDao = new ClienteDao();

        //TODO colocar exception espesificas revisar isso aqui
        try {
            save = clienteDao.salvar(cliente);
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar, não aceita letras com numeros");
        }

    }

    public List<Cliente> getListClientesASC() {

        try {
            ClienteDao clienteDao = new ClienteDao();
            return clienteDao.selectAllClienteASCName();
        } catch (Exception e) {
            System.out.println("Error buscar list cliente");
        }
        return null;
    }

    public List<Cliente> getListClienteByNome(String nome) {
        try {
            ClienteDao clienteDao = new ClienteDao();
            return clienteDao.selectClienteByName(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente getClienteByName(String nome) {

        try {
            ClienteDao clienteDao = new ClienteDao();
            return clienteDao.selectClienteByNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
