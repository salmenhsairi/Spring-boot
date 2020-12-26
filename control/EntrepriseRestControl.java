package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.service.IEntrepriseService;

@RestController
public class EntrepriseRestControl {
	@Autowired 
	IEntrepriseService entrepriseService;
	//http://localhost:8088/SpringMVC/servlet/add-entreprise
	@PostMapping("/add-entreprise")
	@ResponseBody
	public int addEntreprise(@RequestBody Entreprise e){
		int entrepriseId = entrepriseService.ajouterEntreprise(e);
		return entrepriseId;
	}
	//http://localhost:8088/SpringMVC/servlet/add-departement
	@PostMapping("/add-departement")
	@ResponseBody
	public int addDepartement(@RequestBody Departement d){
		int depId = entrepriseService.ajouterDepartement(d);
		return depId;
	}
	//http://localhost:8088/SpringMVC/servlet/affecter-departement-entreprise/{departement-id}/{entreprise-id}
	@PutMapping("/affecter-departement-entreprise/{departement-id}/{entreprise-id}")
	@ResponseBody
	public void affecterDepartmentAEntreprise(@PathVariable("departement-id") int depId ,@PathVariable("entreprise-id") int entId){
		entrepriseService.affecterDepartementAEntreprise(depId, entId);
	}
	//http://localhost:8088/SpringMVC/servlet/get-departement-names-by-entreprise/{entreprise-id}
	@GetMapping("/get-departement-names-by-entreprise/{entreprise-id}")
	@ResponseBody
	public List<String> getAllDepartementsByEntreprise(@PathVariable("entreprise-id") int entId){
		List<String> names = entrepriseService.getAllDepartementsNamesByEntreprise(entId);
		return names;
		
	}
}
