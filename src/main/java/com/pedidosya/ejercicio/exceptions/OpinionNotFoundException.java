package com.pedidosya.ejercicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OpinionNotFoundException extends RuntimeException {

  public OpinionNotFoundException(String exception) {
    super(exception);
  }

}