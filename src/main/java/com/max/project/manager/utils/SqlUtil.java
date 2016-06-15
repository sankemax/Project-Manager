package com.max.project.manager.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.max.project.manager.beans.AtomicJob;
import com.max.project.manager.beans.SimpleProject;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.factories.FactoryProducer;

public class SqlUtil {
	
	private static final AtomicJobRowMapper atomicJobRowMapper = new AtomicJobRowMapper();
	private static final SimpleProjectRowMapper simpleProjectRowMapper = new SimpleProjectRowMapper();
	
	public static AtomicJobRowMapper getAtomicJobRowMapper() {
		return atomicJobRowMapper;
	}
	
	public static SimpleProjectRowMapper getSimpleProjectRowMapper() {
		return simpleProjectRowMapper;
	}

	static class AtomicJobRowMapper implements RowMapper<Work> {
		
		@Override
		public Work mapRow(ResultSet rs, int rowNum) throws SQLException {
			AtomicJob work = (AtomicJob) FactoryProducer.getFactory("work").getWork("atomicJob");
			work.setId(rs.getLong("idWork"));
			java.sql.Date startDate = rs.getDate("startDate");
			if (startDate != null) work.setDateOfStart(new Date(startDate.getTime()));
			java.sql.Date endDate = rs.getDate("endDate");
			if (endDate != null) work.setDateOfEnd(new Date(endDate.getTime()));
			work.setFinished(rs.getBoolean("isFinished"));
			work.setDescription(rs.getString("description"));
			work.setComments(rs.getString("comments"));
			work.setUnitWorth(rs.getDouble("unitWorth"));
			work.setNumOfUnits(rs.getInt("numUnits"));
			work.setCustomerId(rs.getLong("Customer_idCustomer"));
			return work;
		}
	}

	static class SimpleProjectRowMapper implements RowMapper<Project> {

		
		@Override
		public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
			SimpleProject project = (SimpleProject) FactoryProducer.getFactory("project").getProject("simpleProject");
			long id = rs.getLong("idProject");
			project.setId(id);
			project.setName(rs.getString("name"));
			return project;
		}
		
	}
}
