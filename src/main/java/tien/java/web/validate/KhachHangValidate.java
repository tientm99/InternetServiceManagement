package tien.java.web.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import tien.java.web.service.KhachHangService;

/**
 * 
 */
public class KhachHangValidate implements ConstraintValidator<KhachHangExist, String> {

	@Autowired
	private KhachHangService khachHangService;
	

	@Override
	public void initialize(KhachHangExist constraintAnnotation) {
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
		if (khachHangService == null) {
			return true;
		}
		boolean ExistKH = khachHangService.khachHangExist(value);
		return create || ExistKH;
	}

}
