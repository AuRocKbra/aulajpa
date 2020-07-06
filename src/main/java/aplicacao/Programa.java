package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Os ids são nulos pq serão controlados pelo banco de dados
		//Procedimento usado para realizar o insert no banco de dados na tabela que será criada, caso seja a primeira vez executando
		//o programa, ou somente realizando o insert se a tabela já estiver criada.
		/*
		Pessoa p1 = new Pessoa(null, "Carlos da Silva","carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Silva de Carlos","silva@gmail.com");
		Pessoa p3 = new Pessoa(null, "Solrac e Avlis","sol@gmail.com");
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		*/
		Pessoa p = em.find(Pessoa.class, 2);//Realiza busca no banco na tabela da referida classe, usando como chave o ID
		
		System.out.println(p);
		
		em.close();
		emf.close();
	}

}
