/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import jpa.VendaJpaController;
import model.Venda;
import model.dao.VendaDao;
import util.Alert;
import util.Conexao;

/**
 *
 * @author maverick
 */
public class ControllerVenda
{

    public boolean save(Venda venda) {

        try {
            VendaJpaController vendaJpaController = new VendaJpaController(Conexao.conectar());
            vendaJpaController.create(venda);
            Alert.sucess("Salvo com Sucesso!", "Nova Venda");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editar(Venda venda) {
        try {
            VendaJpaController vendaJpaController = new VendaJpaController(Conexao.conectar());
            vendaJpaController.edit(venda);
            Alert.sucess("Editado com Sucesso!", "Nova Venda");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Venda getVendaById(int id) {

        try {
            VendaDao vendaDao = new VendaDao();
            return vendaDao.selectVendaById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Venda> getVendaList() {
        try {
            VendaDao vendaDao = new VendaDao();
            return vendaDao.selectVendaListASC();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
