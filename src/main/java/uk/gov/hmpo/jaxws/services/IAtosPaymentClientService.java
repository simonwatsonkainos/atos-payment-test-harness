package uk.gov.hmpo.jaxws.services;

import sips.cn.contract.PaymentWebInitInput;
import sips.cn.contract.PaymentWebInitOutput;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IAtosPaymentClientService {

    @WebMethod
    PaymentWebInitOutput initializePayment(PaymentWebInitInput request);

}
