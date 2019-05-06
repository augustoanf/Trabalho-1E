/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.DAO.MedicoDAO;
import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.inject.Named;
import br.edu.ifsul.util.Util;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author 20171PF.CC0119
 */
@Named(value = "controleMedico")
@SessionScoped
public class ControleMedico implements Serializable{

    @EJB
    private MedicoDAO dao;
    
    private Medico objeto;

    public ControleMedico() {

    }

    public String listar() {
        return "/privado/medico/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Medico();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "
                    + Util.getMensagemErro(e));
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

    public MedicoDAO getDao() {
        return dao;
    }

    public Medico getObjeto() {
        return objeto;
    }
}
