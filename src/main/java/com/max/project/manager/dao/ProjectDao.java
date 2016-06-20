package com.max.project.manager.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.max.project.manager.beans.SimpleProject;
import com.max.project.manager.beans.interfaces.Project;
import com.max.project.manager.utils.RowMapperUtil;

@Component("projectDao")
public class ProjectDao {

	NamedParameterJdbcTemplate dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Project> get() {
		List<Project> projects = null;
		projects = dataSource.query("SELECT * FROM project", RowMapperUtil.getSimpleProjectRowMapper());
		return projects;
	}
	
	public Project get(long id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return (Project) dataSource.queryForObject("SELECT * FROM project WHERE idProject = :id", param, RowMapperUtil.getSimpleProjectRowMapper());
	}
	
	public boolean delete(long id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return dataSource.update("DELETE FROM project WHERE idProject = :id", param) == 1;
	}
	
	public boolean create(Project project) {
		BeanPropertySqlParameterSource params = null;
		if (project instanceof SimpleProject) {
			params = new BeanPropertySqlParameterSource(project);
			return dataSource.update("INSERT INTO project (name, description, startDate, closeDate, isFinished, isCanceled)"
					+ "VALUES (:name, :dateOfStart, :dateOfEnd, :isFinished, :isCanceled", params) == 1;
		}
		return false;
	}
	
	public boolean update(Project project) {
		BeanPropertySqlParameterSource params;
		if (project instanceof SimpleProject) {
			params = new BeanPropertySqlParameterSource(project);
			return dataSource.update("UPDATE project SET name = :name, description = :description,"
					+ "startDate = :startDate, closeDate = :closeDate, comments = :comments, isFinished = :isFinished, isCanceled = :isCanceled,"
					+ "WHERE idProject = :id", params) == 1;
		}
		return false;
	}
}
