//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.06.09 a las 05:55:53 AM PET 
//


package pe.edu.cibertec.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numm1" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numm2" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numm3" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numm4" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numm1",
    "numm2",
    "numm3",
    "numm4"
})
@XmlRootElement(name = "CalcularNumMenorRequest")
public class CalcularNumMenorRequest {

    protected int numm1;
    protected int numm2;
    protected int numm3;
    protected int numm4;

    /**
     * Obtiene el valor de la propiedad numm1.
     * 
     */
    public int getNumm1() {
        return numm1;
    }

    /**
     * Define el valor de la propiedad numm1.
     * 
     */
    public void setNumm1(int value) {
        this.numm1 = value;
    }

    /**
     * Obtiene el valor de la propiedad numm2.
     * 
     */
    public int getNumm2() {
        return numm2;
    }

    /**
     * Define el valor de la propiedad numm2.
     * 
     */
    public void setNumm2(int value) {
        this.numm2 = value;
    }

    /**
     * Obtiene el valor de la propiedad numm3.
     * 
     */
    public int getNumm3() {
        return numm3;
    }

    /**
     * Define el valor de la propiedad numm3.
     * 
     */
    public void setNumm3(int value) {
        this.numm3 = value;
    }

    /**
     * Obtiene el valor de la propiedad numm4.
     * 
     */
    public int getNumm4() {
        return numm4;
    }

    /**
     * Define el valor de la propiedad numm4.
     * 
     */
    public void setNumm4(int value) {
        this.numm4 = value;
    }

}
