package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.auth.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsernameValidator implements ConstraintValidator<UniqueUser, String> {
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return userRepository.findByEmailOrUsername(value)
                             .isEmpty();
    }
}
