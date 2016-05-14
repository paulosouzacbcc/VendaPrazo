/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.RollbackException;
import jpa.ClienteJpaController;
import model.Cliente;
import model.dao.ClienteDao;
import util.Alert;
import util.Conexao;

/**
 *
 * @author Paulo Soza
 */
public class ControllerCliente
{

    boolean save = false;

    ClienteDao clienteDao = new ClienteDao();

    public boolean save(Cliente cliente) {

        try {
            ClienteJpaController clienteJpaController = new ClienteJpaController(Conexao.conectar());
            clienteJpaController.create(cliente);
            Alert.sucess("Salvo com sucesso!", "Novo cliente");
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Alert.error("Número não deve conter letras, verifique.", "Novo cliente");
        } catch (RollbackException re) {
            re.printStackTrace();
            Alert.error("Nome de Cliente já existe", "Novo cliente");
        }
        return false;

    }

    public boolean editar(Cliente cliente) {

        try {
            ClienteJpaController clienteJpaController = new ClienteJpaController(Conexao.conectar());
            clienteJpaController.edit(cliente);
            Alert.sucess("Editado com Sucesso!", "Editar cliente");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

    public Cliente getClienteById(int id) {

        try {
            ClienteDao clienteDao = new ClienteDao();
            return clienteDao.findCliente(id);
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
