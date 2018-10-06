package com.expedia.invoicegeneration.model;

import java.util.List;
import java.util.Map;

public class Order {

	private List<Item> orderedItems;
	private Map<Item, Integer> orderedItemCount;

	public List<Item> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<Item> item) {
		this.orderedItems = item;
	}

	public Map<Item, Integer> getOrderedItemCount() {
		return orderedItemCount;
	}

	public void setOrderedItemCount(Map<Item, Integer> orderedItemCount) {
		this.orderedItemCount = orderedItemCount;
	}
	
}
