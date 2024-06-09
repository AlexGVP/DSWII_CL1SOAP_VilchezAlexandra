package pe.edu.cibertec.DSWII_CL1SOAP_VilchezAlexandra.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet
            (ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "personajes")
    public DefaultWsdl11Definition personajeWsdl11Definition(XsdSchema personajeSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PersonajesPort");
        wsdl11Definition.setLocationUri("/ws/personajes");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(personajeSchema);
        return wsdl11Definition;
    }

    @Bean(name = "pregunta2")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pregunta2Schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("Pregunta2Port");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(pregunta2Schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema personajeSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/personaje.xsd"));
    }

    @Bean
    public XsdSchema pregunta2Schema() { return new SimpleXsdSchema(new ClassPathResource("xsd/pregunta2.xsd"));}
}
