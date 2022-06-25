package com.softgraf.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.softgra.entity.Pedido;
import com.softgra.util.JpaUtil;

public class Listando {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		//lista todos os pedidos da tabela (entidade) Pedido.
		//JPA usa JPQL (Java Persistence Query Linguage), mas também podemos usar SQL nativo.
		TypedQuery<Pedido> query = em.createQuery("from Pedido", Pedido.class); //linguagem JPQL
		List<Pedido> pedidos = query.getResultList();
		
			System.out.println("Lista de pedidos retornado");
			
			pedidos.forEach(System.out::println);
			
			/*for (Pedido p : pedidos) {
				System.out.println(p);
			}*/
	}

}
