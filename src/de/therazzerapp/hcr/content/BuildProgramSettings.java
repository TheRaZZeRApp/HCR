package de.therazzerapp.hcr.content;

import java.io.File;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public abstract class BuildProgramSettings {

    protected String game;
    protected Integer threads;
    protected boolean verbose;
    protected boolean low;
    protected boolean noVConfig;
    protected String vProject;

    public BuildProgramSettings(String game, Integer threads, boolean verbose, boolean low, boolean noVConfig, String vProject) {
        this.game = game;
        this.threads = threads;
        this.verbose = verbose;
        this.low = low;
        this.noVConfig = noVConfig;
        this.vProject = vProject;
    }

    protected String getGameDir(String gameDir){
        StringBuilder stringBuilder = new StringBuilder();
        if (game != null){
            if(gameDir == null){
                stringBuilder.append("-game \"" + game + "\" ");
            } else {
                if(gameDir.equals("default") || !(new File(gameDir).exists())){
                    stringBuilder.append("-game \"" + game + "\" ");
                } else {
                    stringBuilder.append("-game \"" + gameDir + "\" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public abstract String getFileType();

    public String getGame() {
        return game;
    }

    public Integer getThreads() {
        return threads;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public boolean isLow() {
        return low;
    }

    public boolean isNoVConfig() {
        return noVConfig;
    }

    public String getvProject() {
        return vProject;
    }

    public abstract String getParam(String gameDir);
}
