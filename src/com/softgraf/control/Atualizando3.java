package com.softgraf.control;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.softgra.entity.Cliente;
import com.softgra.entity.Pedido;
import com.softgra.util.JpaUtil;

public class Atualizando3 {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Cliente cliente = em.find(Cliente.class, 1);
		List<Pedido> pedidos = cliente.getPedidos();
		
		//mostra primeiro pedido
		Pedido pedido = pedidos.get(0);
		
		//mostra pedido
		System.out.println(pedido);
		
		//altera o pedido
		pedido.setData(new Date());
		
		
		
		tx.commit();
		
		em.close();
		JpaUtil.close();

	}

}
