package report;

/**
 *
 *
 * @author Copyright (C) 2010 Advan Corp inc.
 *
 *
 */
public class ReportData {

	private HeaderData header;

	private DetailsData details;

	/**
	 *
	 * @return
	 */
	public DetailsData getDetails() {
		return details;
	}

	/**
	 *
	 * @param details
	 */
	public void setDetails(DetailsData details) {
		this.details = details;
	}

	/**
	 *
	 * @return
	 */
	public HeaderData getHeader() {
		return header;
	}

	/**
	 *
	 * @param header
	 */
	public void setHeader(HeaderData header) {
		this.header = header;
	}

}
