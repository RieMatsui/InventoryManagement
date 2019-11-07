package report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 *
 * @author Copyright (C) 2010 Advan Corp inc.
 *
 *
 */
public class SalesList {

	private static String inFile = null;

	private static String outFile = null;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// check arguments
		if (args == null || args.length != 2) {
			System.out.println("error of arguments");
			System.exit(1);
		}

		// check inputFile
		if (!ExcelFileUtil.isExistExcelFile(args[0])) {
			System.out.println("error of inputFile");
			System.exit(1);
		}
		inFile = args[0];

		// check outputFile
		if (!ExcelFileUtil.isExcelFile(args[1])) {
			System.out.println("error of outputFile");
			System.exit(1);
		}
		outFile = args[1];

		// create workbook
		Workbook wb = ExcelFileUtil.getWorkbook(inFile);
		// create data
		List<ReportData> dataList = new ArrayList<ReportData>();
		dataList.add(setData());
		// create controller
		SimpleReportCreator reportCreator = new SimpleReportCreator(wb, dataList);

		ExcelFileUtil.write(reportCreator.create(), outFile);

	}

	/**
	 * setup test data
	 * @return
	 */
	private static ReportData setData() {

		ReportData dataContainer = new ReportData();

		HeaderData header = new HeaderData();
		header.setReportName("SalesList");
		Map<String, String> dataMap = header.getDataMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dataMap.put("$OUTPUT_DATE", sdf.format(new Date()));
		dataMap.put("$PERIOD", "2010年4月");
		dataMap.put("$TOTAL_SALES", "780,000");
		dataContainer.setHeader(header);

		DetailsData details = new DetailsData();
		Map<String, Object[]> dataListMap = details.getDataListMap();
		dataListMap.put("$SALES_NO[]",
				new String[] { "S0000001", "S0000002", "S0000003", "S0000004", "S0000005", "S0000006", "S0000007",
						"S0000008", "S0000009", "S0000010", "S0000011", "S0000012", "S0000013", "S0000014", "S0000015",
						"S0000016", "S0000017", "S0000018", "S0000019", "S0000020", "S0000021", "S0000022", "S0000023",
						"S0000024", "S0000025", "S0000026", "S0000027" });
		dataListMap.put("$SALES_DATE[]",
				new String[] { "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01",
						"2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01",
						"2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01", "2010/04/01",
						"2010/04/01", "2010/04/02", "2010/04/02", "2010/04/02", "2010/04/02", "2010/04/02",
						"2010/04/02", "2010/04/02", "2010/04/02" });
		dataListMap.put("$CUSTOMER_CODE[]",
				new String[] { "C11111", "C11111", "C11111", "C11111", "C11111", "C11111", "C11112", "C11112", "C11112",
						"C11112", "C11112", "C11113", "C11113", "C11113", "C11113", "C11113", "C11117", "C11117",
						"C11117", "C11117", "C11117", "C11115", "C11115", "C11115", "C11119", "C11119", "C11119" });
		dataListMap.put("$EMPLOYEE_CODE[]",
				new String[] { "E0001", "E0001", "E0001", "E0001", "E0001", "E0001", "E0005", "E0005", "E0005", "E0005",
						"E0005", "E0003", "E0003", "E0003", "E0003", "E0003", "E0012", "E0012", "E0012", "E0012",
						"E0012", "E0007", "E0007", "E0007", "E0015", "E0015", "E0015" });
		dataListMap.put("$PRODUCE_CODE[]",
				new String[] { "P00001", "P00002", "P00003", "P00004", "P00005", "P00006", "P00001", "P00002", "P00003",
						"P00004", "P00005", "P00001", "P00002", "P00003", "P00004", "P00005", "P00001", "P00002",
						"P00003", "P00004", "P00005", "P00001", "P00002", "P00003", "P00001", "P00002", "P00003" });
		dataListMap.put("$AMOUNT[]",
				new Integer[] { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 1, 2, 3, });
		dataListMap.put("$SALES_AMOUNT[]",
				new Integer[] { 10000, 20000, 30000, 40000, 50000, 60000, 10000, 20000, 30000, 40000, 50000, 10000,
						20000, 30000, 40000, 50000, 10000, 20000, 30000, 40000, 50000, 10000, 20000, 30000, 10000,
						20000, 30000, });

		details.setNumOfDetails(dataListMap.get("$SALES_NO[]").length);

		dataContainer.setDetails(details);

		return dataContainer;
	}

}

