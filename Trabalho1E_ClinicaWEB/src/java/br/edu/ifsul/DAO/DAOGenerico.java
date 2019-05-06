/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 20171PF.CC0119
 */
public class DAOGenerico<Type> implements Serializable {

    @PersistenceContext(unitName = "Trabalho_1EPU")
    protected EntityManager em;
    protected Class classePersistente;
    private List<Type> listaObjetos;
    private List<Type> listaTodos;

    public DAOGenerico(Class classePersistente) {
        this.classePersistente = classePersistente;
    }

    public List<Type> getListaObjetos() {
        String jpql = String.format("from %s", classePersistente.getSimpleName());
        return em.createQuery(jpql).getResultList();
    }
    
    public List<Type> getListaTodos() {
            String jpql = "from " + classePersistente.getSimpleName();
            
            return em.createQuery(jpql).getResultList();
    }
    
    public void persist(Type obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Type obj) throws Exception {
        em.merge(obj);
    }
    
    public void remover(Type obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }

    public Type getObjectById(Object id) throws Exception {
        System.out.println(em.find(classePersistente, id));
        return (Type) em.find(classePersistente, id);
        
    }

   public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void setListaObjetos(List<Type> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public Class getClassePersistente() {
        return classePersistente;
    }

    public void setClassePersistente(Class classePersistente) {
        this.classePersistente = classePersistente;
    }
}
