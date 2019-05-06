/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.DAO.PacienteDAO;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.inject.Named;
import br.edu.ifsul.util.Util;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author 20171PF.CC0119
 */
@Named(value = "controlePaciente")
@SessionScoped
public class ControlePaciente implements Serializable {

    @EJB
    private PacienteDAO dao;
    
    private Paciente objeto;

    public ControlePaciente() {

    }

    public String listar() {
        return "/privado/paciente/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Paciente();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public PacienteDAO getDao() {
        return dao;
    }

    public Paciente getObjeto() {
        return objeto;
    }
}
