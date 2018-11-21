package server;

import invoker.MidBankInvoker;
import middleware.MidBankProxy;
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
		MidBankInvoker invoker = new MidBankInvoker();
		MidBankProxy proxy = new MidBankProxy();
		NamingProxy namingProxy = new NamingProxy("localhost", 6969);
		namingProxy.bind("MidBank", proxy);
		invoker.invoker(proxy);				
	}
}
