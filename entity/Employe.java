
package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;


import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="T_Employe")
public class Employe implements Serializable {


	private static final long serialVersionUID = 1L;
	public Employe()
	{}
	public Employe(String prenom, String nom, String email, Role role, Boolean isActif) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.role = role;
		this.isActif = isActif;
	}
	public Employe(int id, String prenom, String nom, String email, Role role, Boolean isActif) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.role = role;
		this.isActif = isActif;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="Employe_Prenom")
	private String prenom;
	@Column(name="Employe_Nom")
	private String nom;
	@Column(name="Employe_Email")
	private String email;
	@Column(name="Employe_Role") 
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(name="Employe_Is_Actif")
	private Boolean isActif;
	@ManyToMany(mappedBy="employees",fetch=FetchType.EAGER)
	private List<Departement> departements;
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	
	@OneToMany(mappedBy="employe")
	private  List<Timesheet> timesheets;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Timesheet> getTimesheets() {
		return timesheets;
	}
	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	
}
