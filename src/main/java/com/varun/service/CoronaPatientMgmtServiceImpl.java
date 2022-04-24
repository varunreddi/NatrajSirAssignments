package com.varun.service;

import com.varun.bo.CoronaPatientBO;
import com.varun.dao.ICoronaPatientDaO;
import com.varun.dto.CoronaPatientDTO;

public class CoronaPatientMgmtServiceImpl implements ICoronaPatientMgmtService {

	private ICoronaPatientDaO dao;
	
	
	public CoronaPatientMgmtServiceImpl(ICoronaPatientDaO dao) {
		this.dao = dao;
	}


	@Override
	public String registerCoronaPatient(CoronaPatientDTO cpDTO) throws Exception {
		System.out.println("CoronaPatientMgmtServiceImpl.insert()");
		
		//calculate total bill amount
		Double totamnt = cpDTO.getPdc()*cpDTO.getNoofdays();
		
		CoronaPatientBO cpBO = new CoronaPatientBO();
		cpBO.setName(cpDTO.getName());
		cpBO.setAddr(cpDTO.getAddr());
		cpBO.setNoofdays(cpDTO.getNoofdays());
		cpBO.setPdc(cpDTO.getPdc());
		cpBO.setTotamnt(totamnt);
		
		int count = dao.insert(cpBO);
		
		return count==0 ? "Registration failed" : "Registration Successfull :: intrest amount ::"+totamnt;
		
	}
	
}
