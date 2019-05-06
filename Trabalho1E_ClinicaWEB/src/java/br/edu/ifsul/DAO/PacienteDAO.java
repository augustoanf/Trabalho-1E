/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateful;

/**
 *
 * @author 20171PF.CC0119
 */
@Stateful
public class PacienteDAO extends DAOGenerico<Paciente> implements Serializable {

    public PacienteDAO(){
        super(Paciente.class);
    }
    
    @Override
    public List<Paciente> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName() + " where tipo='pc'";
            
            return em.createQuery(jpql).getResultList();
    }
    
    /*@Override
    public Paciente getObjectById(Object id) throws Exception {
        return (Paciente) em.find(Paciente.class, id);
        
    }*/
    
    @Override
    public Paciente getObjectById(Object id) throws Exception {
        List<Paciente> alunos = getListaObjetos();
        System.out.println("ID: " + id);
        for(Paciente aluno : alunos)
            if(Objects.equals(aluno.getId(), id))
                return aluno;
        return alunos.get(0);
        
    }
}