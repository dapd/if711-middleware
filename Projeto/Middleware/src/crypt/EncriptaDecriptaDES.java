/**
 * 
 */
package crypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author diogo
 * @author fabio
 * @author marina
 *
 */
public class EncriptaDecriptaDES {

	private static KeyGenerator keygenerator;
	private static SecretKey chaveDES;

	/**
	 * 
	 */
	public EncriptaDecriptaDES() {
		// TODO Auto-generated constructor stub
	}
	
	public static byte[] encripta(byte[] message) {
		
		byte[] bs = null;
		try{
			keygenerator = KeyGenerator.getInstance("DES");
			chaveDES = keygenerator.generateKey();
			
            Cipher cifraDES;

            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra para o processo de encripta��o
            cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);

            // Texto encriptado
            bs = cifraDES.doFinal(message);

        }catch(NoSuchAlgorithmException e){
               e.printStackTrace();
        }catch(NoSuchPaddingException e){
               e.printStackTrace();
        }catch(InvalidKeyException e){
               e.printStackTrace();
        }catch(IllegalBlockSizeException e){
               e.printStackTrace();
        }catch(BadPaddingException e){
               e.printStackTrace();
        }
		return bs;
	}
	
	public static byte[] decripta(byte[] cryptMessage) {
		byte[] bs = null;
		try{
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey chaveDES = keygenerator.generateKey();
            Cipher cifraDES;

            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra tamb�m para o processo de decripta��o
            cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);

            // Decriptografa o texto
			bs = cifraDES.doFinal(cryptMessage);

        }catch(NoSuchAlgorithmException e){
               e.printStackTrace();
        }catch(NoSuchPaddingException e){
               e.printStackTrace();
        }catch(InvalidKeyException e){
               e.printStackTrace();
        }catch(IllegalBlockSizeException e){
               e.printStackTrace();
        }catch(BadPaddingException e){
               e.printStackTrace();
        }
		return bs;
	}

}