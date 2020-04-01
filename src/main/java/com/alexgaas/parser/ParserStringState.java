package com.alexgaas.parser;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParserStringState implements ParserState {

    private int current = 0;
    private CharSequence charSequence;

    private final Deque<Integer> charArray = new ArrayDeque<>();

    public ParserStringState(CharSequence string) {
        this.charSequence = string;
    }

    @Override
    public int current() {
        return current < charSequence.length() ? charSequence.charAt(current) : -1;
    }

    @Override
    public int next() {
        current = (++current > charSequence.length()) ? charSequence.length() : current;
        return current();
    }

    @Override
    public int getPosition() {
        return current;
    }

    @Override
    public void push() {
        charArray.push(current);
    }

    @Override
    public void pop() {
        charArray.pop();
    }

    @Override
    public void popAndGetBackItsPosition() {
        current = charArray.pop();
    }
}
