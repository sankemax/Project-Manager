package com.max.project.manager.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.max.project.manager.beans.LocationCustomer;
import com.max.project.manager.beans.SimpleCustomer;
import com.max.project.manager.beans.interfaces.Customer;
import com.max.project.manager.utils.RowMapperUtil;

@Component("customerDao")
public class CustomerDao {

	private NamedParameterJdbcTemplate namedParamJdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParamJdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Customer> getAllCustomersAsSimple() {
		return namedParamJdbc.query("SELECT * FROM customer",
				RowMapperUtil.getSimpleCustomerRowMapper());
	}
	
	public boolean isCustomerExist(long id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return namedParamJdbc.query("SELECT idCustomer FROM customer WHERE idCustomer = :id LIMIT 1",
				param, RowMapperUtil.getSimpleCustomerRowMapper()).size() == 1;
	}
	
	public List<Customer> getLocationCustomers() {
		return namedParamJdbc.query("SELECT * FROM customer INNER JOIN customerLocation ON" +
				" customer.idCustomer = customerLocation.Customer_idCustomer",
				RowMapperUtil.getLocationCustomerRowMapper());
	}
	
	public boolean isLocationCustomer(long id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return namedParamJdbc.query("SELECT Customer_idCustomer FROM customerLocation WHERE Customer_idCustomer = :id LIMIT 1",
				param, RowMapperUtil.getLocationCustomerRowMapper()).size() == 1;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean create(Customer customer) {
		BeanPropertySqlParameterSource params = null;
		params = new BeanPropertySqlParameterSource(customer);
		if (customer instanceof LocationCustomer) {
			return namedParamJdbc.update("INSERT INTO customer (name, phone, email) VALUES (:name, :phone, :email);" +
					"INSERT INTO customerLocation (Customer_idCustomer, city, street, houseNum) " +
					"VALUES (LAST_INSERT_ID(), :city, :street, :houseNum);", params) == 2;
		} else if (customer instanceof SimpleCustomer) {
			return namedParamJdbc.update("INSERT INTO customer (idCustomer, name, phone, email) " +
					"VALUES (:customerId, :name, :phone, :email)", params) == 1;
		}
		return false;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean delete(long id, Class<Customer> custClass) {
		MapSqlParameterSource param = null;
		param = new MapSqlParameterSource("id", id);
		if (custClass.equals(LocationCustomer.class)) {
			return namedParamJdbc.update("DELETE FROM customer WHERE idCustomer = :id;" +
					"DELETE FROM customerLocation WHERE Customer_idCustomer = :id;", param) == 2;
		} else if (custClass.equals(SimpleCustomer.class)) {
			return namedParamJdbc.update("DELETE FROM customer WHERE idCustomer = :id", param) == 1;
		}  
		return false;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean update(Customer customer) {
		BeanPropertySqlParameterSource params = null;
		params = new BeanPropertySqlParameterSource(customer);
		if (customer instanceof LocationCustomer) {
			return namedParamJdbc.update("UPDATE customer SET name = :name, phone = :phone, email = :email WHERE idCustomer = :id" +
					"UPDATE customerLocation SET city = :city, street = :street, houseNum = :houseNum", params) == 2;
		} else if (customer instanceof SimpleCustomer) {
			return namedParamJdbc.update("UPDATE customer SET name = :name, phone = :phone, email = :email WHERE idCustomer = :id", params) == 1;
		}
		return false;
	}
}
