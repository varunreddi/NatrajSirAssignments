package com.varun.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.varun.controller.MainController;
import com.varun.vo.CoronaPatientVO;

public class RealtimeDITest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name=null,addr=null,pdc=null,noofdays=null;
		if(sc!=null) {
			System.out.println("Enter Corona Patient name");
			name=sc.next();
			System.out.println("Enter address");
			addr = sc.next();
			System.out.println("Enter Per day cost");
			pdc = sc.next();
			System.out.println("Enter No of Days");
			noofdays = sc.next();
		}
		CoronaPatientVO cpVO = new CoronaPatientVO();
		cpVO.setName(name);
		cpVO.setAddr(addr);
		cpVO.setPdc(pdc);
		cpVO.setNoofdays(noofdays);
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/varun/cfgs/applicationContext.xml");
		
		MainController bean = factory.getBean("controller",MainController.class);
		
		try {
			
			String result = bean.processCoronaPatient(cpVO);
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println("Problem in Customer Registration :: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
