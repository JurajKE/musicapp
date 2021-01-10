package com.pacholsky.juraj.music.exception;

import lombok.Getter;


public enum  ErrorCode {
    NOT_FOUND(404),
    BAD_REQUEST(400);

    @Getter
    private final int responseStatus;

    ErrorCode (int responceStatus){
        this.responseStatus = responceStatus;
    }
}
