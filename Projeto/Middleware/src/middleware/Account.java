/**
 * 
 */
package middleware;

/**
 * @author fabio
 *
 */
public class Account {
	private String id;
	private String pswd;
	private Integer accountNumber;
	private Integer bankBranchNumber;
	private String cardId;

	/**
	 * @param id
	 * @param pswd
	 * @param accountNumber
	 * @param bankBranchNumber
	 * @param cardId
	 */
	public Account(String id, String pswd, Integer accountNumber, Integer bankBranchNumber, String cardId) {
		super();
		this.id = id;
		this.pswd = pswd;
		this.accountNumber = accountNumber;
		this.bankBranchNumber = bankBranchNumber;
		this.cardId = cardId;
	}



	public Account() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getBankBranchNumber() {
		return bankBranchNumber;
	}

	public void setBankBranchNumber(Integer bankBranchNumber) {
		this.bankBranchNumber = bankBranchNumber;
	}

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
