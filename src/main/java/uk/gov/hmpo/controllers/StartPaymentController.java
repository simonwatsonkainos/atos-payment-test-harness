package uk.gov.hmpo.controllers;

import sips.cn.contract.PaymentServiceImplService;
import sips.cn.contract.PaymentWebInitInput;
import sips.cn.contract.PaymentWebInitOutput;
import sips.cn.contract.Request2;
import uk.gov.hmpo.views.StartPaymentView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Path("/start-payment")
public class StartPaymentController {

    @GET
    @Produces({MediaType.TEXT_HTML})
    public StartPaymentView startPayment() {
        return new StartPaymentView();
    }

    @POST
    public Response initializePayment() throws URISyntaxException {
        Request2 request2 = new Request2();
        request2.setAutomaticResponseUrl("http://localhost:3002/autoResponseUrl");
        request2.setCaptureMode("1");
        request2.setCaptureMode("TEST_CAPTURE_MODE");
        request2.setCurrencyCode("GBP");
        request2.setCustomerEmail("test_customer_email@test.com");
        request2.setCustomerId("ABC12345");
        request2.setCustomerLanguage("EN-GB");
        request2.setRequestVersion("0");
        request2.setMerchantId("HMPO-1");
        request2.setMerchantId("1");
        request2.setMerchantWalletId("1");
        request2.setNormalReturnUrl("http://localhost:3002/normalResponseUrl");
        request2.setOrderAmount(7525);
        request2.setOrderChannel("ORDER_CHANNEL");
        request2.setOrderId("ORD-12345");
        request2.setReturnContext("RETURN_CONTEXT");
        request2.setTemplateFile("templateFile.tmpl");
        request2.setTransactionReference(UUID.randomUUID().toString());
        request2.setUserId("USER-001");

        PaymentWebInitInput paymentWebInitInput = new PaymentWebInitInput();
        paymentWebInitInput.setRequest(request2);

        PaymentServiceImplService client = new PaymentServiceImplService();
        PaymentWebInitOutput response = client.getCnv1PaymentServiceImplPort().processPaymentWebInit(paymentWebInitInput);

        return Response.seeOther(new URI(response.getResponse().getRedirectionUrl())).build();
    }
}
