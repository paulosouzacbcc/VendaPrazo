/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import jpa.ClienteJpaController;
import model.Cliente;
import util.Conexao;

/**
 *
 * @author Paulo Soza
 */
public class ClienteDao extends ClienteJpaController{
    
    public ClienteDao() {
        super(Conexao.conectar());
    }
    
    public List<Cliente> selectAllClienteASCName(){
        
        
        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.nome ASC ");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
        
    }
    
    public void salvar(Cliente cliente){
        
        try {
            ClienteJpaController clienteJpaController = new ClienteJpaController(Conexao.conectar());
            clienteJpaController.create(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
