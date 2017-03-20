package pl.com.bottega.ecommerce.sales.domain.tax;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;

public class TaxCalculator {
	private TaxPolicy taxPolicy;
	
	public TaxCalculator() {
		taxPolicy = new StandardTaxPolicy();
	}
	
	public final TaxPolicy getTaxPolicy() {
		return taxPolicy;
	}
	
	public void setTaxPolicy(TaxPolicy taxPolicy) {
		this.taxPolicy = taxPolicy;
	}
	
	public Tax calculateTax(RequestItem item) {
		return taxPolicy.calculateTax(item);
	}
}
