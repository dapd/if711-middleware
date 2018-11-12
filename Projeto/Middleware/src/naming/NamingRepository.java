/**
 * 
 */
package naming;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import proxy.ClientProxy;

/**
 * @author fabio
 *
 */
public class NamingRepository {

	private SortedMap<String, ClientProxy> services = new TreeMap<>();
	
	public NamingRepository() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the services
	 */
	public SortedMap<String, ClientProxy> getServices() {
		return services;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(SortedMap<String, ClientProxy> services) {
		this.services = services;
	}

	public void addService(String serviceName, ClientProxy clientProxy) {
		services.put(serviceName, clientProxy);
	}
	
	public ClientProxy getService(String serviceName) {
		return services.getOrDefault(serviceName, null);
	}
	
	public ClientProxy removeService(String serviceName) {
		return services.remove(serviceName);
	}
	
	public ArrayList<ClientProxy> list() {
		return (ArrayList<ClientProxy>) services.values();
	}
	
}
