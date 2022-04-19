/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.pw.petshop_pw2022;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Mauro
 */
@Entity
@Table(name = "itemServico")
public class ItemServico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_itemServico", sequenceName = "seq_itemServico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_itemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "A quantidade não pode ser em branco")
    @Column(name = "quantidade", nullable = false)
    private Double quantidade;

    @NotBlank(message = "O valor unitário não pode ser em branco")
    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @NotBlank(message = "O valor total não pode ser em branco")
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @NotBlank(message = "O Serviço não pode estar em branco")
    @Length(max = 50, message = "O Serviço não pode ter mais que {max} caracteres")
    @Column(name = "servico", nullable = false, length = 20)
    private Servico servico;

    @NotNull(message = "A ordem de serviço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "ordemServico", referencedColumnName = "id", nullable = false)
    private OrdemServico ordemServico;

    public ItemServico() {

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**
     * @return the ordemServico
     */
    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    /**
     * @param ordemServico the ordemServico to set
     */
    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemServico other = (ItemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
