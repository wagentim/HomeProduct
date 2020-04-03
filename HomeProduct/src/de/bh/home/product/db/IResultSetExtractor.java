package de.bh.home.product.db;

import java.sql.ResultSet;

public interface IResultSetExtractor<T>
{
	public abstract T extractData(ResultSet rs);
}
