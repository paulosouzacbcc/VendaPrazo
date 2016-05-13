/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.ClienteJpaController;
import model.Cliente;
import util.Conexao;

/**
 *
 * @author Paulo Soza
 */
public class ClienteDao extends ClienteJpaController {

    public ClienteDao() {
        super(Conexao.conectar());
    }

    public List<Cliente> selectAllClienteASCName() {

        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.nome ASC ");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Cliente> selectClienteByName(String nome) {
        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome ORDER BY c.nome ASC ");
            query.setParameter("nome", nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Cliente selectClienteByNome(String nome) {

        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome");
            query.setParameter("nome", nome);
            return (Cliente) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean salvar(Cliente cliente) {

        try {
            ClienteJpaController clienteJpaController = new ClienteJpaController(Conexao.conectar());
            clienteJpaController.create(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //TODO verificar s
    public boolean editar(Cliente cliente) {
        try {
            ClienteJpaController clienteJpaController = new ClienteJpaController(Conexao.conectar());
            clienteJpaController.edit(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
