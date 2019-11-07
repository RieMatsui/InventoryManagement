package report;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Copyright (C) 2010 Advan Corp inc.
 *
 *
 */
public class HeaderData {

	private String reportName = null;

	private Map<String, String> dataMap = new HashMap<String, String>();

	/**
	 *
	 * @return
	 */
	public Map<String, String> getDataMap() {
		return dataMap;
	}

	/**
	 *
	 * @param dataMap
	 */
	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 *
	 * @return
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 *
	 * @param reportName
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

}
