package com.varun.controller;

import com.varun.dto.CoronaPatientDTO;
import com.varun.service.ICoronaPatientMgmtService;
import com.varun.vo.CoronaPatientVO;

public class MainController {
	
	private ICoronaPatientMgmtService service;
	
	public MainController(ICoronaPatientMgmtService service) {
		System.out.println("MainController.MainController()");
		this.service = service;
	}
	
	public String processCoronaPatient(CoronaPatientVO cpVO)throws Exception{
		
		CoronaPatientDTO cpDTO = new CoronaPatientDTO();
		cpDTO.setName(cpVO.getName());
		cpDTO.setAddr(cpVO.getAddr());
		cpDTO.setNoofdays(Integer.parseInt(cpVO.getNoofdays()));
		cpDTO.setPdc(Double.parseDouble(cpVO.getPdc()));
		
		String resultMsg = service.registerCoronaPatient(cpDTO);
		return resultMsg;
	}
	
	
	
	
	
	
	

}
