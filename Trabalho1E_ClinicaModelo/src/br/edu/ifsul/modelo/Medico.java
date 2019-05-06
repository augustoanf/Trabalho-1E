
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author Telmo Junior
 */

@Entity
@Table
@DiscriminatorValue(value = "md")
public class Medico extends Paciente implements Serializable {
    
    @Column(name = "crm", length = 14, nullable = false)
    private String crm;
    
    @NotNull(message = "A especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_especialidade_id"))
    private Especialidade especialidade;//cidade associação
    
    
    public Medico(){
        super();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
