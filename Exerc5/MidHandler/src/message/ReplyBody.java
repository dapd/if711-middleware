package message;

import java.io.Serializable;

public class ReplyBody implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1888310685541157249L;
	private Object newfile;
	
	/**
	 * @param newfile
	 */
	public ReplyBody(Object newfile) {
		super();
		this.newfile = newfile;
	}
	/**
	 * @return the newfile
	 */
	public Object getNewfile() {
		return newfile;
	}
	/**
	 * @param newfile the newfile to set
	 */
	public void setNewfile(Object newfile) {
		this.newfile = newfile;
	}
}
