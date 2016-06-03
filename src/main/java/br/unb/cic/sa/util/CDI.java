package br.unb.cic.sa.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDI {

	private static CDI instance;
	private ApplicationContext ctx;
	
	private CDI(){ 
		ctx = new ClassPathXmlApplicationContext("Beans.xml");
	}
	
	public static CDI Instance(){
		if(instance == null)
			instance = new CDI();

		return instance;
	}
	
	public ApplicationContext getContextCdi(){
		return ctx;
	}

	
}
