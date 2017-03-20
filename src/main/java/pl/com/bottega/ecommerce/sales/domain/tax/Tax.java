/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.tax;

import pl.com.bottega.ecommerce.sharedkernel.Money;
import java.math.BigDecimal;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;

public class Tax {

	private Money amount;

	private String description;

	public Tax(Money amount, String description) {
		super();
		this.amount = amount;
		this.description = description;
	}

	public Money getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
	
	public static Tax evaluateTax(RequestItem item) {
		Money net = item.getTotalCost();
		BigDecimal ratio = null;
		String desc = null;
		
		switch (item.getProductData().getType()) {
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
			throw new IllegalArgumentException(item.getProductData().getType() + " not handled");	
		}					
		Money taxValue = net.multiplyBy(ratio);
		
		return new Tax(taxValue, desc);
	}

}
