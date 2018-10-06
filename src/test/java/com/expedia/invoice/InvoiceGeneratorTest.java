package com.expedia.invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.expedia.invoicegeneration.model.Item;
import com.expedia.invoicegeneration.model.Order;

public class InvoiceGeneratorTest {
	private InvoiceGenerator invoiceGenerator;

	@Before
	public void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	@After
	public void tearDown() throws Exception {
		invoiceGenerator = null;
	}

	@Test
	public void testInvoice() {
		List<Item> itemList = new ArrayList<>();

		Item item1 = new Item();
		item1.setItemName("bottle of wine");
		item1.setItemPrice(20L);
		item1.setItemCategory("Drinks");

		Item item2 = new Item();
		item2.setItemName("box of headache pills");
		item2.setItemPrice(4L);
		item2.setItemCategory("Medical");

		Item item3 = new Item();
		item3.setItemName("box of pens");
		item3.setItemPrice(10L);
		item3.setItemCategory("Stationary");

		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);

		Map<Item, Integer> orderedItemCount = new HashMap<>();
		orderedItemCount.put(item1, 1);
		orderedItemCount.put(item2, 2);
		orderedItemCount.put(item3, 1);

		Order o = new Order();
		o.setOrderedItems(itemList);
		o.setOrderedItemCount(orderedItemCount);

		invoiceGenerator.generateInvoice(o);
	}

	@Test
	public void testInvoice_1() {
		List<Item> itemList = new ArrayList<>();

		Item item1 = new Item();
		item1.setItemName("book");
		item1.setItemPrice(30L);
		item1.setItemCategory("Books");

		Item item2 = new Item();
		item2.setItemName("chocolate");
		item2.setItemPrice(1L);
		item2.setItemCategory("Food");

		itemList.add(item1);
		itemList.add(item2);

		Map<Item, Integer> orderedItemCount = new HashMap<>();
		orderedItemCount.put(item1, 1);
		orderedItemCount.put(item2, 1);

		Order o = new Order();
		o.setOrderedItems(itemList);
		o.setOrderedItemCount(orderedItemCount);

		invoiceGenerator.generateInvoice(o);
	}

	@Test
	public void testInvoice_2() {
		List<Item> itemList = new ArrayList<>();

		Item item1 = new Item();
		item1.setItemName("pen");
		item1.setItemPrice(5L);
		item1.setItemCategory("Stationary");
		
		Map<Item, Integer> orderedItemCount = new HashMap<>();
		orderedItemCount.put(item1, 1);
		
		Order o = new Order();
		o.setOrderedItems(itemList);
		o.setOrderedItemCount(orderedItemCount);
		
		invoiceGenerator.generateInvoice(o);
	}
	
}
