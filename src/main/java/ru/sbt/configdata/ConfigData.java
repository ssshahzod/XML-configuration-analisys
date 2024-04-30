package ru.sbt.configdata;

import java.util.ArrayList;
import java.util.List;

public class ConfigData {
    private String filePath;
    private List<String> imports;

    public ConfigData(String filePath) {
        this.filePath = filePath;
        this.imports = new ArrayList<>();
    }

    public void addImport(String importName) {
        this.imports.add(importName);
    }

    public String extractFileName() {
        return null;
    }

    public void processImports() {

    }
}
