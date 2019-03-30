package com.techm.learning.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @author:DollyShaw
 *
 * @contact:DS00337934@TECHMAHINDRA.COM
 */
@Component
public class Encryptor {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder   encoder = new BCryptPasswordEncoder();
		 
		System.out.println(encoder.encode("123"));
		
		
		
		

	}

}
