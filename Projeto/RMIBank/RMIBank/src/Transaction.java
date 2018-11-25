import java.util.Date;

/**
 * @author fabio
 * @author diogo
 * @author marina
 *
 */
public class Transaction {

	private String id;
	private String operationName;
	private String value;
	private String date;

	/**
	 * @param id
	 * @param operationName
	 * @param value
	 * @param date
	 */
	public Transaction(String id, String operationName, String value, String date) {
		super();
		this.id = id;
		this.operationName = operationName;
		this.value = value;
		this.date = date;
	}

	/**
	 * 
	 */
	public Transaction() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the operationName
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * @param operationName the operationName to set
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
