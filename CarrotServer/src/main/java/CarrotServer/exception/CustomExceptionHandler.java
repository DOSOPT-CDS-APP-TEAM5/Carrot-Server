package CarrotServer.exception;

import CarrotServer.common.response.ApiResponse;
import CarrotServer.exception.enums.Error;
import CarrotServer.exception.model.CarrotException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler({ CarrotException.class })
    protected ApiResponse handleCustomException(CarrotException ex) {
        return ApiResponse.error(ex.getError());
    }

    @ExceptionHandler({ Exception.class })
    protected ApiResponse handleServerException(Exception ex) {
        log.error(ex.getMessage());
        return ApiResponse.error(Error.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ApiResponse<HashMap> handleNotFoundException(NoHandlerFoundException ex) {
        HashMap<String,String> pathMap = new HashMap<>();
        pathMap.put("path",ex.getRequestURL());
        return ApiResponse.error(Error.NOT_FOUND_PATH, pathMap);
    }
}
