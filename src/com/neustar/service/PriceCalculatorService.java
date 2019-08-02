package com.neustar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neustar.model.CartItem;

public class PriceCalculatorService {
	
	static Map<String,Integer> domainPrice=getDomainWisePrice();

	//Separation of concerns. Can be made a webservice which accepts cart items and calculates price
	public Integer calculateTotalValue(List<CartItem> cart) {
		Integer price=0;
		for (CartItem item : cart) {
			//Can be tested further
			if(null!=item.getDomain() && item.getNoOfYears()>0) {
				Integer ratePerYear=domainPrice.get(item.getDomain());
				System.out.println("");
				if(ratePerYear>0) { //like this
					System.out.println(item.getDomain()+" * "+item.getNoOfYears()+"  = "+ratePerYear*item.getNoOfYears());
					price=price+(ratePerYear*item.getNoOfYears());
				}
				}
			}
		System.out.println("\nTotal Price ="+price);
		return price;
	}

	private static Map<String, Integer> getDomainWisePrice() {
		Map<String, Integer> domainPrice=new HashMap<>();
		domainPrice.put("apple.com.au",1000);
		domainPrice.put("education.net",300);
		domainPrice.put("dict.com",800);
		domainPrice.put(".com",10);
		domainPrice.put(".com.au",9);
		domainPrice.put(".net",20);
		return domainPrice;
	}

}
