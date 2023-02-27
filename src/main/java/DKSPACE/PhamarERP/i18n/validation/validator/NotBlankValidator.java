package DKSPACE.PhamarERP.i18n.validation.validator;

import DKSPACE.PhamarERP.i18n.validation.NotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotBlank, CharSequence> {

    /**
     * Kiểm tra tính hợp lệ của trường được đánh dấu bởi @NotNull
     */
    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence == null) {
            return false;
        } else {
            return charSequence.toString().trim().length() > 0;
        }
    }
}
