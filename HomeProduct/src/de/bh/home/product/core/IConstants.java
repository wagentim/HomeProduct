package de.bh.home.product.core;

public interface IConstants
{
	// Constants
	public static final String EMPTY_STRING = "";
	public static final int MAIN_SCREEN_WIDTH = 800;
	public static final int MAIN_SCREEN_HEIGHT = 600;
	
	// Setting File
	public static final String SETTING_FILE = "settings.json";
	
	// Product Related
	public static final String[] SITES = {"yachao", "yachaoonline", "goasia"};
	
	// Sqlite DB
	public static final String DB_SQLITE_CLASS_NAME = "org.sqlite.JDBC";
	public static final String DB_DB_NAME = "jdbc:sqlite:product.db";

	// Application
	public static final String TXT_APP_TITLE = "Home Product (V1.0)";
	
	// Constants Text
	public static final String TXT_DEFAULT = "默认";
	public static final String TXT_CATEGORY = "目录";
	public static final String TXT_WEBSITE = "网站";
	public static final String[] TXT_TABLE_HEADER = {"产品名称", "价格"};

}
