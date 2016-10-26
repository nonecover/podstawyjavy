package com.jakomulski.daofactory;



import org.junit.Test;

import com.jakomulski.daofactory.DAOFactory;
import com.jakomulski.daofactory.DAOType;

public class DAOFactoryTests {

	@Test
	public void test() {
		DAOFactory factory = DAOFactory.getInstance(DAOType.DB);
		factory.getPersonById(1);
		factory.setFactory(DAOType.XML);
		factory.getPersonById(2);
		factory.setFactory(DAOType.DB);
		factory.getPersonById(2);
		factory.setFactory(DAOType.WS);
		factory.getPersonById(2);
		
		factory.setFactory(DAOType.XLS);
		factory.getPersonById(2);
	}

}
