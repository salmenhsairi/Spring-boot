package tn.esprit.spring.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.Timesheet;
import tn.esprit.spring.entity.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private TimesheetRepository timesheetRepository;
	private static final Logger L =  LogManager.getLogger(TimesheetServiceImpl.class);

	@Override
	public int ajouterMission(Mission mission) {
		L.info("In ajouterMission .");
		missionRepository.save(mission);
		L.info("Out of ajouterMission .");
		return mission.getId();

	}

	@Transactional
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission m = missionRepository.findById(missionId).get();
		Departement d = departementRepository.findById(depId).get();
		m.setDepartement(d);		
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		Timesheet t = new Timesheet();
		TimesheetPK tpk = new TimesheetPK();
		tpk.setIdEmploye(employeId);
		tpk.setIdMission(missionId);
		tpk.setDateDebut(dateDebut);
		tpk.setDateFin(dateFin);
		t.setTimesheetPK(tpk);
		timesheetRepository.save(t);
		
	}

}
