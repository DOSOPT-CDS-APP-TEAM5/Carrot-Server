package CarrotServer.exception;

import CarrotServer.common.response.ApiResponse;
import CarrotServer.exception.enums.Error;
import CarrotServer.exception.model.CarrotException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ CarrotException.class })
    protected ApiResponse handleCustomException(CarrotException ex) {
        return ApiResponse.error(ex.getError());
    }

    @ExceptionHandler({ Exception.class })
    protected ApiResponse handleServerException(Exception ex) {
        return ApiResponse.error(Error.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ApiResponse<HashMap> handleServerException(NoHandlerFoundException ex) {
        HashMap<String,String> pathMap = new HashMap<>();
        pathMap.put("path",ex.getRequestURL());
        return ApiResponse.error(Error.NOT_FOUND_PATH, pathMap);
    }
}
