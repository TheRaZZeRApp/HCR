package de.therazzerapp.hcr.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @author ar56te876mis <ar56te876mis@yahoo.de>
 * @since <version>
 */
public class JSONConfig {
    public JSONConfigSection load(File file) {
        try {
            JsonElement parse;
            try (JsonReader jsonReader = new JsonReader(new FileReader(file))) {
                parse = new JsonParser().parse(jsonReader);
            }
            if (parse == null || parse.isJsonNull()) {
                parse = new JsonObject();
            }
            return new JSONConfigSection(parse.getAsJsonObject());
        } catch (IOException ex) {
            return newRootSection();
        }
    }

    public void save(JSONConfigSection section, File file) {
        try {
            file.getParentFile().mkdirs();
            try (JsonWriter jsonWriter = new JsonWriter(new FileWriter(file))) {
                jsonWriter.setIndent("    ");
                new Gson().toJson(section.getObject(), jsonWriter);
                jsonWriter.flush();
            }
        } catch (IOException e) {
        }
    }

    public JSONConfigSection newRootSection() {
        return new JSONConfigSection(new JsonObject());
    }
}