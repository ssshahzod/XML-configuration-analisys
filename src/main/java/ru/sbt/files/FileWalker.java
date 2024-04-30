package ru.sbt.files;

import org.yaml.snakeyaml.Yaml;
import ru.sbt.configdata.ConfigData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileWalker {
    private String startFolder;

    public FileWalker(String startFolder) {
        this.startFolder = startFolder;
    }

    @SuppressWarnings("unchecked")
    public List<ConfigData> files() {
        List<ConfigData> paths = new ArrayList<>();
        Yaml yamlReader = new Yaml();
        Map<String, Object> params = (Map<String, Object>) yamlReader.load("config.yaml");
        var fileExtension = (String) params.get("extension");

        try (Stream<Path> walkStream = Files.walk(Paths.get(startFolder))) {
            walkStream.filter(p -> p.toFile().isFile()).forEach(f -> {
                if (f.toString().endsWith(fileExtension)) {
                    var config = new ConfigData(f.toString());
                    paths.add(config);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return paths;
    }
}
