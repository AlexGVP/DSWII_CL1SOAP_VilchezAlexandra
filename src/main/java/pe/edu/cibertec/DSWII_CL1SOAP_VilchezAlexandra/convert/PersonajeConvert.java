package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.model.Personaje;
import pe.edu.cibertec.ws.objects.Personajews;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class PersonajeConvert {
    public Personaje convertPersonajewsToPersonaje(Personajews personajews){
        Personaje personaje = new Personaje();
        personaje.setIdpersonaje(personajews.getIdpersonaje());
        personaje.setNompersonaje(personajews.getNompersonaje());
        personaje.setApepersonaje(personajews.getApepersonaje());
        personaje.setFechnacpersonaje(personajews.getFechnacpersonaje().toGregorianCalendar().getTime());
        return personaje;
    }

    public List<Personaje> convertPersonajewsToPersonaje(List<Personajews> personajews){
        List<Personaje> personajeList = new ArrayList<>();
        personajews.forEach(aut ->{
            personajeList.add(convertPersonajewsToPersonaje(aut));
        });
        return personajeList;
    }

    public Personajews convertPersonajeToPersonajeWs(Personaje personaje){
        Personajews personajews = new Personajews();
        personajews.setIdpersonaje(personaje.getIdpersonaje());
        personajews.setNompersonaje(personaje.getNompersonaje());
        personajews.setApepersonaje(personaje.getApepersonaje());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(personaje.getFechnacpersonaje());
        try {
            XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            personajews.setFechnacpersonaje(xmlGregCal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return personajews;
    }
    public List<Personajews> convertPersonajeToPersonajeWs(List<Personaje> personajes){
        List<Personajews> personajeList = new ArrayList<>();
        personajes.forEach(personaje ->{
            personajeList.add(convertPersonajeToPersonajeWs(personaje));
        });
        return personajeList;
    }
}
