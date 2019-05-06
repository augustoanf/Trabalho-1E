
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Telmo Junior
 */

@Entity
@Table(name = "receituario")
public class Receituario implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_item_servico", sequenceName = "seq_item_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_item_servico", strategy = GenerationType.SEQUENCE)   
    private Integer id;
    
    @NotNull(message = "A posologia deve ser informada")
    @NotBlank(message = "A posologia não pode ser em branco")
    @Length(max = 50, message = "A posologia não pode ter mais que {max} caracteres")
    @Column(name = "posologia", nullable = false)
    private String posologia;
    
    @NotNull(message = "A validade  não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    
    @NotNull(message = "A consulta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_receituario_consulta"))   
    private Consulta consulta;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "registros",
            joinColumns = 
            @JoinColumn(name = "id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "medicamento", referencedColumnName = "id", nullable = false)) 
    private Set<Medicamento> medicamento;
    
    public Receituario(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Set<Medicamento> getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Set<Medicamento> medicamento) {
        this.medicamento = medicamento;
    }
    
        @Override
    public int hashCode() {
        int hash = 7;
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
