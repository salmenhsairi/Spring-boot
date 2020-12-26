package tn.esprit.spring.service;

import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private DepartementRepository departementRepository;
	private static final Logger L = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		L.info("In ajouterEntreprise .");
		Entreprise entrepriseSaved = entrepriseRepository.save(entreprise);
		L.debug("Entrepeise++" + entreprise.getId() );
		L.info("Out of ajouterEntreprise ");
		return entrepriseSaved.getId();
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		L.info("In ajouterDepartement .");
		departementRepository.save(dep);
		L.debug("departement++ "+dep.getId());
		L.info("Out of ajouterDepartement ");
		return dep.getId();
	}

	@Transactional
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		L.info("In affecterDepartementAEntreprise");
		Entreprise e = entrepriseRepository.findById(entrepriseId).get();
		Departement d = departementRepository.findById(depId).get();
		d.setEntreprise(e);
		L.debug("departement "+depId+" Entreprise "+entrepriseId);
		L.info("Out of affecterDepartementAEntreprise");
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		L.info("In getAllDepartementsNamesByEntreprise");
		List<String> departements = entrepriseRepository.RetrieveDepartementsByEntreprise(entrepriseId);
		L.info("Out of getAllDepartementsNamesByEntreprise");
		return departements;
	}

}
