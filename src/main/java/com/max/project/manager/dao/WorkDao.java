package com.max.project.manager.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.max.project.manager.beans.AtomicJob;
import com.max.project.manager.beans.interfaces.Work;
import com.max.project.manager.utils.RowMapperUtil;

@Component("workDao")
public class WorkDao {

	private NamedParameterJdbcTemplate dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Work> get() {
		return dataSource.query("SELECT * FROM work", RowMapperUtil.getAtomicJobRowMapper());
	}
	
	public List<Work> getProject(long id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return dataSource.query("SELECT * FROM work WHERE Project_idProject = :id", param, RowMapperUtil.getAtomicJobRowMapper());
	}
	
	public Work get(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return dataSource.queryForObject("SELECT * FROM work WHERE idWork = :id", param, RowMapperUtil.getAtomicJobRowMapper());
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return dataSource.update("DELETE FROM work WHERE idWork = :id", param) == 1;
	}
	
	public boolean create(Work work) {
		BeanPropertySqlParameterSource params = null;
		if (work instanceof AtomicJob) {
			params = new BeanPropertySqlParameterSource(work);
			return dataSource.update("INSERT INTO work (Customer_idCustomer, name, description, startDate, endDate, comments,"
					+ "isFinished, isCanceled, unitWorth, numUnits, Project_idProject)"
					+ "VALUES (:customerId, :name, :description, :dateOfStart, :dateOfEnd, :comments, :finished, :canceled,"
					+ ":unitWorth, :numOfUnits, :projectId)", params) == 1;
		}
		return false;
	}
	
	public boolean update(Work work) {
		BeanPropertySqlParameterSource params = null;
		if (work instanceof AtomicJob) {
			params = new BeanPropertySqlParameterSource(work);
			return dataSource.update("UPDATE work SET name = :name, description = :description,"
					+ "startDate = :dateOfStart, endDate = :dateOfEnd, comments = :comments, isFinished = :finished, isCanceled = :canceled,"
					+ "unitWorth = :unitWorth, numUnits = :numOfUnits, Project_idProject = :projectId WHERE idWork = :id", params) == 1;
		}
		return false;
	}

	// this will not work if the parameters will differ. only works for AtomicJob
	@Transactional(propagation=Propagation.REQUIRED)
	public int[] create(List<Work> works) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(works.toArray());

		return dataSource.batchUpdate("INSERT INTO work (Customer_idCustomer, name, description, startDate, endDate, comments,"
					+ "isFinished, isCanceled, unitWorth, numUnits, Project_idProject)"
					+ "VALUES (:customerId, :name, :description, :dateOfStart, :dateOfEnd, :comments, :finished, :canceled,"
					+ ":unitWorth, :numOfUnits, :projectId)", params);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int[] update(List<Work> works) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(works.toArray());
		return dataSource.batchUpdate("UPDATE work SET Customer_idCustomer = :customerId, name = :name, description = :description,"
					+ "startDate = :dateOfStart, endDate = :dateOfEnd, comments = :comments, isFinished = :finished, isCanceled = :canceled,"
					+ "unitWorth = :unitWorth, numUnits = :numOfUnits, Project_idProject = :projectId WHERE idWork = :id", params);
	}
}
