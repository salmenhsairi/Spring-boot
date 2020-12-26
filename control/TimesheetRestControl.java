package tn.esprit.spring.control;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.TimesheetPK;
import tn.esprit.spring.service.ITimesheetService;

@RestController
public class TimesheetRestControl {
	@Autowired
	ITimesheetService timesheetService;
	//http://localhost:8088/SpringMVC/servlet/add-mission
	@PostMapping("/add-mission")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody Mission miss){
		int EntId = timesheetService.ajouterMission(miss);
		return EntId;
	}
	//http://localhost:8088/SpringMVC/servlet/affecter-mission-departement/{mission-id}/{departement-id}
	@PutMapping("/affecter-mission-departement/{mission-id}/{departement-id}")
	@ResponseBody
	public void affecterMissionAuDepartement(@PathVariable("mission-id") int misId,@PathVariable("departement-id") int depId){
		timesheetService.affecterMissionADepartement(misId, depId);
	}
	//http://localhost:8088/SpringMVC/servlet/add-timesheet
	@PostMapping("/add-timesheet")
	@ResponseBody
	public void addTimesheet(@RequestBody TimesheetPK tsPK){
		timesheetService.ajouterTimesheet(tsPK.getIdMission(),tsPK.getIdEmploye(),tsPK.getDateDebut(),tsPK.getDateFin());
	}
}
