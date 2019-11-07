package report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 *
 *
 * @author Copyright (C) 2010 Advan Corp inc.
 *
 *
 */
public class ExcelFileUtil {

	/**
	 *
	 */
	private ExcelFileUtil() {
	}

	/**
	 * Excelファイルの取得
         * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static Workbook getWorkbook(String fileName) throws Exception {
		InputStream inp = new FileInputStream(fileName);
		Workbook wb = WorkbookFactory.create(inp);
		System.out.println("ファイル名「" + fileName + "」を読込ました");
		return wb;
	}

	/**
	 * Excelファイルか確認
	 * @param inputFile
	 * @return
	 */
	public static boolean isExcelFile(String inputFile) {
		if (inputFile != null) {
			if (inputFile.endsWith("xls") || inputFile.endsWith("xlsx")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 存在するExcelファイルか確認
	 * @param inputFile
	 * @return
	 */
	public static boolean isExistExcelFile(String inputFile) {
		if (isExcelFile(inputFile)) {
			File file = new File(inputFile);
			if (file.exists() && file.isFile()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Excelファイルの出力
	 * @param wb
	 * @param outFile
	 * @throws Exception
	 */
	public static void write(Workbook wb, String outFile) throws Exception {
		OutputStream out = new FileOutputStream(outFile);
		wb.write(out);
		System.out.println("ファイル名「" + outFile + "」が出力されました");
	}

}
