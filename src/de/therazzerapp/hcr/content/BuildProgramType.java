package de.therazzerapp.hcr.content;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public enum BuildProgramType {

    VBSP("Valve Binary Space Partition"),
    VRAD("Valve Radiosity Simulator"),
    VVIS("Valve Visible Information Set");

    private final String name;

    BuildProgramType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
