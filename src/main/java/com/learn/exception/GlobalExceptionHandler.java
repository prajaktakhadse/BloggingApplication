package com.learn.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.payload.ApiResponse;

public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	   public ResponseEntity<ApiResponse> resourceNotFoundExceptionhandler(ResourceNotFoundException ex){
		   String message =ex.getMessage();
		   ApiResponse apiResponse = new ApiResponse(message,false);
		   return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND );
	   }
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException me){
			Map<String, String> erors = new HashMap<>();
			me.getBindingResult().getAllErrors().forEach((error)-> {
			String feildName =    ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			erors.put(feildName, message);
			});
			return new ResponseEntity<>(erors, HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(ApiException.class)
		public ResponseEntity<ApiResponse> handleApiException(ApiException ex) {
			String message = ex.getMessage();
			ApiResponse apiResponse = new ApiResponse(message, true);
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
		}
}
