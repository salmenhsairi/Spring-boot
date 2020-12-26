package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;

public interface IEmployeService {

	public int ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
}
