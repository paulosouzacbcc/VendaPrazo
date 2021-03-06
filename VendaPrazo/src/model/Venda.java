/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maverick
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.vendaPK.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByClienteidCliente", query = "SELECT v FROM Venda v WHERE v.vendaPK.clienteidCliente = :clienteidCliente"),
    @NamedQuery(name = "Venda.findByValor", query = "SELECT v FROM Venda v WHERE v.valor = :valor"),
    @NamedQuery(name = "Venda.findByObservacao", query = "SELECT v FROM Venda v WHERE v.observacao = :observacao"),
    @NamedQuery(name = "Venda.findByData", query = "SELECT v FROM Venda v WHERE v.data = :data"),
    @NamedQuery(name = "Venda.findByStatus", query = "SELECT v FROM Venda v WHERE v.status = :status")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendaPK vendaPK;
    @Basic(optional = false)
    @Column(name = "Valor")
    private double valor;
    @Column(name = "Observacao")
    private String observacao;
    @Basic(optional = false)
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Status")
    private int status;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Venda() {
    }

    public Venda(VendaPK vendaPK) {
        this.vendaPK = vendaPK;
    }

    public Venda(VendaPK vendaPK, double valor, Date data, int status) {
        this.vendaPK = vendaPK;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public Venda(int idVenda, int clienteidCliente) {
        this.vendaPK = new VendaPK(idVenda, clienteidCliente);
    }

    public VendaPK getVendaPK() {
        return vendaPK;
    }

    public void setVendaPK(VendaPK vendaPK) {
        this.vendaPK = vendaPK;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendaPK != null ? vendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda))
            return false;
        Venda other = (Venda) object;
        if ((this.vendaPK == null && other.vendaPK != null) || (this.vendaPK != null && !this.vendaPK.equals(other.vendaPK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "model.Venda[ vendaPK=" + vendaPK + " ]";
    }

}
