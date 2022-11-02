package com.mennomuller.util;

public class TextHandler {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_MAGENTA = "\u001B[95m";
    public static final String ANSI_WHITE = "\u001B[97m";
    public static final String ANSI_CYAN = "\u001B[96m";
    public static final String ANSI_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[94m";
    public static final String ANSI_RED = "\u001B[91m";
    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_GRAY = "\u001B[90m";

    public static String color(String text, Color color) {
        return color.ansiCode + text + ANSI_RESET;
    }

    public static void printlnColor(String text, Color color) {
        System.out.println(color(text, color));
    }

    public enum Color {
        MAGENTA(ANSI_MAGENTA),
        WHITE(ANSI_WHITE),
        CYAN(ANSI_CYAN),
        YELLOW(ANSI_YELLOW),
        BLUE(ANSI_BLUE),
        RED(ANSI_RED),
        GREEN(ANSI_GREEN),
        GRAY(ANSI_GRAY);
        public final String ansiCode;

        Color(String ansiCode) {
            this.ansiCode = ansiCode;
        }
    }
}

