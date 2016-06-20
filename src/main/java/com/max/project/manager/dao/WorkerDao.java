package com.max.project.manager.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.max.project.manager.beans.SimpleAuthorizedWorker;
import com.max.project.manager.beans.SimpleRegularWorker;
import com.max.project.manager.beans.abstractclasses.AbstractWorker;
import com.max.project.manager.beans.interfaces.Worker;
import com.max.project.manager.utils.ParamSourceUtil;
import com.max.project.manager.utils.ParamSourceUtil.CombinedSqlParameterSource;

@Component("workerDao")
public class WorkerDao {
	
	NamedParameterJdbcTemplate namedParamJdbc;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(DataSource ds) {
		this.namedParamJdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	@Transactional
	public boolean create(Worker worker) {
		BeanPropertySqlParameterSource params = null;
		params = new BeanPropertySqlParameterSource(worker);
		if (worker.getClass().equals(SimpleRegularWorker.class)) {
			return namedParamJdbc.update("INSERT INTO worker (name, password) VALUES (:name, :password)", params) == 1;
		} else if (worker.getClass().equals(SimpleAuthorizedWorker.class)) {
			namedParamJdbc.update("INSERT INTO worker (name, password) VALUES (:name, :password)", params);
			// how to insert workers id?!
			SqlParameterSource param = new MapSqlParameterSource("workerId", ((AbstractWorker)worker).getId());
			SqlParameterSource[] workersBatch = SqlParameterSourceUtils.createBatch(((SimpleAuthorizedWorker)worker).getWorkers().toArray());
			CombinedSqlParameterSource combo = new ParamSourceUtil().new CombinedSqlParameterSource(param, workersBatch);
			namedParamJdbc.batchUpdate("INSERT INTO worker_has_worker (Worker_idWorker, Worker_idWorker1) VALUES (:workerId, :id)", combo);
			JdbcTemplate t = new JdbcTemplate();
			return true;
		}
		return false;
	}
}
