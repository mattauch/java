package com.softgraf.exemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PercorreLista {

	public static void main(String[] args) {
		List<String> frutas = new ArrayList<String>();

		frutas.add("uva");
		frutas.add("maçã");
		frutas.add("banana");
		frutas.add("laranja");
		frutas.add("kiwi");

		System.out.println("\nPercorrendo a lista com o for normal"); // precisa saber o índice
		for (int i = 0; i < frutas.size(); i++) {
			System.out.println(frutas.get(i));
		}

		System.out.println("\nPercorrendo a lista com for each"); // não precisa saber o índice
		for (String f : frutas) {
			System.out.println(f);
		}

		// a partir do java 8
		System.out.println("\nPercorrendo a lista com for each funcional");//não usa variável
		frutas.forEach(System.out::println);//forEach = função dentro da lista - não precisa da variável
		//:: println é executado dentro do forEach que é executado dentro da lista
		
		/*
		 * Programação estruturada, procedual ou imperativa - main
		 * Programação orientada a objetos - criar classes
		 * Programação funcional - não precisa de variável
		 */
		
		System.out.println("\nPercorrendo a coleção com Iterator");// precorre a lista sem saber índice, serve para listas, filas, pilhas, conjuntos.
		//obtém o iterator da lista
		Iterator<String> iterator = frutas.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
