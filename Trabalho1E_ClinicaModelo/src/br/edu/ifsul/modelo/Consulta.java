
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Telmo Junior
 */

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A data  não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_consulta", nullable = false)
    private Calendar dataConsulta;
    
    @NotNull(message = "A hora  não pode ser nula")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hora", nullable = false)
    private Calendar hora;
    
    @Lob @Basic(fetch=LAZY)
    @Column(name="preconsulta")
    private String preconsulta;
    
    @Lob @Basic(fetch=LAZY)
    @Column(name="posconsulta")
    private String posconsulta;
    
    @NotNull(message = "O médico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_consulta_medico"))
    private Medico medico;
    
    @NotNull(message = "O paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_consulta_paciente"))
    private Paciente paciente;
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
        orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exame;
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL,
        orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituario; //agregação por composição
    
    public Consulta(){
        
    }

    public void adicionarReceituario(Receituario obj) {
        obj.setConsulta(this);
        this.getReceituario().add(obj);
    }

    public void removerReceituario(int index) {
        Receituario obj = this.getReceituario().get(index);
        this.getReceituario().remove(index);
    }

    public void adicionarExame(Exame obj) {
        obj.setConsulta(this);
        this.getExame().add(obj);
    }

    public void removerExame(int index) {
        this.getExame().remove(index);
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return dataConsulta;
    }

    public void setData(Calendar data) {
        this.dataConsulta = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exames) {
        this.exame = exame;
    }

    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }
}
