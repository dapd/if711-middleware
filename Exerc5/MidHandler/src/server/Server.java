package server;

import invoker.TxtRepoInvoker;
import middleware.TxtProxy;
import naming.NamingProxy;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 */
public class Server {

	/**
	 * 
	 */
	public Server() {
		super();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		TxtRepoInvoker invoker = new TxtRepoInvoker();
		TxtProxy proxy = new TxtProxy();
		NamingProxy namingProxy = new NamingProxy("localhost", 6969);
		namingProxy.bind("TxtRepo", proxy);
		invoker.invoker(proxy);				
	}
}
