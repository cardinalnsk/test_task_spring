package ru.cardinal.testtask.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class UserException {
    private final String Message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
