package me.choicore.springbootddd.interfaces.rest;

public sealed interface ApiResponse<T> {
    static <T> ApiResponse<T> succeed(T data) {
        return new Succeed<>(ResultType.SUCCEED, data);
    }

    static <T> ApiResponse<T> failed(String message) {
        return new Failed<>(ResultType.FAILED, message);
    }

    record Succeed<T>(ResultType resultType, T data) implements ApiResponse<T> {
    }

    record Failed<T>(ResultType resultType, String message) implements ApiResponse<T> {
    }

}
