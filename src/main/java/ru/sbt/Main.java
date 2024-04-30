package ru.sbt;

import ru.sbt.files.FileWalker;

public class Main {
    public static void main(String[] args) {
        var walker = new FileWalker(args[0]);
        walker.files();
    }
}