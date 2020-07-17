package fr.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.inti.dao.ICRoutiereDao;
import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.CargaisonRoutiere;
import fr.inti.entities.Marchandise;

@Service
@Transactional
public class CRoutiereServiceImpl implements ICRoutiereService {
	
	@Autowired
	private ICRoutiereDao cRoutiereDao;

	@Override
	public List<CargaisonRoutiere> getAllCRoutieres() {
		System.out.println("service, liste CR");
		return cRoutiereDao.getAllCRoutieres();
	}

	@Override
	public CargaisonRoutiere addCRoutiere(CargaisonRoutiere CRoutiereIn) {
		System.out.println("service ajout CR");
		return cRoutiereDao.addCRoutiere(CRoutiereIn);
	}

	@Override
	public CargaisonRoutiere getCRoutiere(int idIn) {
		System.out.println("service, getOne CR");
		return cRoutiereDao.getCRoutiere(idIn);
	}

	@Override
	public CargaisonRoutiere updateCRoutiere(CargaisonRoutiere CRoutiereIn) {
		return cRoutiereDao.updateCRoutiere(CRoutiereIn);
	}

	@Override
	public boolean deleteCRoutiere(int idIn) {
		
		CargaisonRoutiere check = cRoutiereDao.deleteCRoutiere(idIn);
		
		if (check != null) {
			return true;
		}else {
			return false;
		}
	
	}

//	@Override
//	public void addMarchandise(Marchandise march, String refCarg) {
//		cRoutiereDao.addMarchandise(march, refCarg);
//		
//	}
//
//	@Override
//	public List<Marchandise> getMarchParCarg(String refCarg) {
//		
//		return cRoutiereDao.getMarchParCarg(refCarg);
//	}
//
//	@Override
//	public void addCargaison(CargaisonRoutiere carg) {
//		cRoutiereDao.addCargaison(carg);
//		
//	}

}


