package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.service.IEmployeService;

@RestController
public class EmployeRestControl {
	@Autowired 
	IEmployeService employeService;
	
	//http://localhost:8088/SpringMVC/servlet/add-employe
	@PostMapping("/add-employe")
	@ResponseBody
	public int addEmploye(@RequestBody Employe e) {
	int idEmp = employeService.ajouterEmploye(e);
	return idEmp;
	}
	//http://localhost:8088/SpringMVC/servlet/affecter-employe-departement/{emloye-id}/{departement-id}
	@PutMapping("/affecter-employe-departement/{emloye-id}/{departement-id}")
	@ResponseBody
	public void AffecterEmployeADepartement(@PathVariable("emloye-id") int empId ,@PathVariable("departement-id") int depId){
		employeService.affecterEmployeADepartement(empId, depId);
	}
	//http://localhost:8088/SpringMVC/servlet/add-contrat
	@PostMapping("/add-contrat")
	@ResponseBody
	public int addContrat(@RequestBody Contrat c){
		int contratId = employeService.ajouterContrat(c);
		return contratId;
	}
	//http://localhost:8088/SpringMVC/servlet/affecter-contrat-employe/{contrat-id}/{employe-id}
	@PutMapping("/affecter-contrat-employe/{contrat-id}/{employe-id}")
	@ResponseBody
	public void AffecterContratAEmploye(@PathVariable("contrat-id") int contId,@PathVariable("employe-id") int empId){
		employeService.affecterContratAEmploye(contId, empId);
	}
	//http://localhost:8088/SpringMVC/servlet/get-employe-prenom/{employe-id}
	@GetMapping("/get-employe-prenom/{employe-id}")
	@ResponseBody
	public String getEmployePrenomById(@PathVariable("employe-id") int empId){
		String name = employeService.getEmployePrenomById(empId);
		return name;
	}
	//http://localhost:8088/SpringMVC/servlet/get-nombre-employe
	@GetMapping("/get-nombre-employe")
	@ResponseBody
	public long getNbEmploye(){
		return employeService.getNombreEmployeJPQL();
	}
	//http://localhost:8088/SpringMVC/servlet/get-employe-names
	@GetMapping("/get-employe-names")
	@ResponseBody
	public List<String> retrieveEmployeNames(){
		List<String> names = employeService.getAllEmployeNamesJPQL();
		return names;
		
	}
}
