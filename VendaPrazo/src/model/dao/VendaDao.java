/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.VendaJpaController;
import model.Venda;
import util.Conexao;

/**
 *
 * @author Paulo Soza
 */
public class VendaDao extends VendaJpaController {

    public static final int PAGO = 1;
    public static final int DEVENDO = 2;

    public VendaDao() {
        super(Conexao.conectar());
    }

    public Venda selectVendaById(int id) {

        try {

            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT v FROM Venda v WHERE v.vendaPK.idVenda = :id");
            query.setParameter("id", id);
            return (Venda) query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Venda> selectVendaListByStatus(int status) {

        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT v FROM Venda v WHERE v.status =:status ORDER BY v.data ASC");
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Venda> selectVendaListASC() {
        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT v FROM Venda v ORDER BY v.data ASC");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Venda> selectVendaListByName(String nome) {
        try {
            EntityManager entityManager = super.getEntityManager();
            Query query = entityManager.createQuery("SELECT v FROM Venda v WHERE v.cliente.nome LIKE :nome");
            query.setParameter("nome", nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
