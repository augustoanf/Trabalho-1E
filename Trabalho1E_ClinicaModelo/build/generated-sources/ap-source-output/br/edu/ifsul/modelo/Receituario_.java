package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Receituario.class)
public abstract class Receituario_ {

	public static volatile SetAttribute<Receituario, Medicamento> medicamento;
	public static volatile SingularAttribute<Receituario, Integer> id;
	public static volatile SingularAttribute<Receituario, Consulta> consulta;
	public static volatile SingularAttribute<Receituario, String> posologia;
	public static volatile SingularAttribute<Receituario, Calendar> validade;

	public static final String MEDICAMENTO = "medicamento";
	public static final String ID = "id";
	public static final String CONSULTA = "consulta";
	public static final String POSOLOGIA = "posologia";
	public static final String VALIDADE = "validade";

}

