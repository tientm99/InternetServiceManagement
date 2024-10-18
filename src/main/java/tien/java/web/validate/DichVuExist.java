/**
 * 
 */
package tien.java.web.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 */
@Constraint(validatedBy = DichVuValidate.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DichVuExist {
	public String message() default "Mã dịch vụ đã tồn tại";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
	
	boolean create() default false;
}
