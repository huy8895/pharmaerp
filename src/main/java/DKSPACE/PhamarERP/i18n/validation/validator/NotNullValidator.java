package DKSPACE.PhamarERP.i18n.validation.validator;

import DKSPACE.PhamarERP.i18n.validation.NotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

    /**
     * Kiểm tra tính hợp lệ của trường được đánh dấu bởi @NotNull
     */
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) return false;
        if (object instanceof CharSequence charSequence) {
            return charSequence.toString().trim().length() > 0;
        }
        return true;
    }
}
