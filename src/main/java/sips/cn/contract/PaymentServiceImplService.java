package sips.cn.contract;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2014-09-26T15:51:35.513+01:00
 * Generated source version: 3.0.1
 * 
 */
@WebServiceClient(name = "PaymentServiceImplService", 
                  wsdlLocation = "/META-INF/paymentInit.wsdl",
                  targetNamespace = "urn:sips:cn:contract") 
public class PaymentServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:sips:cn:contract", "PaymentServiceImplService");
    public final static QName Cnv1PaymentServiceImplPort = new QName("urn:sips:cn:contract", "cnv1PaymentServiceImplPort");
    static {
        URL url = PaymentServiceImplService.class.getResource("/META-INF/paymentInit.wsdl");
        if (url == null) {
            url = PaymentServiceImplService.class.getClassLoader().getResource("/META-INF/paymentInit.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(PaymentServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "/META-INF/paymentInit.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public PaymentServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PaymentServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaymentServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PaymentServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns PaymentService
     */
    @WebEndpoint(name = "cnv1PaymentServiceImplPort")
    public PaymentService getCnv1PaymentServiceImplPort() {
        return super.getPort(Cnv1PaymentServiceImplPort, PaymentService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PaymentService
     */
    @WebEndpoint(name = "cnv1PaymentServiceImplPort")
    public PaymentService getCnv1PaymentServiceImplPort(WebServiceFeature... features) {
        return super.getPort(Cnv1PaymentServiceImplPort, PaymentService.class, features);
    }

}
