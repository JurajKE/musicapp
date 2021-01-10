package com.pacholsky.juraj.music.exception;

import lombok.Getter;

@Getter
public class MusicException extends RuntimeException {

    private final ErrorCode errorCode;

    public MusicException(ErrorCode errorCode , String message){
        super(message);
        this.errorCode = errorCode;
    }

    public MusicException(ErrorCode errorCode , String message , Throwable throwable){
        super(message , throwable);
        this.errorCode = errorCode;
    }



}
