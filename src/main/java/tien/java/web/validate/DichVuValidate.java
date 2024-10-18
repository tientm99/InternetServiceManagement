/**
 * 
 */
package tien.java.web.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import tien.java.web.service.DichVuService;

/**
 * 
 */
public class DichVuValidate implements ConstraintValidator<DichVuExist, String> {
	@Autowired
	private DichVuService dichVuService;
	
	@Override
	public void initialize(DichVuExist constraintAnnotation) {
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
		if (dichVuService == null) {
			return true;
		}
		boolean ExistDV = dichVuService.dichVuExist(value);
		return create || ExistDV;
	}
}
