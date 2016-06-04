package de.therazzerapp.hcr.content;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public enum ConfigType {
    STEAMDIR("steamDir");

    private final String name;

    ConfigType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
