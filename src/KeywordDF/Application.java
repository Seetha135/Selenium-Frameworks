package KeywordDF;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.ReadExcel;

public class Application {
	@Test
	
	public void testApplication() throws IOException{
		String[][] data=ReadExcel.getData("TestData2.xlsx", "Sheet1");
		
		for(int i=1;i<data.length;i++)
		{
			switch(data[i][3]) {
			case "openBrowser"://i=1
				Methods.openBrowser();
				break;
			case "maximizeBrowser"://i=2
				Methods.maximizeBrowser();
				break;
			case "ImplementWait"://i=3
				Methods.implementWait();
				break;
			case "navigateTo"://i=4
				Methods.navigateTo(data[i][6]);
				break;
			case "enterInvalidUsername"://i=5
				Methods.enterUName(data[i][5],data[i][6]);
				break;
			case "enterInvalidPassword"://i=6
				Methods.enterPassword(data[i][5],data[i][6]);
				break;
			case "clickSubmit"://i=7
				Methods.clickSubmit(data[i][5]);
				break;
			case"verifyErrorMessage"://i=8
				Methods.verifyMessage(data[i][5], data[i][6]);
				break;
			case "closeBrowser"://i=9
				Methods.closeBrowser();
				break;
				
				
				
				
			}
		}
	}

}
