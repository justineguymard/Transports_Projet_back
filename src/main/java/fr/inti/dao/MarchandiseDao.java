package fr.inti.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;
import fr.inti.service.ICAerienneService;
import fr.inti.service.ICRoutiereService;

@Repository
public class MarchandiseDao implements IMarchandiseDao {

	@Autowired
	SessionFactory sessionfactory;
	

	@Override
	public List<Marchandise> getAllMarchandises() {

		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		// requete HQL
//		List<Marchandise> listOut = session.createCriteria(Marchandise.class).list();
		
		String req = "FROM Marchandise m";

		// get a query object
		Query query = session.createQuery(req);

		// send request et get back response

		return query.list();
		//return listOut;
	}

	@Override
	public Marchandise addMarchandise(Marchandise marchandiseIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		session.save(marchandiseIn);

		System.out.println("DAO, Marchandise ajoutée: " + marchandiseIn);

		return marchandiseIn;
	}

	@Override
	public Marchandise getMarchandise(int idIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		Marchandise marchandiseFound = session.get(Marchandise.class, idIn);

		System.out.println("DAO, Marchandise trouvée: " + marchandiseFound);

		return marchandiseFound;
	}

	@Override
	public Marchandise updateMarchandise(Marchandise marchandiseIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		session.update(marchandiseIn);

		System.out.println("DAO, Marchandise modifiée: " + marchandiseIn);
		
		return marchandiseIn;
	}

	@Override
	public Marchandise deleteMarchandise(int idIn) {
		try {
		//recuperer la session
		Session session = sessionfactory.getCurrentSession();
		
		Marchandise marchandiseOut = session.get(Marchandise.class, idIn);
		
		session.delete(marchandiseOut);
		
		System.out.println("DAO, Marchandise Suprr: " + marchandiseOut);
		 
		return marchandiseOut;
		
		} catch (HibernateException | IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Marchandise assignCargaisonAerienne(Marchandise marchandiseIn, int idCarg) {
		// Récup la session
				Session session = sessionfactory.getCurrentSession();

				CargaisonAerienne cAerienne = session.get(CargaisonAerienne.class, idCarg);
				System.out.println("dao, assignation CA, CA trouvée : "+cAerienne);
				System.out.println("MARCHANDISE AVANT : "+marchandiseIn);
				
				if (cAerienne != null ) {
				// ecrire la requete HQ
					
				String req = "UPDATE Marchandise m SET m.cargaisonAerienne.id=:pIdCA WHERE m.id=:pId";

				// recuperer le query pour envoyer la requete hql
				Query query = session.createQuery(req);

				// passage des params
				query.setParameter("pIdCA", cAerienne.getId());
				query.setParameter("pId", marchandiseIn.getId());

				query.executeUpdate();
				
				return marchandiseIn;
				
				} else {
				return null;
				}
		
	}

	
	@Override
	public Marchandise assignCargaisonRoutiere(Marchandise marchandiseIn, int idCarg) {
		// Récup la session
		Session session = sessionfactory.getCurrentSession();

		CargaisonRoutiere cRoutiere = session.get(CargaisonRoutiere.class, idCarg);
		System.out.println("dao, assignation CR, CR trouvée : "+cRoutiere);
		System.out.println("MARCHANDISE AVANT : "+marchandiseIn);
		
		if (cRoutiere != null ) {
		// ecrire la requete HQ
			
		String req = "UPDATE Marchandise m SET m.cargaisonRoutiere.id=:pIdCR WHERE m.id=:pId";

		// recuperer le query pour envoyer la requete hql
		Query query = session.createQuery(req);

		// passage des params
		query.setParameter("pIdCR", cRoutiere.getId());
		query.setParameter("pId", marchandiseIn.getId());

		query.executeUpdate();
		
		return marchandiseIn;
		
		} else {
		return null;
		}
		
	}

	@Override
	public List<Marchandise> getMarchByCAerienne(String refCarg) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		//HQL request
		String req = "FROM Marchandise m WHERE m.cargaisonAerienne.reference=:pRef";

		// receuprer un query et envoyer la requete
		Query queryListeHQL = session.createQuery(req);

		queryListeHQL.setParameter("pRef", refCarg);

		// envoyer la requete + recuperer le resultat
		System.out.println("DAO, getMarchByCA, ref");

		return queryListeHQL.list();
//		
	}

	@Override
	public List<Marchandise> getMarchByCRoutiere(String refCarg) {
		// Récup la session
		Session session = sessionfactory.getCurrentSession();

		// ecrire la requete HQ
		String req = "FROM Marchandise m WHERE m.cargaisonRoutiere.reference=:pRef";

		// Recuperer un objet de type Query pour envoyer une requete HQL
		Query queryListeHQL = session.createQuery(req);

		queryListeHQL.setParameter("pRef", refCarg);

		// envoyer la requete et recuperer le resultat
		System.out.println("DAO, getMarchByCR, ref");

		return queryListeHQL.list();
		
		
		
	}


	@Override
	public List<Marchandise> getMarchByKeyword(String Keyword) {
		Session session = sessionfactory.getCurrentSession();
		System.out.println(Keyword + "Je suis dans début Dao");

		// Ecrire la requête HQL
		String reqListeHQL = "FROM Marchandise as m WHERE m.nom LIKE :filter";

		// Recuperer un objet de type Query pour envoyer une requete HQL
		Query queryListeHQL = session.createQuery(reqListeHQL);

		queryListeHQL.setParameter("filter", "%" + Keyword + "%");

		// envoyer la requete et recuperer le resultat
		System.out.println(Keyword + "Je suis dans fin Dao");
		System.out.println(queryListeHQL.list());

		return queryListeHQL.list();
		
	}
	

	
	
	
	



}
