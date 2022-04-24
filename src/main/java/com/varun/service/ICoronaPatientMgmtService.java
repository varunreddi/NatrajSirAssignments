package com.varun.service;

import com.varun.dto.CoronaPatientDTO;

public interface ICoronaPatientMgmtService {
	
	String registerCoronaPatient(CoronaPatientDTO cpDTO)throws Exception;

}
