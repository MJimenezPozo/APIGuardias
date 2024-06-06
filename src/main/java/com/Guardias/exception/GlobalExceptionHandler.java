package com.Guardias.exception;

import com.Guardias.payload.ApiResponse;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest) {

		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));

		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception,
			WebRequest webRequest) {

		Map<String, String> mapErrors = new HashMap<>();

		exception.getBindingResult().getAllErrors().forEach((error) -> {

			String clave = ((FieldError) error).getField();
			String valor = error.getDefaultMessage();
			mapErrors.put(clave, valor);

		});

		ApiResponse apiResponse = new ApiResponse(mapErrors.toString(), webRequest.getDescription(false));

		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(BadDateException.class)
	public ResponseEntity<ApiResponse> handlerParseException(BadDateException exception, WebRequest webRequest) {
		
		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));

		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handlerException(Exception exception, WebRequest webRequest) {
		
		ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));

		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}
        
        
        @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRuntimeException(RuntimeException ex){
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_GATEWAY);
    }    
    
}
