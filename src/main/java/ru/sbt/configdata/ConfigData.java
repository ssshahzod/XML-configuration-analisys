package ru.sbt.configdata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ConfigData {
    private static final Pattern IMPORT_LINE = Pattern.compile("<import.+");

    private String filePath;
    private String fileName;
    private List<String> imports;

    public ConfigData(String filePath) {
        this.filePath = filePath;
        this.fileName = extractFileName();
        this.imports = new ArrayList<>();
    }

    public void addImport(String importName) {
        this.imports.add(importName);
    }

    public String extractFileName() {
        return null;
    }

    public void processImports() {
        try (BufferedReader fileStream = new BufferedReader(new FileReader(filePath))) {
            var line = fileStream.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
