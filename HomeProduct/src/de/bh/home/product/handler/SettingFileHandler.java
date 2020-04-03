package de.bh.home.product.handler;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.bh.home.product.core.IConstants;
import de.bh.home.product.core.Utils;

/**
 * Handle all Setting file related actions
 * The setting file will use Json format
 * 
 * @author UIH9FE
 *
 */
public final class SettingFileHandler extends AbstractMessageSender
{
	private static final Logger logger = LoggerFactory.getLogger(SettingFileHandler.class);
	private final Gson gson;
	private Setting setting = null;
	
	class Setting
	{
		private List<String> webSites;

		public List<String> getWebSites()
		{
			return webSites;
		}

		public void setWebSites(List<String> webSites)
		{
			this.webSites = webSites;
		}
	}
	
	public SettingFileHandler()
	{
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public void loadSettingFromFile()
	{
        Path path = getSettingFilePath();
        
		try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8))
		{

			setting = gson.fromJson(reader, Setting.class);

		} catch (IOException e)
		{
			//e.printStackTrace();
			setting = null;
			logger.error("Error -> Loading Setting File: " + path.toString());
		}
	}
	
	public void loadSettingFromString(final String content)
	{
		if(content != null && !content.isEmpty())
		{
			setting = gson.fromJson(content, Setting.class);
		}
		else
		{
			setting = null;
		}
	}
	
	public String saveSettingToString()
	{
		if(setting != null)
		{
			return gson.toJson(setting);
		}
		
		return IConstants.EMPTY_STRING;
	}
	
	public Path getSettingFilePath()
	{
		String file = Utils.getCurrentPath().toString() + File.separator + IConstants.SETTING_FILE;
		logger.info("Loading Setting File: " + file);
		
        Path path = new File(file).toPath();
        
        return path;
	}
	
	public void saveSettingToFile()
	{
        Path path = getSettingFilePath();
        
        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8))
		{

			gson.toJson(setting, writer);

		} catch (IOException e)
		{
			setting = null;
			logger.error("Error -> Loading Setting File: " + path.toString());
		}
	}

	@Override
	public void receivedAction(int type, Object content)
	{
		// TODO Auto-generated method stub
		
	}

	public void getWebSites()
	{
		// TODO Auto-generated method stub
		
	}
}
