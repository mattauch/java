package com.softgraf.control;

import javax.persistence.EntityManager;

import com.softgra.entity.Cliente;
import com.softgra.util.JpaUtil;

public class BuscandoPorId {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();

		Cliente cliente = em.find(Cliente.class, 1);

		if (cliente != null)
			System.out.println(cliente.getNome());
		else
			System.out.println("ID não encontrado");

		em.close();
		JpaUtil.close();

	}

}
