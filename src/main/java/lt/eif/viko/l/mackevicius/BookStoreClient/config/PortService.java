package lt.eif.viko.l.mackevicius.BookStoreClient.config;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(
        name="PortService",
        targetNamespace = "http://www.springframework.org/schema/web-services",
        wsdlLocation = "http://localhost:8080/soapWs/orders.wsdl"
)
public class PortService extends Service {

    private final static URL PORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException PORTSERVICE_EXCEPTION;
    private final static QName PORTSERVICE_QNAME = new QName("http://www.springframework.org/schema/web-services", "ServiceInitializeService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/soapWs/orders.wsdl");
        }catch (MalformedURLException ex){
            e = new WebServiceException(ex);
        }
        PORTSERVICE_WSDL_LOCATION = url;
        PORTSERVICE_EXCEPTION = e;
    }

    public PortService(){
        super(__getWsdlLocation(), PORTSERVICE_QNAME);
    }

    public PortService(WebServiceFeature... features){
        super(__getWsdlLocation(), PORTSERVICE_QNAME, features);
    }

    public PortService(URL wsdlLocation){
        super(wsdlLocation, PORTSERVICE_QNAME);
    }

    public PortService(URL wsdlLocation, WebServiceFeature... features){
        super(wsdlLocation, PORTSERVICE_QNAME, features);
    }

    public PortService(URL wsdlLocation, QName serviceName){
        super(wsdlLocation, serviceName);
    }

    public PortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features){
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name="ServiceInitializeSoap11")
    public ServicePort getPortServiceSoap11(){
        return super.getPort(new QName("http://www.springframework.org/schema/web-services", "ServiceInitializeSoap11"),
                ServicePort.class);
    }

    @WebEndpoint(name = "ServiceInitializeSoap11")
    public ServicePort getPortServiceSoap11(WebServiceFeature... features){
        return super.getPort(new QName("http://www.springframework.org/schema/web-services", "ServiceInitializeSoap11"),
                ServicePort.class, features);
    }

    private static URL __getWsdlLocation(){
        if(PORTSERVICE_EXCEPTION!= null){
            throw PORTSERVICE_EXCEPTION;
        }else{
            return PORTSERVICE_WSDL_LOCATION;
        }
    }
}
