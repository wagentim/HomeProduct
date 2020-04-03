package de.bh.home.product.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapper<T>
{
	public abstract T mapRow(ResultSet rs, int index) throws SQLException;
}
