package com.chess.common;

public enum File {
    A, B, C, D, E, F, G, H;

    public File next() {
        return this.next();
    }

    public File previous() {
        return this.previous();
    }

    @Override
    public String toString() {
        return this.name();
    }
}
