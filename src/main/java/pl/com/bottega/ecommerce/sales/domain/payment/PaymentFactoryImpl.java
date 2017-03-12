package pl.com.bottega.ecommerce.sales.domain.payment;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * User: Klaudia
 * Date: 13.03.2017
 * Time: 00:01
 */
public interface PaymentFactoryImpl {
    public Payment create(Id aggregateId, ClientData clientData, Money amount);
}
