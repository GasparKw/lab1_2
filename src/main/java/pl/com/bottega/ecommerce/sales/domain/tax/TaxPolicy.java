package pl.com.bottega.ecommerce.sales.domain.tax;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;

public interface TaxPolicy {
	Tax calculateTax(RequestItem item);
}
