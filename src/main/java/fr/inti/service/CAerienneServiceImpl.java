package fr.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.inti.dao.ICAerienneDao;
import fr.inti.entities.CargaisonAerienne;
import fr.inti.entities.Marchandise;

@Service
@Transactional
public class CAerienneServiceImpl implements ICAerienneService {
	
	@Autowired
	private ICAerienneDao cAerienneDao;

	@Override
	public List<CargaisonAerienne> getAllCAeriennes() {
		System.out.println("service, liste CA");
		return cAerienneDao.getAllCAeriennes();
	}

	@Override
	public CargaisonAerienne addCAerienne(CargaisonAerienne CAerienneIn) {
		System.out.println("service ajout CA");
		return cAerienneDao.addCAerienne(CAerienneIn);
	}

	@Override
	public CargaisonAerienne getCAerienne(int idIn) {
		System.out.println("service, getOne CA");
		return cAerienneDao.getCAerienne(idIn);
	}

	@Override
	public CargaisonAerienne updateCAerienne(CargaisonAerienne CAerienneIn) {
		return cAerienneDao.updateCAerienne(CAerienneIn);
	}

	@Override
	public boolean deleteCAerienne(int idIn) {
		
		CargaisonAerienne check = cAerienneDao.deleteCAerienne(idIn);
		
		if (check != null) {
			return true;
		}else {
			return false;
		}
	
	}
//
//	@Override
//	public void addMarchandise(Marchandise march, String refCarg) {
//		cAerienneDao.addMarchandise(march, refCarg);
//	}
//
//	@Override
//	public List<Marchandise> getMarchParCarg(String refCarg) {
//		return cAerienneDao.getMarchParCarg(refCarg);
//	}
//
//	@Override
//	public void addCargaison(CargaisonAerienne carg) {
//		addCargaison(carg);
//		
//	}

}
