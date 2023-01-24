
package springboot.consumeAPI.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "CountriesPort", targetNamespace = "http://spring.io/guides/gs-producing-web-service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CountriesPort {

    @WebMethod
    @WebResult(name = "getCountryResponse", targetNamespace = "http://spring.io/guides/gs-producing-web-service", partName = "getCountryResponse")
    public GetCountryResponse getCountry(
        @WebParam(name = "getCountryRequest", targetNamespace = "http://spring.io/guides/gs-producing-web-service", partName = "getCountryRequest")
        GetCountryRequest getCountryRequest);

}
