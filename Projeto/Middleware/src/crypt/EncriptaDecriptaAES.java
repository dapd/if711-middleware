/**
 * 
 */
package crypt;

/**
 * @author diogo
 *
 */
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class EncriptaDecriptaAES {

	static String IV = "AAAAAAAAAAAAAAAA";
	static String textopuro = "teste texto 12345678\0\0\0";
	static String chaveencriptacao = "0123456789abcdef";

//       public static void main(String [] args) {
//  
//             try {
//                     
//                    System.out.println("Texto Puro: " + textopuro);
//                      
//                    byte[] textoencriptado = encrypt(textopuro.getBytes());
//                      
//                    System.out.print("Texto Encriptado: ");
//  
//                    for (int i=0; i<textoencriptado.length; i++)
//                           System.out.print(Integer.valueOf(textoencriptado[i])+" ");
//                     
//                    System.out.println("");
//                      
//                    String textodecriptado = new String(decrypt(textoencriptado),"UTF-8");
//                      
//                    System.out.println("Texto Decriptado: " + textodecriptado);
//               
//             } catch (Exception e) {
//                    e.printStackTrace();
//             }
//       }

	public static byte[] encrypt(byte[] textopuro) throws Exception {
		Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return encripta.doFinal(textopuro);
	}

	public static byte[] decrypt(byte[] textoencriptado) throws Exception {
		Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return decripta.doFinal(textoencriptado);
	}

}
