package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_Departement")
public class Departement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Departement()
	{}
	public Departement(String name) {
		super();
		this.name = name;
	}
	public Departement(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Departement_Id")
	private int id;
	@Column(name="Departement_Name")
	private String name;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="departement")
	private List<Mission> missions;
	@ManyToOne
	private Entreprise entreprise;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Employe> employees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public List<Employe> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}
	

}
