package com.utkrusht.registration.api.exception;

import java.util.List;

public class ApiError {
    private String message;
    private List<FieldErrorDetail> fieldErrors;

    public ApiError(String message) {
        this.message = message;
    }

    public ApiError(String message, List<FieldErrorDetail> fieldErrors) {
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldErrorDetail> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDetail> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public static class FieldErrorDetail {
        private String field;
        private String error;

        public FieldErrorDetail(String field, String error) {
            this.field = field;
            this.error = error;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}