package com.rd.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActorErrorController {
	
	@ExceptionHandler(ActorNotFoundException.class)
	public ResponseEntity<ActorError> handleActorNotFoundException(ActorNotFoundException actorException){
		ActorError actorError = new ActorError(LocalDateTime.now(), actorException.getMessage(), "400 try again later ");
		return new ResponseEntity<ActorError>(actorError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ActorError> handleAllException(Exception exception){
		ActorError actorError = new ActorError(LocalDateTime.now(), exception.getMessage(), "Problem in Execution ");
		return new ResponseEntity<ActorError>(actorError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
