
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TxtRepoImpl extends UnicastRemoteObject implements ITxtRepo {

	protected TxtRepoImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public byte[] request(String filename) throws RemoteException, IOException {
		byte data[] = new byte[1024];
		// Criando classe do arquivo a ser enviado
		File file = new File("repository/" + filename);

		// Enviando arquivo
		FileInputStream fileStream = new FileInputStream(file);
		BufferedInputStream fileBuffer = new BufferedInputStream(fileStream);
		fileBuffer.read(data);
		fileBuffer.close();
		fileStream.close();
		return data;
	}

}
