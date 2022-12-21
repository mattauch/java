package com.softgraf.primavera.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softgraf.primavera.data.entity.Cliente;
import com.softgraf.primavera.data.projection.ClienteProjection;

/*
 * JpaRepository extends [PagingAndSortingRepository extends [CrudRepository extends Repository]
 * Logo JPA Repository é a interface que herda mais métodos
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	// ----- Métodos personalizados com base no find -------
	
	//cria um método para buscar um cliente por nome
	List<Cliente> findByNome (String nome);
	
	//cria método para buscar nome que contenha nome específico
	List<Cliente> findByNomeContaining(String nome);
	
	//cria um método para buscar cliente por email
	List<Cliente> findByEmailContaining(String email);
	
	//busca por ordenação
	List<Cliente> findByNomeOrderByNomeAsc(String nome);
	List<Cliente> findByNomeContaining(String nome, Sort sort); //SPRING DATA

	
	//busca com classe alinhada (@Embledded)
	List<Cliente> findByEndereco_Cidade (String cidade); //nome da cidade deve estar completo
	List<Cliente> findByEndereco_BairroContaining (String bairro); //busca parcial
	List<Cliente> findByEndereco_EstadoContaining (String estado); //busca parcial
	List<Cliente> findByEndereco_CepContaining (String cep); //busca parcial
	
	//busca com paginação
	Page<Cliente> findAll(Pageable pageable);
	
	//Queries JPQL                                     //variável
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Pageable pageable);
	//findByNome("Joao da Silva", page)
	
	//Queries                                      //variável
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Sort sort);
	
	//consulta SQL nativa
	@Query(value="SELECT c.id, c.nome, c.email FROM Cliente c", nativeQuery = true)
	List<ClienteProjection> findClienteProjecao();
	
	/*EXEMPLOS DE CONSULTAS
- LIKE
	String nome = "%maria%";
	List<Cliente> findByNomeLike(String nome);
	
- STARTING e ENDING
	List<CLiente> findByNomeStartingWith(String nome);
	List<CLiente> findByNomeEndingWith(String nome);
	
- NULL e NOT NULL
	List<CLiente> findByNomeIsNull(); todos os nomes nulos
	List<Cliente> findByNomeIsNotNull(); todos os nomes não nulos
	
- FORMATAÇÃO DE DATA
	DateTimeFormtter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate data = LocalDate.parse("26/11/2022", formatador)
	
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nome AND c.dataCadastro = :data")
	List<Cliente> findNomeDataCadastro(@Param("nome") String nome, @Param("data") LocalDate data)
	
- NATIVEQUERY
	@Query(values='SELECT * FROM Cliente WHERE nome=?1", nativeQuery=true)
	List<Cliente> findByNome(String nome);
	
	Sites:
	www.baeldung.com/spring-data-jpa-query
	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa-query-methods

	 */
}
