package fr.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.inti.dao.IMarchandiseDao;
import fr.inti.entities.Marchandise;

@Service
@Transactional
public class MarchandiseServiceImpl implements IMarchandiseService {

	@Autowired
	private IMarchandiseDao marchandiseDao;

	@Override
	public List<Marchandise> getAllMarchandises() {
		System.out.println("Service, liste marchandises");
		return marchandiseDao.getAllMarchandises();
	}

	@Override
	public Marchandise addMarchandise(Marchandise marchandiseIn) {
		System.out.println("service ajout");
		return marchandiseDao.addMarchandise(marchandiseIn);
	}

	@Override
	public Marchandise getMarchandise(int idIn) {
		return marchandiseDao.getMarchandise(idIn);
	}

	@Override
	public Marchandise updateMarchandise(Marchandise marchandiseIn) {
		System.out.println("service update");
		return marchandiseDao.updateMarchandise(marchandiseIn);
	}

	@Override
	public boolean deleteMarchandise(int idIn) {
	
		Marchandise check = marchandiseDao.deleteMarchandise(idIn);
		
		if (check != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Marchandise assignCargaisonAerienne(Marchandise marchandiseIn, int idCarg) {
		System.out.println("assignation cargaison aérienne");
		//recuperer la marchandise
		Marchandise marchFound = getMarchandise(marchandiseIn.getId());
		System.out.println("service, march trouvée :"+marchFound);
		//lui setter null à l'autre cargaison
		marchFound.setCargaisonRoutiere(null);
	
		return marchandiseDao.assignCargaisonAerienne(marchFound, idCarg);
		
	}

	@Override
	public Marchandise assignCargaisonRoutiere(Marchandise marchandiseIn, int idCarg) {
		System.out.println("assignation cargaison routière");
		//recuperer la marchandise
		Marchandise marchFound = getMarchandise(marchandiseIn.getId());
		System.out.println("service, march trouvée :"+marchFound);
		//lui setter null à l'autre cargaison
		marchFound.setCargaisonAerienne(null);
		return marchandiseDao.assignCargaisonRoutiere(marchFound, idCarg);
		
	}

	@Override
	public List<Marchandise> getMarchByCAerienne(String refCarg) {
		System.out.println("march service get march by CA");
		return marchandiseDao.getMarchByCAerienne(refCarg);
	}

	@Override
	public List<Marchandise> getMarchByCRoutiere(String refCarg) {
		System.out.println("march service get march by CR");
		return marchandiseDao.getMarchByCRoutiere(refCarg);
	}

	@Override
	public List<Marchandise> getMarchByKeyword(String Keyword) {
		return marchandiseDao.getMarchByKeyword(Keyword);
	}



}
