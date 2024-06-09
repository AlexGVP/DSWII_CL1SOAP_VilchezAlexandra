package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.exception.NotFoundException;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.service.PersonajeService;
import pe.edu.cibertec.ws.objects.*;

@AllArgsConstructor
@Endpoint
public class PersonajeEndPoint {
    private PersonajeService personajeService;
    private static final String NAMESPACE_URL = "http://www.cibertec.edu.pe/ws/objects";

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "crearPersonajeRequest")
    @ResponsePayload
    public CrearPersonajeResponse crearPersonaje(@RequestPayload CrearPersonajeRequest request){
        CrearPersonajeResponse response = new CrearPersonajeResponse();
        response.setPersonaje(personajeService.crearPersonaje(request.getPersonaje()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "actualizarPersonajeRequest")
    @ResponsePayload
    public ActualizarPersonajeResponse actualizarPersonaje(@RequestPayload ActualizarPersonajeRequest request){
        ActualizarPersonajeResponse response = new ActualizarPersonajeResponse();
        response.setPersonaje(personajeService.actualizarPersonaje(request.getPersonaje()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "buscarPersonajesRequest")
    @ResponsePayload
    public BuscarPersonajesResponse buscarPersonajes(@RequestPayload BuscarPersonajesRequest request){
        BuscarPersonajesResponse response = new BuscarPersonajesResponse();
        response.getPersonajes().addAll(personajeService.listarPersonajes());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "buscarPersonajePorIdRequest")
    @ResponsePayload
    public BuscarPersonajePorIdResponse buscarPersonajePorId(@RequestPayload BuscarPersonajePorIdRequest request){
        BuscarPersonajePorIdResponse response = new BuscarPersonajePorIdResponse();
        Personajews personajews = personajeService.obtenerPersonajexId(request.getId());
        if(personajews == null)
            throw new NotFoundException("El personaje con el ID "+ request.getId()+" no existe!");
        response.setPersonaje(personajews);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "obtenerListaPersonajesRequest")
    @ResponsePayload
    public ObtenerListaPersonajesResponse obtenerListaPersonajes(@RequestPayload ObtenerListaPersonajesRequest request){
        ObtenerListaPersonajesResponse response = new ObtenerListaPersonajesResponse();
        response.getPersonajes().addAll(personajeService.listarPersonajes());
        return response;
    }
}
