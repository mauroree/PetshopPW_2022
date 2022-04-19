/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.pw.petshop_pw2022;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Mauro
 */
@Entity
@Table(name = "ordemServico")
public class OrdemServico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_ordemServico", sequenceName = "seq_ordemServico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informado")
    @Column(name = "data", nullable = false)
    private Calendar data;

    @NotBlank(message = "O valor não pode ser em branco")
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @NotBlank(message = "A pessoa não pode ficar em branco")
    @Length(max = 50, message = "A Pessoa não pode ter mais que {max} caracteres")
    @Column(name = "pessoa", nullable = false, length = 20)
    private Pessoa pessoa;

    @NotBlank(message = "O Pet não pode estar em branco")
    @Length(max = 20, message = "O pet não pode ter mais que {max} caracteres")
    @Column(name = "pet", nullable = false, length = 20)
    private Pet pet;

    @NotBlank(message = "O Funcionario não pode estar em branco")
    @Length(max = 50, message = "O Funcionario não pode ter mais que {max} caracteres")
    @Column(name = "funcionario", nullable = false, length = 20)
    private Funcionario funcionario;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itemServicos = new ArrayList<>();

    public OrdemServico() {

        this.data = Calendar.getInstance();
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
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
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * @param pet the pet to set
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final OrdemServico other = (OrdemServico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
