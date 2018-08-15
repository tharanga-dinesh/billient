/**
 *
 */
package com.lacodefy.billient.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lacodefy.billient.annotation.PasswordMatches;
import com.lacodefy.billient.dto.user.UserDTO;

/**
 * @author Tharanaga Dinesh
 *
 */
public class PasswordMatchValidator implements ConstraintValidator<PasswordMatches, Object> {

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(final PasswordMatches constraintAnnotation) {

	}

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
		final UserDTO user = (UserDTO) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}


}
