package com.varun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.varun.bo.CoronaPatientBO;

public class CoronaPatientDAOImple implements ICoronaPatientDaO {
	
	//jobmap_co_pat
	private static final String CORONA_PATIENT_INSERT_QUERY = "INSERT INTO  JOBMAP_CO_PAT(NAME,ADDR,PDC,NOOFDAYS,TOTAMNT) VALUES(?,?,?,?,?)";
	private DataSource ds;
	
	
	public CoronaPatientDAOImple(DataSource ds) {
		System.out.println("CoronaPatientDAOImple:: 1 - Arg Constructor");
		this.ds = ds;

	}
	
	@Override
	public int insert(CoronaPatientBO cpBO) throws Exception {
		System.out.println("CoronaPatientDAOImple.insert()");
		int count = 0;
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(CORONA_PATIENT_INSERT_QUERY);){
			
			
			if(ps!=null) {
				ps.setString(1,cpBO.getName() );
				ps.setString(2,cpBO.getAddr() );
				ps.setDouble(3,cpBO.getPdc() );
				ps.setInt(4,cpBO.getNoofdays() );
				ps.setDouble(5,cpBO.getTotamnt() );
				
				count = ps.executeUpdate();
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}
