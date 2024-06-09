package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.convert.PersonajeConvert;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.model.Personaje;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.repository.PersonajeRepository;
import pe.edu.cibertec.ws.objects.Personajews;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonajeService implements IPersonajeService{

    private PersonajeRepository personajeRepository;
    private PersonajeConvert personajeConvert;

    @Override
    public List<Personajews> listarPersonajes() {
        return personajeConvert.convertPersonajeToPersonajeWs(
                personajeRepository.findAll());
    }

    @Override
    public Personajews obtenerPersonajexId(int id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        return personaje.map(value ->
                        personajeConvert.convertPersonajeToPersonajeWs(value))
                .orElse(null);
    }

    @Override
    public Personajews crearPersonaje(Personajews personaje) {
        Personaje nuevoPersonaje = personajeRepository.save(
                personajeConvert.convertPersonajewsToPersonaje(personaje));
        return personajeConvert.convertPersonajeToPersonajeWs(nuevoPersonaje);
    }

    @Override
    public Personajews actualizarPersonaje(Personajews personaje) {
        Personaje nuevoPersonaje = personajeRepository.save(
                personajeConvert.convertPersonajewsToPersonaje(personaje));
        return personajeConvert.convertPersonajeToPersonajeWs(nuevoPersonaje);
    }
}
