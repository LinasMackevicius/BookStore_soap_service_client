package lt.eif.viko.l.mackevicius.BookStoreClient.config;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lt.eif.viko.l.mackevicius.BookStoreClient.generated_class.*;

@WebService(name = "ServiceInitialize", targetNamespace = "http://www.springframework.org/schema/web-services")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface ServicePort {

    @WebMethod
    @WebResult(name = "getBookOrderResponse", targetNamespace="http://www.springframework.org/schema/web-services", partName = "getBookOrderResponse")
    GetBookOrderResponse getBookOrder(
            @WebParam(name="getBookOrderRequest", targetNamespace = "http://www.springframework.org/schema/web-services", partName = "getBookOrderRequest")
            GetBookOrderRequest getBookOrderRequest);


    @WebMethod
    @WebResult(name="getAllBookResponse", targetNamespace = "http://www.springframework.org/schema/web-services", partName = "getAllBookResponse")
    GetAllBookResponse getAllBook(
            @WebParam(name ="getAllBookRequest", targetNamespace = "http://www.springframework.org/schema/web-services", partName = "getAllBookRequest")
            GetAllBookRequest getAllBookRequest);


    @WebMethod
    @WebResult(name="getCustomerResponse", targetNamespace = "http://www.springframework.org/schema/web-services", partName = "getCustomerResponse")
    GetCustomerResponse getCustomer(
            @WebParam(name="getCustomerRequest", targetNamespace = "http://www.springframework.org/schema/web-services", partName = "getCustomerRequest")
            GetCustomerRequest getCustomerRequest);
}
