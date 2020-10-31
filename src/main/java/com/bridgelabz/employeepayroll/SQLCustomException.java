package com.bridgelabz.employeepayroll;



public class SQLCustomException extends Exception {
	public enum ExceptionType {
        NO_SUCH_ENTRY
    }

    public ExceptionType type;

    public SQLCustomException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public SQLCustomException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

}
