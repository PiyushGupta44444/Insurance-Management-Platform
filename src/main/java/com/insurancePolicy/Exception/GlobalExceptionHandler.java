package com.insurancePolicy.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.insurancePolicy.Payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//Exception for Resource not found
	@ExceptionHandler(ResourceNotFoundException.class)       
	public ResponseEntity<ApiResponse>resourceNotFoundExceptionalHandler(ResourceNotFoundException exception){
//	    	String message = exception.getMessage();
	    	ApiResponse apiResponse = new ApiResponse("Resource Not Found",false);
	    	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	//Exception for Validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
    {
    	Map<String,String>resp= new HashMap<>();
    	ex.getBindingResult().getAllErrors().forEach((error)->
    	{
    		String fieldName = ((FieldError)error).getField();
    		String message = error.getDefaultMessage();
    		resp.put(fieldName, message);
    	});
    	
    	return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
    }
	
	  @ExceptionHandler(HttpMessageNotReadableException.class)
	  public ApiResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
	        String message = "Malformed JSON request";
	        return new ApiResponse(message,false);
	  }
	  
	  @ExceptionHandler(BadCredentialsException.class)
	    public ResponseEntity<ApiResponse> handleBadCredentialsException(BadCredentialsException ex) {
	        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.UNAUTHORIZED);
	    }
	  
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiResponse> handleException(Exception ex) {
	        return new ResponseEntity<ApiResponse>(new ApiResponse("Internal Server Error",false), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
