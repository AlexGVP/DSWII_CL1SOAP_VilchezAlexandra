package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {
}