package pl.com.bottega.ecommerce.sales.domain.payment;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by Patryk Wierzyński
 */

public class PaymentFactory implements IPaymentFactory {

	public Payment createPayment(ClientData clientData, Money amount) {
		return new Payment(Id.generate(), clientData, amount);
	}

}
