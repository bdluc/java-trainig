package com.tma.RestApiConnectDB.annotations;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

//import org.apache.tomcat.util.buf.StringUtils;

//import org.apache.tomcat.util.codec.binary.StringUtils;

//import antlr.StringUtils;

public class EmailValidator implements ConstraintValidator<EmailValidation, String>{
	
	private String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			 + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext cxt) {
		
//		List<String> list = Arrays.asList(new String[] {"@"});
//		return list.contains(email);
		if (StringUtils.isBlank(email))
			 return true;

			 Pattern pat = Pattern.compile(regex);
			 return pat.matcher(email).matches();
			 }
	

}
