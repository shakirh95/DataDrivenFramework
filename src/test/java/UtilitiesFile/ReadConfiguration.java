package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration 
{
	Properties properties;
	String path = "C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework\\Configuration\\Configuration.properties";
	
	public ReadConfiguration()
	{
		FileInputStream fileInputStream = null;
		try 
		{
			fileInputStream = new FileInputStream(path);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		properties = new Properties();
		try 
		{
			properties.load(fileInputStream);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public String getUrl()
	{
		String string1 = properties.getProperty("baseurl");
		if (string1!=null)
		{
			return string1;
		}
		else 
		{
			throw new RuntimeException("url not found");
		}
	}
	public String getBrowser()
	{
		String string1 = properties.getProperty("browser");
		if (string1!=null)
		{
			return string1;
		}
		else 
		{
			throw new RuntimeException("browser not found");
		}
	}
}
