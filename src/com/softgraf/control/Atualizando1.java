package com.softgraf.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgra.entity.Cliente;
import com.softgra.entity.Endereco;
import com.softgra.util.JpaUtil;

public class Atualizando1 {

	public static void main(String[] args) {

		Endereco rua = new Endereco("Rua Doutor Colares, 123", "Ponta Grossa", "PR");
		Cliente luiz = new Cliente("Luiz Carlos", rua);

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		// inicia a transação
		tx.begin();

		// salva cliente
		em.persist(luiz);

		// confirma a transação
		tx.commit();

		em.close();
		JpaUtil.close();

	}

}
