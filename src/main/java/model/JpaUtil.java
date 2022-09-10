package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/*
 * Projeto Maven -> POM: esse arquivo baixa todas as bibliotecas ap�s a configura��o correta.
 * 
 * 
 *EntityManager: � um servi�o respons�vel por gerenciar as entidades (tabelas), atrav�s dele � poss�vel gerenciar 
 *o ciclo de vida das entidades, opera��o de sincroniza��o com a base de dados (inserir, atualizar ou remover), consultar entidades e outros. 
 *
 *Cria o relacionamento das classes (objetos) com o banco de dados. A comunica��o se da pelo id.
 *
 *Voc� trabalha com o EntityManager, n�o com o banco em si.
 *
 *EntityManagerFactory-> classe para gerar objetos para n�o utilizar o new (padroniza��o dos objetos)
 *
 */

public class JpaUtil {
		
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("automoveis_pu");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
		
	
	}

}

