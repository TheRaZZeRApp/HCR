package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.content.ConfigType;
import de.therazzerapp.hcr.content.loader.ConfigLoader;
import de.therazzerapp.hcr.content.saver.ConfigSaver;
import de.therazzerapp.hcr.gui.ContentObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class ConfigManager {
    private static Map<ConfigType, Object> configMap = new HashMap<>();

    public static void load(){
        configMap = ConfigLoader.load();
        ContentObserver.update(2);
    }

    public static void save(){
        ConfigSaver.save(configMap);
        ContentObserver.update(2);
    }

    public static Object getConfigProperty(ConfigType configProperty){
        return configMap.get(configProperty);
    }

    public static void setConfigProperty(ConfigType configProperty, Object value){
        configMap.put(configProperty,value);
        save();
    }
}
