package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.service.Pregunta2Service;
import pe.edu.cibertec.ws.objects.*;

import java.math.BigDecimal;

@Endpoint
public class Pregunta2EndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    private final Pregunta2Service pregunta2Service;

    @Autowired
    public Pregunta2EndPoint(Pregunta2Service pregunta2Service) {
        this.pregunta2Service = pregunta2Service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalcularJubilacionRequest")
    @ResponsePayload
    public CalcularJubilacionResponse calcularJubilacion(@RequestPayload CalcularJubilacionRequest request) {
        CalcularJubilacionResponse response = new CalcularJubilacionResponse();
        response.setResultado(pregunta2Service.calcularJubilacion(request.getEdad(), request.getSexo()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalcularMatriculaRequest")
    @ResponsePayload
    public CalcularMatriculaResponse calcularMatricula(@RequestPayload CalcularMatriculaRequest request) {
        CalcularMatriculaResponse response = new CalcularMatriculaResponse();
        double costoTotal = pregunta2Service.calcularMatricula(request.getNumMaterias());
        BigDecimal costoTotalBigDecimal = BigDecimal.valueOf(costoTotal);
        response.setPrecio(costoTotalBigDecimal);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalcularNumMenorRequest")
    @ResponsePayload
    public CalcularNumMenorResponse calcularNumMenor(@RequestPayload CalcularNumMenorRequest request) {
        CalcularNumMenorResponse response = new CalcularNumMenorResponse();
        response.setNumMenor(pregunta2Service.calcularMenor(request.getNumm1(), request.getNumm2(), request.getNumm3(), request.getNumm4()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalcularUtilidadesRequest")
    @ResponsePayload
    public CalcularUtilidadesResponse calcularUtilidades(@RequestPayload CalcularUtilidadesRequest request) {
        CalcularUtilidadesResponse response = new CalcularUtilidadesResponse();
        double salario = request.getSalario().doubleValue();
        double utilidades = pregunta2Service.calcularUtilidades(salario, request.getTiempo());
        response.setUtilidades(BigDecimal.valueOf(utilidades));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CalcularSumaRequest")
    @ResponsePayload
    public CalcularSumaResponse calcularSuma(@RequestPayload CalcularSumaRequest request) {
        CalcularSumaResponse response = new CalcularSumaResponse();
        response.setSuma(pregunta2Service.calcularSuma());
        return response;
    }
}