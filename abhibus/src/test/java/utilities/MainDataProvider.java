package utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class MainDataProvider {

	@DataProvider(name="tripExcel")
	public Object[][] getData() {
		String sheetName= "Sheet1";
		ExcelReader excel = new ExcelReader("src/test/resources/dataBus.xlsx");
		int rows=excel.getRowCount(sheetName);
		int cols =excel.getColumnCount(sheetName);
		Object data[][]= new Object[rows-1][1];
		
		Hashtable<String, String> hash = null;
		for(int rowcount=2 ; rowcount<rows;rowcount++) {
			hash= new Hashtable<String, String> ();
			for (int colcount=0;colcount<cols;colcount++) {
			hash.put(excel.getCellData(sheetName, colcount, 1), excel.getCellData(sheetName, colcount, rowcount));
				data[rowcount-2][0]=hash;
				
			}	
		}
	return data;
	}
}
