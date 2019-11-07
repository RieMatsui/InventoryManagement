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
public class DetailsData {

	private int numOfDtails = 0;

	private Map<String, Object[]> dataListMap = new HashMap<String, Object[]>();

	/**
	 *
	 * @return
	 */
	public Map<String, Object[]> getDataListMap() {
		return dataListMap;
	}

	/**
	 *
	 * @param dataListMap
	 */
	public void setDataListMap(Map<String, Object[]> dataListMap) {
		this.dataListMap = dataListMap;
	}

	/**
	 *
	 * @return
	 */
	public int getNumOfDetails() {
		return numOfDtails;
	}

	/**
	 *
	 * @param numOfDtails
	 */
	public void setNumOfDetails(int numOfDtails) {
		this.numOfDtails = numOfDtails;
	}

}
