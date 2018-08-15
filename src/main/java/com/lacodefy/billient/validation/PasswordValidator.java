/**
 *
 */
package com.lacodefy.billient.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lacodefy.billient.annotation.ValidPassword;

/**
 * @author Tharanaga Dinesh
 *
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String>{

	private Pattern pattern;
	private Matcher matcher;
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final String password, final ConstraintValidatorContext context) {
		return validatePassword(password);
	}

	/**
	 * Validate password with regular expression
	 * @param password
	 * @return true valid password, false invalid password
	 */
	private boolean validatePassword(final String password) {
		pattern = Pattern.compile(PasswordValidator.PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
