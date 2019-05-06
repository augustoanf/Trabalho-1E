
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Telmo Junior
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING, length = 2)
@DiscriminatorValue(value = "pc")
public class Paciente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "nome", length = 30)
    private String nome;
        
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "sexo", length = 1)
    private String sexo;
    
    @Column(name = "historico", columnDefinition = "TEXT")
    private String historico;
    
    @Column(name = "peso", columnDefinition = "numeric(12,2)", insertable = false, updatable = false)
    private Double peso;
    
    @Column(name = "peso", columnDefinition = "numeric(12,2)")
    private Double altura;
    
    public Paciente(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }
    
    public java.util.Date getNascimentoDate() {
        if(nascimento != null)
            return new java.util.Date(this.nascimento.getTimeInMillis());
        else
            return null;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }
    
    public void setNascimentoDate(java.util.Date nascimento) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(nascimento.getTime());
        this.nascimento = c;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
