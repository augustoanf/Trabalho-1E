/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author 20171PF.CC0119
 */
@Stateful
public class MedicoDAO extends DAOGenerico<Medico> implements Serializable {

    public MedicoDAO(){
        super(Medico.class);
    }
}