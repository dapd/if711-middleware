package middleware;

import java.io.IOException;
import java.rmi.RemoteException;

import proxy.ClientProxy;

public class TxtProxy extends ClientProxy implements ITxtRepo{
	private static final long serialVersionUTD = 1L;
	
	public TxtProxy() {};
	public TxtProxy(String h, String i) {};

	public byte[] request(String filename) throws RemoteException, IOException{
		return null;}
}
