package com.softgraf.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgra.entity.Cliente;
import com.softgra.util.JpaUtil;

public class Atualizando2 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		tx.begin();
		
		//recupera o cliente luiz pelo ID
		Cliente cliente = em.find(Cliente.class, 8);
		cliente.setNome("Márcio Oliveira dos Santos");
		cliente.getEndereco().setRua("Rua Visconde de Inhauma, 130");
		
		tx.commit();
		
		
		
		em.close();
		JpaUtil.close();
	}

}
