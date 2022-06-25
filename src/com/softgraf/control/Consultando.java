package com.softgraf.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.softgra.entity.Cliente;
import com.softgra.entity.Endereco;
import com.softgra.util.JpaUtil;

public class Consultando {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		//buscar o cliente contendo a palavra "silva"
		//''= String do banco
		//%% = tudo q vem antes e depois da String
		TypedQuery<Cliente> querySilva = em.createQuery("Select c from Cliente c where c.nome like '%Silva%'", Cliente.class); //like = similar
		List<Cliente> listaSilva = querySilva.getResultList();
		listaSilva.forEach(System.out::println);
		
		//buscando todos os endereços dos clientes
		List<Endereco> lista = em.createQuery("Select c.endereco from Cliente c where c.endereco.rua like '%Visconde%'", Endereco.class).getResultList();
		lista.forEach(System.out::println);
		
		//bucando apenas o nome da cidade do endereço 'Márcio'
		TypedQuery<String> querycidade = em.createQuery("select c.endereco.cidade from Cliente c where c.nome = 'Márcio Oliveira dos Santos'", String.class); 
		String cidade = querycidade.getSingleResult(); //quando há apenas um único retorno para sua consulta
		System.out.println(cidade);
		
		
		em.close();
		JpaUtil.close();

	}

}
