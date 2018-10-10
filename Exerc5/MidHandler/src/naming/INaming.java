/**
 * 
 */
package naming;

import java.util.ArrayList;

import proxy.ClientProxy;

/**
 * @author fabio
 *
 */
public interface INaming {

	public void bind(String serviceName, ClientProxy clientProxy);
	
	public ClientProxy lookup(String serviceName);
	
	public ArrayList<String> list();
	
	public void unbind(String serviceName);
}
