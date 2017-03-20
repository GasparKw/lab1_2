package pl.com.bottega.ecommerce.sales.domain.tax;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class FoodTaxPolicy implements TaxPolicy {

	public Tax calculateTax(RequestItem item) {
		Money net = item.getTotalCost();
		BigDecimal ratio = null;
		String desc = null;
		ratio = BigDecimal.valueOf(0.07);
		desc = "7% (F)";				
		Money taxValue = net.multiplyBy(ratio);		
		return new Tax(taxValue, desc);
	}

}
