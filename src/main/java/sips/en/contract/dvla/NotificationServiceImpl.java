package sips.en.contract.dvla;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface = "sips.en.contract.dvla.Notification")
public class NotificationServiceImpl implements Notification {

    @Override
    public NotificationTransactionResponse notifyTransaction(
            @WebParam(partName = "parameters", name = "NotificationTransactionRequest", targetNamespace = "urn:sips:en:contract:dvla")
            NotificationTransactionRequest parameters
    ) {
        System.out.println("=============================Received Notification Transaction Request with Payload:===========================================");
        System.out.println(parameters.getNotification().toString());
        System.out.println("===============================================================================================================================");
        return null;
    }

    @WebMethod
    @WebResult(name = "NotificationWalletResponse", targetNamespace = "urn:sips:en:contract:dvla", partName = "parameters")
    public NotificationWalletResponse notifyWallet(
            @WebParam(partName = "parameters", name = "NotificationWalletRequest", targetNamespace = "urn:sips:en:contract:dvla")
            NotificationWalletRequest parameters
    ) {
        throw new RuntimeException("Not yet implemented");
    }
}
