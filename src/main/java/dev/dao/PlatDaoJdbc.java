package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository
public class PlatDaoJdbc implements IPlatDao {


	// outil JdbcTemplate fourni par Spring JDBC
	private JdbcTemplate jdbcTemplate;

	
	  public PlatDaoJdbc(DataSource datasource) {
		  this.jdbcTemplate = new JdbcTemplate(datasource);
	  }

	public Integer countPizzas() {
		String sql = "SELECT COUNT(*) FROM PLAT";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Plat> listerPlats() {
		String sql = "SELECT * FROM PLAT";
		List<Plat> plats = jdbcTemplate.query(sql, new PlatMapper());
		return plats;
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		String sql = "INSERT INTO plat(nomPlat, prixPlat) values(?,?)";
		this.jdbcTemplate.update(sql, nomPlat, prixPlat);
		
	}


	
}
