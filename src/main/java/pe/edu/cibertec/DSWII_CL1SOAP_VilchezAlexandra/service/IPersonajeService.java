package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.service;

import pe.edu.cibertec.ws.objects.Personajews;

import java.util.List;

public interface IPersonajeService {
    List<Personajews> listarPersonajes();
    Personajews obtenerPersonajexId(int id);
    Personajews crearPersonaje(Personajews personaje);
    Personajews actualizarPersonaje(Personajews personaje);
}
