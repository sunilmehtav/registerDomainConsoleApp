package com.neustar.service;

import java.util.ArrayList;
import java.util.List;

import com.neustar.model.Model;

//Ideally it would be a service method interacting with DB to fetch all type of domains
public class DomainService {

	public List<Model> getDomainData() {
		//here make a db call to fetch details
		List<Model> modelList=new ArrayList<>();
		modelList.add(new Model("Premium","apple.com.au",1000));
		modelList.add(new Model("Premium","dict.com",800));
		modelList.add(new Model("Premium","education.net",300));
		modelList.add(new Model("Zone",".com",10));
		modelList.add(new Model("Zone",".com.au",9));
		modelList.add(new Model("Zone",".net",20));
		
		return modelList;
	}

}
