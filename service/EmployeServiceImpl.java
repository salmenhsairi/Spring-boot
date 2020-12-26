package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private DepartementRepository departementRepository;
	private static final Logger L = LogManager.getLogger(EmployeServiceImpl.class);
	
	@Override
	public int ajouterEmploye(Employe employe) {
		L.info("In ajouterEmploye");
		Employe employeSaved = employeRepository.save(employe);
		L.debug("Employe++ "+employeSaved.getId());
		L.info("Out Of ajouterEmploye");
		return employeSaved.getId();
	}

	@Transactional
	public void affecterEmployeADepartement(int employeId, int depId) {
		L.info("In affecterEmployeADepartement");
		Employe emp = employeRepository.findById(employeId).get();
		Departement dep = departementRepository.findById(depId).get();
		if (dep.getEmployees() == null ){
			List<Employe> employees = new ArrayList<>();
			employees.add(emp);
			dep.setEmployees(employees);
		}
		else{
			dep.getEmployees().add(emp);
		}
		L.debug("Employe : "+emp+"Affecte au Departement "+dep);
		L.info("Out of affecterEmployeADepartement");
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		L.info("In ajouterContrat");
		contratRepository.save(contrat);
		L.debug("Contrat++"+contrat.getId());
		L.info("Out Of ajouterContrat");
		return contrat.getId();
	}

	@Transactional
	public void affecterContratAEmploye(int contratId, int employeId) {
		L.info("In affecterContratAEmploye");
		Employe emp =employeRepository.findById(employeId).get();
		Contrat c =contratRepository.findById(contratId).get();
		//employeRepository.affecterContratEmploye(employeId,contratId);
		c.setEmploye(emp);
		L.debug("Contrat "+contratId+"pour Employe "+employeId);
		L.info("Out of affecterContratAEmploye");
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		try{
		L.info("In getEmployePrenomById");
		Employe e = employeRepository.findById(employeId).get();
		L.info("Out Of getEmployePrenomById");
		return e.getPrenom();
		}
		catch(Exception E){
			return "Employe Inexistant";
		}
	}

	@Override
	public long getNombreEmployeJPQL() {
		L.info("In getNombreEmployeJPQL");
		int nb = employeRepository.getNbEmployees();
		L.info("Out Of getNombreEmployeJPQL");
		return nb;
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		L.info("In getAllEmployeNamesJPQL");
		List<String> names = employeRepository.getEmployeNames();
		L.info("Out Of getAllEmployeNamesJPQL");
		return names;
	}

}
