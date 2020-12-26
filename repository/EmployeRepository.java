package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

//import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Employe;
	@Repository
	public interface EmployeRepository extends CrudRepository<Employe,Integer>{
	@Modifying
	@Query(value = "UPDATE t_contrat SET employe_id = :empId WHERE contrat_id= :cId " , nativeQuery=true)
	void affecterContratEmploye(@Param("empId") int empId ,@Param("cId") int cId);
	
	//JPQL
	@Query(value = "SELECT count(e) from Employe e")
	int getNbEmployees();
	@Query(value="SELECT e.prenom FROM Employe e")
	List<String> getEmployeNames();
}
