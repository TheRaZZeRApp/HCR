package de.therazzerapp.hcr.content.saver;

import de.therazzerapp.hcr.content.ConfigType;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class ConfigSaver {

    public static void save(Map<ConfigType, Object> configMap){

    }

    public static void createConfig(File file){
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
