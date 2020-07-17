package fr.inti.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;

@Repository
public class CRoutiereDao implements ICRoutiereDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<CargaisonRoutiere> getAllCRoutieres() {

		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		// requete HQL
		// List<CargaisonRoutiere> listeOut =
		// session.createCriteria(CargaisonRoutiere.class).list();

		String req = "FROM CargaisonRoutiere m";

		// get a query object
		Query query = session.createQuery(req);

		// send request et get back response
		return query.list();
		// return listeOut;
	}

	@Override
	public CargaisonRoutiere addCRoutiere(CargaisonRoutiere cRoutiereIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		session.save(cRoutiereIn);

		System.out.println("DAO, CargaisonRoutiere ajoutée: " + cRoutiereIn);

		return cRoutiereIn;
	}

	@Override
	public CargaisonRoutiere getCRoutiere(int idIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		CargaisonRoutiere cRoutiereFound = session.get(CargaisonRoutiere.class, idIn);

		System.out.println("DAO, CargaisonRoutiere trouvée: " + cRoutiereFound);

		return cRoutiereFound;
	}

	@Override
	public CargaisonRoutiere updateCRoutiere(CargaisonRoutiere cRoutiereIn) {
		// recuperer la session
		Session session = sessionfactory.getCurrentSession();

		session.update(cRoutiereIn);

		System.out.println("DAO, CargaisonRoutiere modifiée: " + cRoutiereIn);

		return cRoutiereIn;
	}

	@Override
	public CargaisonRoutiere deleteCRoutiere(int idIn) {
		try {
			// recuperer la session
			Session session = sessionfactory.getCurrentSession();

			CargaisonRoutiere cRoutiereOut = session.get(CargaisonRoutiere.class, idIn);

			session.delete(cRoutiereOut);

			System.out.println("DAO, CargaisonRoutiere Suprr: " + cRoutiereOut);

			return cRoutiereOut;

		} catch (HibernateException | IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		return null;
	}
//
//	@Override
//	public void addMarchandise(Marchandise marchandiseIn, String refCarg) {
//		// recuperer la session
//		Session session = sessionfactory.getCurrentSession();
//
//		String req = "FROM CargaisonRoutiere as cr WHERE cr.reference=:pRef";
//
//		Query query = session.createQuery(req);
//
//		query.setParameter("pRef", refCarg);
//
//		CargaisonRoutiere cargaisonRoutiere = (CargaisonRoutiere) query.getSingleResult();
//
//		System.out.println("DAO, CargaisonAerienne trouvée: " + cargaisonRoutiere);
//
//		marchandiseIn.setCargaisonRoutiere(cargaisonRoutiere);
//		;
//
//		session.save(marchandiseIn);
//
//	}
//
//	@Override
//	public List<Marchandise> getMarchParCarg(String refCarg) {
//		// recuperer la session
//		Session session = sessionfactory.getCurrentSession();
//
//		String req = "FROM CargaisonRoutiere as cr WHERE cr.reference=:pRef";
//
//		Query query = session.createQuery(req);
//
//		query.setParameter("pRef", refCarg);
//
//		CargaisonRoutiere cargaisonRoutiere = (CargaisonRoutiere) query.getSingleResult();
//
//		System.out.println("DAO, CargaisonAerienne trouvée: " + cargaisonRoutiere);
//
//		// requete HQL	
//		String req2 = "FROM Marchandise m WHERE m.cargaisonRoutiere=:pCRoutiere";
//
//		// get a query object
//		Query query2 = session.createQuery(req2);
//		
//		query2.setParameter("pCRoutiere", cargaisonRoutiere.getId());
//		
//		// send request et get back response
//		return query2.list();
//		
//
//	}
//
//	@Override
//	public void addCargaison(CargaisonRoutiere carg) {
//		Session session = sessionfactory.getCurrentSession();
//
//		session.save(carg);
//
//		System.out.println("DAO, CargaisonRoutiere ajoutée: " + carg);
//
//
//	}

}
