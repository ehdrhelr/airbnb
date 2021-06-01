package team01.airbnb.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team01.airbnb.dto.ApiResult;
import team01.airbnb.exception.AccommodationNotFoundException;
import team01.airbnb.exception.ConditionNotFoundException;
import team01.airbnb.exception.NoResultSetException;
import team01.airbnb.exception.NotProcessJsonException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResultSetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResult noResultSetException(NoResultSetException e) {
        return ApiResult.failed(e);
    }

    @ExceptionHandler(NotProcessJsonException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult notProcessJsonException(NotProcessJsonException e) {
        return ApiResult.failed(e);
    }

    @ExceptionHandler(ConditionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResult conditionNotFoundException(ConditionNotFoundException e) {
        return ApiResult.failed(e);
    }

    @ExceptionHandler(AccommodationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResult accommodationNotFoundException(AccommodationNotFoundException e) {
        return ApiResult.failed(e);
    }
}
