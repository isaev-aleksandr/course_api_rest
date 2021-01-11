package ru.isaev.course.demo.Rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid `base` currency [FFF]. Please ensure you use the standard international code, " +
        "and that it is supported by the API. See our documentation for details: https://openexchangerates.org/documentation/.")
public class ThereIsIncorrectCurrency extends RuntimeException {

}
