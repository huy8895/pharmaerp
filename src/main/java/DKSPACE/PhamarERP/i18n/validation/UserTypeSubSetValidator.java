package DKSPACE.PhamarERP.i18n.validation;

import DKSPACE.PhamarERP.auth.enums.UserType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class UserTypeSubSetValidator implements ConstraintValidator<UserTypeSubset, String> {
    private Set<UserType> userTypesMustIn;
    private Set<UserType> userTypesMustNotIn;

    @Override
    public void initialize(UserTypeSubset constraint) {
        this.userTypesMustIn = Set.of(constraint.anyOf().length == 0 ? UserType.values() : constraint.anyOf() );
        this.userTypesMustNotIn = Set.of(constraint.noneOf());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        boolean anyOf = userTypesMustIn.stream()
                                   .map(Enum::name)
                                   .anyMatch(s -> s.equals(value));
        boolean noneOf = userTypesMustNotIn.stream()
                                      .map(Enum::name)
                                      .noneMatch(s -> s.equals(value));
        return anyOf && noneOf;
    }
}
