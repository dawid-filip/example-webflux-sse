package com.pl.df;

public enum SsePathVariable {

    SSE_LENGTH ("length");

    private String value;

    SsePathVariable(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
