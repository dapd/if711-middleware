/**
 * 
 */
package message;

import java.io.Serializable;

/**
 * @author fabio
 *
 */
public class OperationReturn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private Integer code;

	/**
	 * @param msg
	 * @param code
	 */
	public OperationReturn(String msg, Integer code) {
		this.msg = msg;
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

}
