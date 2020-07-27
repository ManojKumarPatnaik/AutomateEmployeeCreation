import java.util.*;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  

public class ImportXls {
	private ArrayList<Employee> empArrayList;
	private FileInputStream fis;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow titleRow;
	private int rows;
	
	public ImportXls(String filename) throws IOException {
		this.fis = new FileInputStream(new File(filename));
		this.wb = new HSSFWorkbook(fis);
		this.sheet = wb.getSheetAt(0);
		this.titleRow = sheet.getRow(0);
		this.rows = sheet.getPhysicalNumberOfRows();
		this.empArrayList = new ArrayList<Employee>();
	}
	
	public ArrayList<Employee> getEmpList(){
		return this.empArrayList;
	}
	
	public void populate() {
		HashMap<String, String> hMap = null;
		int cells = this.titleRow.getPhysicalNumberOfCells();
		for(int r = 1; r<this.rows; r++) {
			hMap = new HashMap<String, String>();
			for(int c = 0; c<cells; c++) {
				hMap.put(this.titleRow.getCell(c).getStringCellValue(), sheet.getRow(r).getCell(c).getStringCellValue());
			}
			this.empArrayList.add(new Employee(hMap));
		}
		
	}
}
