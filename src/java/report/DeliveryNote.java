package report;

import java.util.ArrayList;
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
public class DeliveryNote {

	private static String inFile = null;

	private static String outFile = null;

	/**
         * 実行エントリーポイント
         * 引数にファイルPassに設定したものが存在しているかどうかを確認する
         * 実行処理を行う
         * 構成の確認
	 * @param file
	 * @throws Exception
	 */
	public void  createExcelFile(String[] file) throws Exception {

		// check arguments
		if (file == null || file.length != 2) {
			System.out.println("error of arguments");
			System.exit(1);
		}

		// check inputFile　書きだしもとファイル名があるかどうかを確認
		if (!ExcelFileUtil.isExistExcelFile(file[0])) {
			System.out.println("error of inputFile");
			System.exit(1);
		}
		inFile = file[0];

		// check outputFile　書き出したいファイルがあるかどうか
		if (!ExcelFileUtil.isExcelFile(file[1])) {
			System.out.println("error of outputFile");
			System.exit(1);
		}
		outFile = file[1];

		// create workbook(インプットするエクセルファイルを決定する)
		Workbook wb = ExcelFileUtil.getWorkbook(inFile);
		// create data
                //セットしたいデータを呼び出す
		List<ReportData> dataList = new ArrayList<ReportData>();
		dataList.add(setData());
                
                //SimpleReportCreatorのコンストラクタに作成するファイル名とセットするデータを
                //初期値として代入しセットする
		SimpleReportCreator reportCreator = new SimpleReportCreator(wb, dataList);
                //エクセルファイルを書き出す
		ExcelFileUtil.write(reportCreator.create(), outFile);

	}

	/**
	 * setup test data
	 * @param number
	 * @return
	 */
	private static ReportData setData() {

		ReportData dataContainer = new ReportData();
                
		HeaderData header = new HeaderData();
		Map<String, String> dataMap = header.getDataMap();

		DetailsData details = new DetailsData();
		Map<String, Object[]> dataListMap = details.getDataListMap();


			header.setReportName("テストシート01_20170316");
			dataMap.put("$DELIVERY_NO", "01000001");
			dataMap.put("$POST_CODE", "111-1111");
			dataMap.put("$ADDRESS1", "東京都AA区AAA5-6-78");
			dataMap.put("$ADDRESS2", "AAAAAビルディング11階");
			dataMap.put("$CUSTOMER_NAME", "(株)WITC");
			dataMap.put("$CREATE_DATE", "2010/04/01");
			dataMap.put("$CREATE_NAME", "2010/04/04");
			dataMap.put("$S_TOTAL_SALES", "1,300,000");
			dataMap.put("$S_AMOUNT", "65,000");
			dataMap.put("$S_TOTAL_SALES_WT", "1,365,000");
                        dataMap.put("$T_TOTAL_SALES", "1,300,000");
			dataMap.put("$T_AMOUNT", "65,000");
			dataMap.put("$T_TOTAL_SALES_WT", "1,365,000");

			dataListMap.put("$SYOHIN_ID[]", new String[] { "A0001", "B0002", "C0003", "D0004", "E0005" });
			dataListMap.put("$CATEGORY_ID[]", new String[] { "アドバン・スマートフォンA", "アドバン・スマートフォンB", "アドバン・スマートフォンC",
					"アドバン・スマートフォンD", "アドバン・スマートフォンE" });
			dataListMap.put("$SYOHIN_NAME[]", new String[] { "5", "10", "15", "20", "25", });
			dataListMap.put("$URIAGEKINGAKIU[]", new String[] { "12,000", "14,000", "16,000", "18,000", "20,000" });

			details.setNumOfDetails(dataListMap.get("$SYOHIN_ID[]").length);


		dataContainer.setHeader(header);
		dataContainer.setDetails(details);
		return dataContainer;
	}

}

