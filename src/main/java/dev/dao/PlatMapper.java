package dev.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.entite.Plat;

public class PlatMapper implements RowMapper<Plat> {


		  @Override				// cette méthode est invoquée pour chaque ligne de résultat SQL
		  public Plat mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Plat p = new Plat();
		  p.setId(rs.getInt("ID"));
		  p.setNom(rs.getString("NOMPLAT"));
		  return p;
		  }
		}

	
	
	

