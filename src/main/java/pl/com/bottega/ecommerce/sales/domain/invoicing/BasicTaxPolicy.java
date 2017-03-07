package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BasicTaxPolicy implements TaxPolicy {

	public Tax calculateTax(ProductType type, Money netWorth) {
		
		BigDecimal ratio = null;
		String desc = null;
		
		switch (type) {
		case DRUG:
			ratio = BigDecimal.valueOf(0.05);
			desc = "5% (D)";
			break;
		case FOOD:
			ratio = BigDecimal.valueOf(0.07);
			desc = "7% (F)";
			break;
		case STANDARD:
			ratio = BigDecimal.valueOf(0.23);
			desc = "23%";
			break;
			
		default:
			throw new IllegalArgumentException(type + " not handled");
		}	
		Money taxValue = netWorth.multiplyBy(ratio);
		return new Tax(taxValue, desc);
	}

}
