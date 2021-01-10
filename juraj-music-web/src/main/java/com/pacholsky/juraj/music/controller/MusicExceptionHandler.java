package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.exception.MusicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice()
public class MusicExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerException(Exception e){
        log.error("Exception [{}] occurred with following stacktrace: [{}]" , e.getClass().getSimpleName() , e.toString() );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(MusicException.class)
    public ResponseEntity<String> handleMusicException(MusicException me){
        log.error(me.getMessage());
        return ResponseEntity.status(me.getErrorCode().getResponseStatus()).body(me.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> hanleArgumentException(MethodArgumentTypeMismatchException m){
        log.error(m.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleNotSupportedException(HttpRequestMethodNotSupportedException h){
        log.error(h.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(h.getMessage());
    }



}

