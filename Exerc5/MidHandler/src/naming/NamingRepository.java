/**
 * 
 */
package naming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
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
	
	public List<String> list() {
		Set<String> keySet = services.keySet();
		List<String> svc = new ArrayList<>();
		for (String string : keySet) {
			svc.add(string);
		}
		return svc;
	}
	
}
