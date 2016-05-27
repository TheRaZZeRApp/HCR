package de.therazzerapp.hcr.content;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildSettings {

    private VRADSettings vradSettings;
    private VBSPSettings vbspSettings;
    private VVISSettings vvisSettings;
    private BuildProgram vbsp;
    private BuildProgram vvis;
    private BuildProgram vrad;
    private String name;
    private String displayName;
    private String comment;
    private String gameDir;

    public BuildSettings(VRADSettings vradSettings, VBSPSettings vbspSettings, VVISSettings vvisSettings, BuildProgram vbsp, BuildProgram vvis, BuildProgram vrad, String name, String displayName, String comment) {
        this.vradSettings = vradSettings;
        this.vbspSettings = vbspSettings;
        this.vvisSettings = vvisSettings;
        this.vbsp = vbsp;
        this.vvis = vvis;
        this.vrad = vrad;
        this.name = name;
        this.displayName = displayName;
        this.comment = comment == null ? "" : comment;
        this.gameDir = null;
    }

    public BuildProgram[] getBuildProgramms(){
        return new BuildProgram[] {vbsp,vvis,vrad};
    }

    public BuildProgramSettings getBuildProgramSettings(BuildProgramType type){
        switch (type){
            case VBSP:
                return vbspSettings;
            case VVIS:
                return vvisSettings;
            case VRAD:
                return vradSettings;
            default:
                return null;
        }
    }

    public VRADSettings getVradSettings() {
        return vradSettings;
    }

    public VBSPSettings getVbspSettings() {
        return vbspSettings;
    }

    public VVISSettings getVvisSettings() {
        return vvisSettings;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public BuildProgram getVbsp() {
        return vbsp;
    }

    public BuildProgram getVvis() {
        return vvis;
    }

    public BuildProgram getVrad() {
        return vrad;
    }

    public String getGameDir() {
        return gameDir;
    }

    public void setGameDir(String gameDir) {
        this.gameDir = gameDir;
    }
}
