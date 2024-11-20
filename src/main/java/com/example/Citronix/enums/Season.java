package com.example.Citronix.enums;

public enum Season {
    SPRING("spring"),
    SUMMER("summer"),
    AUTUMN("autumn"),
    WINTER("winter");

    private  final String s;

    Season(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
