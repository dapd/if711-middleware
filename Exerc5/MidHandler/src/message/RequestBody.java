package message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RequestBody implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4838014538014350925L;
	private ArrayList<Object> parameters = new ArrayList<Object>();
	
	/**
	 * @param parameters
	 */
	public RequestBody(List<Object> parameters) {
		super();
		this.parameters = (ArrayList<Object>) parameters;
	}
	/**
	 * @return the parameters
	 */
	public ArrayList<Object> getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}
	
}
