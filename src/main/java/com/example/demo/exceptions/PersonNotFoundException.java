package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason="The person is not found")
public class PersonNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -20785673567546356L;
}
