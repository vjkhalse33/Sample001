package com.fd.springbootprojects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringHelper1 {
	//@Autowired
	IService service;
	
	
	
	private static final Logger LOGGER=LogManager.getLogger(StringHelper1.class);

	public StringHelper1(IService service2) {
		this.service=service2;
	}

	public String swapLast2Chars(String str) {
		char[] charArr=str.toCharArray();
		int size=charArr.length;
		
		if(size>1) {
		char last=charArr[size-1];
		charArr[size-1]=charArr[size-2];
		charArr[size-2]=last;
		//String result=charArr.toString();
		String result=new String(charArr);
		System.out.println(result);
		LOGGER.info("Logger first log "+result);
		return result;

		}
		else {
			System.out.println(str);
			return str; 
			
		}
		
		
	}

	public String removeAFromFirstTwo(String str) {
		char[] charArr=str.toCharArray();
		
		String result=str;
	if(charArr.length>0 ) {
		char first=charArr[0];
		char sec=charArr[1];
		if((first=='a' || first=='A') &&(sec=='a' || sec=='A') ) 
		 result = ""+str.substring(2,str.length());
	else if(sec=='a' || sec=='A')
		 result = ""+first+str.substring(2,str.length());
	else if(first=='a' || first=='A')
		result = ""+sec+str.substring(2,str.length());
}
	System.out.println(str+" after remove"+result);
			
	return service.StringHelperService(str);
		
	}

}
