package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory emf;

	//inicializador est�tico: os blocos est�ticos s�o rodados autom�ticamente (conex�o com o banco)
	//Carrega na mem�ria o persistence.xml
	//se tiver mais de um bloco eles ser�o executados na ordem
	static {
		System.out.println("Rodou o inicializador est�tico do JpaUtil");
		emf = Persistence.createEntityManagerFactory("editora_pu");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}
