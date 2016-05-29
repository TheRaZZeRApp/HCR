package de.therazzerapp.hcr.content;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildProgram {
    private String name;
    private String displayName;
    private String comment;
    private String path;
    private BuildProgramType buildProgramType;

    public BuildProgram(String name, String displayName, String comment, String path, BuildProgramType buildProgramType) {
        this.name = name;
        this.displayName = displayName;
        this.comment = comment;
        this.path = path;
        this.buildProgramType = buildProgramType;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public BuildProgramType getBuildProgramType() {
        return buildProgramType;
    }

    public String getComment() {
        return comment;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
