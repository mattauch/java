package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Automovel;
import model.JpaUtil;

@ManagedBean(name = "automovelBean") // nome opcional
@SessionScoped // padr�o: RequestScoped
//Todo managed Bean deve ter um construtor padr�o
public class AutomovelBean {

	private Automovel automovel;

	// Construtor padr�o obrigat�rio
	public AutomovelBean() {
		this.automovel = new Automovel();
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public String salvar(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		// Inicia a transa��o
		em.getTransaction().begin();

		em.persist(automovel);

		// Finaliza a transa��o
		em.getTransaction().commit();
		em.close();

		this.automovel = new Automovel();
		return "";
	}

	public String excluir(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		// Inicia a transa��o
		em.getTransaction().begin();

		// Anexa a entidade ao EntityManager
		Automovel auto = em.merge(automovel);
		em.remove(auto);

		// Finaliza a transa��o
		em.getTransaction().commit();
		em.close();
		
		return "";
	}
	
	public List<Automovel> getAutomoveis(){
		List<Automovel> lista;
		
		EntityManager em = JpaUtil.getEntityManager();
		//Cria uma consulta no EntityManager (banco de dados), usando linguagem JPQL
		//Java Persistence Query Language
		TypedQuery<Automovel> q = em.createQuery("SELECT a FROM Automovel a", Automovel.class);
		//Executa a consulta
		lista = q.getResultList();
		
		//Finaliza transa��o
		em.close();
		
		return lista;
	}

}
