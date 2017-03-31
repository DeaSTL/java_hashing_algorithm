package test_project;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class easyhash {
	private static BigInteger hash_digest;
	public easyhash(String input,String algorithm){
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			digest.update(input.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hash = digest.digest();
		String main_string = "";
		for(int i = 0;i<hash.length;i++){
			int tmp = Math.abs((int)hash[i]);
			main_string += tmp;
		}
		hash_digest = new BigInteger(main_string,10);

	}
	
	public static String getHex(){
		return hash_digest.toString(16);
	}
	public static String getBin(){
		return hash_digest.toString(2);
	}
	public static String getDec(){
		return hash_digest.toString(10);
	}
	public static String getBase64(){
		return Base64.encode(hash_digest.toByteArray());
	}
	
}
