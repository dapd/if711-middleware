package message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequestBody implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4838014538014350925L;
	private ArrayList<String> parameters = new ArrayList<String>();
	
	/**
	 * @param list
	 */
	public RequestBody(List<String> list) {
		super();
		this.parameters = (ArrayList<String>) list;
	}
	/**
	 * @return the parameters
	 */
	public ArrayList<String> getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
	
}
