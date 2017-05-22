package com.org.projector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such entity")  // 404
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
}
