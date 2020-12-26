package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_Entreprise")
public class Entreprise implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public Entreprise()
	{}
	public Entreprise(String name, String raisonSocial) {
		super();
		this.name = name;
		this.raisonSocial = raisonSocial;
	}
	public Entreprise(int id, String name, String raisonSocial) {
		super();
		this.id = id;
		this.name = name;
		this.raisonSocial = raisonSocial;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Entreprise_Id")
	private int id;
	@Column(name="Entreprise_name")
	private String name;
	@Column(name = "Entreprise_raisonSocial")
	private String raisonSocial;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="entreprise")
	private List<Departement> departements;
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
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	

}
