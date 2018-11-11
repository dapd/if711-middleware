/**
 * 
 */
package naming;

import java.io.Serializable;

import proxy.ClientProxy;

/**
 * @author fabio
 *
 */
public class NamingRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8567774404346130464L;
	private String operation;
	private String serviceName;
	private ClientProxy clientProxy;

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @param serviceName
	 * @param clientProxy
	 */
	public NamingRecord(String operation, String serviceName, ClientProxy clientProxy) {
		super();
		this.operation = operation;
		this.serviceName = serviceName;
		this.clientProxy = clientProxy;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the clientProxy
	 */
	public ClientProxy getClientProxy() {
		return clientProxy;
	}

	/**
	 * @param clientProxy the clientProxy to set
	 */
	public void setClientProxy(ClientProxy clientProxy) {
		this.clientProxy = clientProxy;
	}

}
