package main.component;

import main.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class TourValidator implements Validator {
    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(Class<?> clazz) {
        return Tour.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tour tour = (Tour) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty", getMessage("NotEmpty"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty", getMessage("NotEmpty"));
        ValidationUtils.rejectIfEmpty(errors, "continent", "NotEmpty", getMessage("NotEmpty"));
        ValidationUtils.rejectIfEmpty(errors, "date", "NotEmpty", getMessage("NotEmpty"));
        ValidationUtils.rejectIfEmpty(errors, "duration", "NotEmpty", getMessage("NotEmpty"));

        if (tour.getDuration() < 7 || tour.getDuration() > 21) {
            errors.rejectValue("duration", "Invalid.durationRange", getMessage("Invalid.durationRange"));
        }
        validateName(tour.getName(), errors);
        validateDate(tour.getDate(), errors);
        validateCode(tour.getCode(), errors);
    }

    private void validateName(String name, Errors errors) {
        if (name == null || name.length() < 5) {
            errors.rejectValue("name", "Invalid.name", getMessage("Invalid.name"));
        }
    }

    private void validateDate(Date date, Errors errors) {
        if (date != null && date.before(new Date())) {
            errors.rejectValue("date", "Invalid.date", getMessage("Invalid.date"));
        }
    }

    private void validateCode(String code, Errors errors) {
        if (!code.matches("^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$")) {
            errors.rejectValue("code", "Invalid.code", getMessage("Invalid.code"));
        }
    }

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, null);
    }
}
