package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise,Integer> {


@Query(value = "SELECT departement_name FROM t_Departement d WHERE d.entreprise_entreprise_id=:eid ",nativeQuery = true)
List<String> RetrieveDepartementsByEntreprise(@Param("eid") int eid);
}
