package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFile.LoginClass;
import UtilitiesFile.DataDrivenTesting;

public class TestCase extends BaseClass
{
	
	/*public void OpenUrl()
	{
		logger.info("open url");
		driver.get(URL1);
		
		LoginClass loginClass = new LoginClass(driver);
		
		logger.info("Enter username");
		loginClass.User_Name("student");
		
		logger.info("Enter user password");
		loginClass.User_Password("Password123");
		
		logger.info("Click submit button");
		loginClass.User_Submit();
	}*/
	
	@Test(dataProvider = "DataProvider")
	public void OpenUrl(String user, String password)
	{
		logger.info("open url");
		driver.get(URL1);
		
		LoginClass loginClass = new LoginClass(driver);
		
		logger.info("Enter username");
		loginClass.User_Name(user);
		
		logger.info("Enter user password");
		loginClass.User_Password(password);
		
		logger.info("Clik submit button");
		loginClass.User_Submit();
	}
	
	@DataProvider(name = "DataProvider")
	public String[][] setData() throws Exception
	{
		String filename = "C:\\Users\\Admin\\eclipse-workspace\\DataDrivenFramework\\Test.xlsx";
		int row = DataDrivenTesting.getRowCount(filename,"Sheet1");
		int column = DataDrivenTesting.getColumnCount(filename,"Sheet1");
		String[][] string = new String[row-1][column];
		for(int i = 1; i<row; i++)
		{
			for(int j = 0; j<column; j++)
			{
				string[i-1][j] = DataDrivenTesting.getCellValue(filename, "Sheet1", i, j);
			}
		}
		return string;
	}
}
