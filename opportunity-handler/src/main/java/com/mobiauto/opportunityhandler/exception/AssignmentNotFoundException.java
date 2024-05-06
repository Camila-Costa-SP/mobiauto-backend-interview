package com.mobiauto.opportunityhandler.exception;

public class AssignmentNotFoundException extends RuntimeException {
    public AssignmentNotFoundException() {
        super("Assignment not found");
    }
}