package com.max.project.manager.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.max.project.manager.beans.AtomicJob;
import com.max.project.manager.beans.LocationCustomer;
import com.max.project.manager.beans.SimpleAuthorizedWorker;
import com.max.project.manager.beans.SimpleCustomer;
import com.max.project.manager.beans.SimpleProject;
import com.max.project.manager.beans.SimpleRegularWorker;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.factories.FactoryProducer;

public class RowMapperUtil {
	
	private static final AtomicJobRowMapper atomicJobRowMapper = new AtomicJobRowMapper();
	private static final SimpleProjectRowMapper simpleProjectRowMapper = new SimpleProjectRowMapper();
	private static final SimpleCustomerRowMapper simpleCustomerRowMapper = new SimpleCustomerRowMapper();
	private static final LocationCustomerRowMapper locationCustomerRowMapper = new LocationCustomerRowMapper();
	private static final SimpleRegularWorkerRowMapper simpleRegularWorkerRowMapper = new SimpleRegularWorkerRowMapper();
	private static final SimpleAuthorizedWorkerRowMapper simpleAuthorizedWorkerRowMapper = new SimpleAuthorizedWorkerRowMapper();
	
	public static AtomicJobRowMapper getAtomicJobRowMapper() {
		return atomicJobRowMapper;
	}
	
	public static SimpleProjectRowMapper getSimpleProjectRowMapper() {
		return simpleProjectRowMapper;
	}
	
	public static SimpleCustomerRowMapper getSimpleCustomerRowMapper() {
		return simpleCustomerRowMapper;
	}

	public static LocationCustomerRowMapper getLocationCustomerRowMapper() {
		return locationCustomerRowMapper;
	}

	public static SimpleRegularWorkerRowMapper getSimpleRegularWorkerRowMapper() {
		return simpleRegularWorkerRowMapper;
	}

	public static SimpleAuthorizedWorkerRowMapper getSimpleAuthorizedWorkerRowMapper() {
		return simpleAuthorizedWorkerRowMapper;
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
	
	static class SimpleCustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			SimpleCustomer customer = (SimpleCustomer) FactoryProducer.getFactory("customer").getCustomer("simpleCustomer");
			long id = rs.getLong("idCustomer");
			customer.setId(id);
			customer.setName(rs.getString("name"));
			customer.setPhone(rs.getString("phone"));
			customer.setEmail(rs.getString("email"));
			return customer;
		}
	}
	
	static class LocationCustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			LocationCustomer customer = (LocationCustomer) FactoryProducer.getFactory("customer").getCustomer("locationCustomer");
			long id = rs.getLong("idCustomer");
			customer.setId(id);
			customer.setName(rs.getString("name"));
			customer.setPhone(rs.getString("phone"));
			customer.setEmail(rs.getString("email"));
			customer.setCity(rs.getString("city"));
			customer.setStreet(rs.getString("street"));
			customer.setCity(rs.getString("houseNum"));
			return customer;
		}
	}
	
	static class SimpleRegularWorkerRowMapper implements RowMapper<Worker> {

		@Override
		public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
			SimpleRegularWorker worker = (SimpleRegularWorker) FactoryProducer.getFactory("worker").getWorker("simpleRegularWorker");
			long id = rs.getLong("idWorker");
			worker.setId(id);
			worker.setName(rs.getString("name"));
			worker.setPassword(rs.getString("password"));
			return worker;
		}
	}
	
	static class SimpleAuthorizedWorkerRowMapper implements RowMapper<Worker> {

		@Override
		public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
			SimpleAuthorizedWorker worker = (SimpleAuthorizedWorker) FactoryProducer.getFactory("worker").getWorker("simpleAuthorizedWorker");
			long id = rs.getLong("idWorker");
			worker.setId(id);
			worker.setName(rs.getString("name"));
			worker.setPassword(rs.getString("password"));
			return worker;
		}
	}
}
