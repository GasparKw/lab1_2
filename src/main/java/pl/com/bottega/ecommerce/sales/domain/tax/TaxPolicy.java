package pl.com.bottega.ecommerce.sales.domain.tax;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public interface TaxPolicy {
	Tax calculateTax(ProductType productType, Money net);
}
