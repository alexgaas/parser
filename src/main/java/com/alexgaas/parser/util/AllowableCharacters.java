package com.alexgaas.parser.util;

public interface AllowableCharacters {
    boolean isAllowed(char character);
    String getDescription();
}
