package me.choicore.springbootddd.interfaces.rest;

import lombok.Builder;

public sealed interface ApiResponse<T> {

    static <T> ApiResponse<T> succeed(T data) {
        return new Succeed<>(ResultType.SUCCEED, data);
    }


    static <T> ApiResponse<T> failed(Error error) {
        return new Failed<>(ResultType.FAILED, error);
    }

    enum ResultType {
        SUCCEED, FAILED
    }

    record Succeed<T>(ResultType resultType, T data) implements ApiResponse<T> {

        @Builder
        public Succeed {
        }

    }


    record Failed<T>(ResultType resultType, Error error) implements ApiResponse<T> {
    }

    record Error(int status, String message, String endpoint) {
        @Builder
        public Error {
        }

    }

}
