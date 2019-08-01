package com.neustar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.neustar.model.CartItem;
import com.neustar.model.Model;
import com.neustar.service.DomainService;
import com.neustar.service.PriceCalculatorService;

public class RegisterDomain {
	
	public static void main(String[] args) {
		
		//Use Service call
		DomainService service=new DomainService();
		List<Model> modelList=service.getDomainData();
		
		//Modular appoach
		displayWelcomeMessage(modelList);
		
		//Ask customer prefernces
		List<CartItem> cart=getCustomerPreferences();
		
		//CalculatePrice
		PriceCalculatorService pcs=new PriceCalculatorService();
		Integer price=pcs.calculateTotalValue(cart);
		
		//display price
		System.out.println("\n\n Please pay "+price+" AUD.");
	}

	private static List<CartItem> getCustomerPreferences()  {
		System.out.println("Enter file path in the format C:\\testing.txt");
		Scanner in = new Scanner(System.in); 
		String filePath = in.nextLine(); 
		BufferedReader br =null;
		List<CartItem> cartList=new ArrayList<>();
		String row=null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((row = br.readLine()) != null) {
			    String[] data = row.split(",");
			    cartList.add(new CartItem(data[0].trim(), Integer.parseInt(data[1].trim())));
			}
		} catch (IOException e) {
			//Handle error here
		}finally {
			try {
				br.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cartList;
	}

	private static void displayWelcomeMessage(List<Model> modelList) {
		System.out.println("******************************************");
		System.out.println("**WELCOME TO NEUSTAR DOMAIN REGISTRATION**");
		System.out.println("******************************************");
		System.out.println("We have below registrations available: ");
		System.out.println("Type\t\tDomain\t\tPrice per year");
		for (Model model : modelList) {
			System.out.println(model.getType()+"\t\t"+model.getDomain()+"\t\t"+model.getPrice());
		}
		System.out.println("Please import a comma and line separated text file in below format\ndomain, no of years\\n domain, no of years");
	}
	
	
}
