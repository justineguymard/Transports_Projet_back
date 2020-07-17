package fr.inti.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Parameter;


import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.Marchandise;

@Repository
public class CAerienneDao implements ICAerienneDao {

	@Autowired
	SessionFactory sessionfactory;
	
	
	@Override
	public List<CargaisonAerienne> getAllCAeriennes() {

		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		// requete HQL
		//List<CargaisonAerienne> listeOut = session.createCriteria(CargaisonAerienne.class).list();
	
		String req = "FROM CargaisonAerienne m";

		// get a query object
		Query query = session.createQuery(req);

		// send request et get back response

		return query.list();
//		return listeOut;
	}
	

	@Override
	public CargaisonAerienne addCAerienne(CargaisonAerienne cAerienneIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		session.save(cAerienneIn);

		System.out.println("DAO, CargaisonAerienne ajoutée: " + cAerienneIn);

		return cAerienneIn;
	}

	@Override
	public CargaisonAerienne getCAerienne(int idIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		CargaisonAerienne cAerienneFound = session.get(CargaisonAerienne.class, idIn);

		System.out.println("DAO, CargaisonAerienne trouvée: " + cAerienneFound);

		return cAerienneFound;
	}

	@Override
	public CargaisonAerienne updateCAerienne(CargaisonAerienne cAerienneIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		session.update(cAerienneIn);

		System.out.println("DAO, CargaisonAerienne modifiée: " + cAerienneIn);
		
		return cAerienneIn;
	}

	@Override
	public CargaisonAerienne deleteCAerienne(int idIn) {
		try {
		//recuperer la session
		Session session = sessionfactory.getCurrentSession();
		
		CargaisonAerienne cAerienneOut = session.get(CargaisonAerienne.class, idIn);
		
		session.delete(cAerienneOut);
		
		System.out.println("DAO, CargaisonAerienne Suprr: " + cAerienneOut);
		 
		return cAerienneOut;
		
		} catch (HibernateException | IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		return null;
	}

//
//	@Override
//	public void addMarchandise(Marchandise march, String refCarg) {
//		// recuperer la session
//		Session session = sessionfactory.getCurrentSession();
//
//		String req = "FROM CargaisonAerienne as ca WHERE ca.reference=:pRef";
//		
//		Query query = session.createQuery(req);
//		
//		query.setParameter("pRef", refCarg);
//		
//		CargaisonAerienne cargaisonAerienne = (CargaisonAerienne) query.getSingleResult();
//
//		System.out.println("DAO, CargaisonAerienne trouvée: "+cargaisonAerienne);
//
//		march.setCargaisonAerienne(cargaisonAerienne);
//		
//		session.save(march);
//		
//	}
//
//
//	@Override
//	public List<Marchandise> getMarchParCarg(String refCarg) {
//		// recuperer la session
//		Session session = sessionfactory.getCurrentSession();
//
//		String req = "FROM CargaisonAerienne as ca WHERE ca.reference=:pRef";
//
//		Query query = session.createQuery(req);
//
//		query.setParameter("pRef", refCarg);
//
//		CargaisonAerienne cargaisonAerienne = (CargaisonAerienne) query.getSingleResult();
//
//		System.out.println("DAO, CargaisonAerienne trouvée: " + cargaisonAerienne);
//
//		// requete HQL	
//		String req2 = "FROM Marchandise m WHERE m.cargaisonAerienne=:pCAerienne";
//
//		// get a query object
//		Query query2 = session.createQuery(req2);
//		
//		query2.setParameter("pCAerienne", cargaisonAerienne.getId());
//		
//		// send request et get back response
//		return query2.list();
//	}
//
//
//	@Override
//	public void addCargaison(CargaisonAerienne carg) {
//		// recuperer la session
//		Session session = sessionfactory.getCurrentSession();
//
//		session.save(carg);
//
//		System.out.println("DAO, CargaisonAerienne ajoutée: " + carg);
//
//		
//	}

	
	
}
