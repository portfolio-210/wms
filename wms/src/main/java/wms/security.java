package wms;

import java.security.MessageDigest;

// 패스워드 암호화 하는 인터페이스

public interface security {

	default StringBuilder secode(String passwd) throws Exception{
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(passwd.getBytes());	
		byte[] repw = md5.digest();
		
		StringBuilder sb = new StringBuilder();
		for(byte w : repw) {
		
			
			String word = String.format("%x", w);
			sb.append(word);
		}
		return sb;
	}
	
	
	
	
	
	
	
}
