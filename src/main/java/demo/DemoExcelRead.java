package demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcelRead {

	public static void main(String[] args) {

		demoRead();

	}

	private static void demoRead() {
		try (FileInputStream file = new FileInputStream(new File("sample.xlsx"));
				XSSFWorkbook workbook = new XSSFWorkbook(file);) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "t");
						break;
					default:
						System.out.print(cell.getStringCellValue() + "t");
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
