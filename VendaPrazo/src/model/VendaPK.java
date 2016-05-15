/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author maverick
 */
@Embeddable
public class VendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idVenda")
    private int idVenda;
    @Basic(optional = false)
    @Column(name = "Cliente_idCliente")
    private int clienteidCliente;

    public VendaPK() {
    }

    public VendaPK(int idVenda, int clienteidCliente) {
        this.idVenda = idVenda;
        this.clienteidCliente = clienteidCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(int clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVenda;
        hash += (int) clienteidCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaPK))
            return false;
        VendaPK other = (VendaPK) object;
        if (this.idVenda != other.idVenda)
            return false;
        if (this.clienteidCliente != other.clienteidCliente)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "model.VendaPK[ idVenda=" + idVenda + ", clienteidCliente=" + clienteidCliente + " ]";
    }

}
