package com.expedia.invoice;

import java.util.Map.Entry;

import com.expedia.constants.Constants;
import com.expedia.invoicegeneration.model.Item;
import com.expedia.invoicegeneration.model.Order;

public class InvoiceGenerator {

	public void generateInvoice(Order order) {
		double totalTax = 0;
		double totalPriceIncludingTax = 0;
		for (Entry<Item, Integer> entry : order.getOrderedItemCount().entrySet()) {
			double totalPrice, finalPrice;
			System.out.print(entry.getValue() + Constants.SPACE + entry.getKey().getItemName() + Constants.COLON_SPACE);
			totalPrice = entry.getKey().getItemPrice() * entry.getValue();
			finalPrice = totalPrice
					+ (entry.getKey().getItemCategory().equals("Medical") ? 0 : totalPrice * Constants.TAX_PRICE);
			totalTax = totalTax + finalPrice - totalPrice;
			totalPriceIncludingTax = totalPriceIncludingTax + finalPrice;
			System.out.printf("%.2f\n", finalPrice);
		}
		System.out.printf("Sales Taxes: %.2f\n", totalTax);
		System.out.printf("Total: %.2f\n\n", totalPriceIncludingTax + totalTax);
	}

}
