package de.therazzerapp.hcr.content.loader;

import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;
import de.therazzerapp.hcr.content.ConfigType;
import de.therazzerapp.hcr.content.saver.ConfigSaver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class ConfigLoader {
    public static Map<ConfigType, Object> load(){
        Map<ConfigType, Object> configMap = new HashMap<>();

        File file = new File("./Data/config.json");
        if(!file.exists()){
            ConfigSaver.createConfig(file);
        }

        JSONConfigSection root = new JSONConfig().load(file);
        configMap.put(ConfigType.STEAMDIR, root.getString(ConfigType.STEAMDIR.getName(), ""));

        return configMap;
    }


}
