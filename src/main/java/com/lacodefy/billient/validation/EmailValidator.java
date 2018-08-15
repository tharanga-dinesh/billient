package com.lacodefy.billient.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lacodefy.billient.annotation.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(final ValidEmail constraintAnnotation) {
	}

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final String email, final ConstraintValidatorContext context) {
		return validateEmail(email);
	}

	/**
	 * Validate email with regular expression
	 * @param email
	 * @return true valid email, false invalid email
	 */
	private boolean validateEmail(final String email) {
		pattern = Pattern.compile(EmailValidator.EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
