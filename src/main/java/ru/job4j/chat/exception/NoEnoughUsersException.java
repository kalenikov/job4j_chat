package ru.job4j.chat.exception;

public class NoEnoughUsersException extends Exception {
    public NoEnoughUsersException(String message) {
        super(message);
    }
}
