
package springboot.consumeAPI.wsdl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "CountriesPortService", targetNamespace = "http://spring.io/guides/gs-producing-web-service", wsdlLocation = "http://localhost:9090/ws/countries.wsdl")
public class CountriesPortService
    extends Service
{

    private final static URL COUNTRIESPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException COUNTRIESPORTSERVICE_EXCEPTION;
    private final static QName COUNTRIESPORTSERVICE_QNAME = new QName("http://spring.io/guides/gs-producing-web-service", "CountriesPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/ws/countries.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COUNTRIESPORTSERVICE_WSDL_LOCATION = url;
        COUNTRIESPORTSERVICE_EXCEPTION = e;
    }

    public CountriesPortService() {
        super(__getWsdlLocation(), COUNTRIESPORTSERVICE_QNAME);
    }

    public CountriesPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), COUNTRIESPORTSERVICE_QNAME, features);
    }

    public CountriesPortService(URL wsdlLocation) {
        super(wsdlLocation, COUNTRIESPORTSERVICE_QNAME);
    }

    public CountriesPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COUNTRIESPORTSERVICE_QNAME, features);
    }

    public CountriesPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountriesPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "CountriesPortSoap11")
    public CountriesPort getCountriesPortSoap11() {
        return super.getPort(new QName("http://spring.io/guides/gs-producing-web-service", "CountriesPortSoap11"), CountriesPort.class);
    }

    @WebEndpoint(name = "CountriesPortSoap11")
    public CountriesPort getCountriesPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://spring.io/guides/gs-producing-web-service", "CountriesPortSoap11"), CountriesPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COUNTRIESPORTSERVICE_EXCEPTION!= null) {
            throw COUNTRIESPORTSERVICE_EXCEPTION;
        }
        return COUNTRIESPORTSERVICE_WSDL_LOCATION;
    }

}
