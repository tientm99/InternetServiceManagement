/**
 * 
 */
package tien.java.web.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import tien.java.web.service.MayService;

/**
 * 
 */
public class MayValidate implements ConstraintValidator<MayExist, String>{
	@Autowired
	private MayService mayService;
	

	@Override
	public void initialize(MayExist constraintAnnotation) {
	}
	
	private boolean create;

	/**
	 * Account: Trần Minh Tiến Birthday: 1999/04/15
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0) {
			return true;
		}
		if (mayService == null) {
			return true;
		}
		boolean ExistKH = mayService.mayExist(value);
		return create || ExistKH;
	}
}
