package de.therazzerapp.hcr.content;

import de.therazzerapp.hcr.HCR;

import java.io.*;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompileSet{

    private String vmfPath;
    private BuildSettings buildSettings;
    private BuildProgram vbsp;
    private BuildProgram vvis;
    private BuildProgram vrad;
    private String outputVBSP;
    private String outputVVIS;
    private String outputVRAD;
    private Process processVBSP;
    private Process processVVIS;
    private Process processVRAD;
    boolean continueCompile = true;

    public CompileSet(String vmfPath, BuildSettings buildSettings) {
        this.vmfPath = vmfPath;
        this.buildSettings = buildSettings;
        this.vbsp = buildSettings.getVbsp();
        this.vvis = buildSettings.getVvis();
        this.vrad = buildSettings.getVrad();
    }

    public String getVmfPath() {
        return vmfPath;
    }

    public BuildSettings getBuildSettings() {
        return buildSettings;
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

    public String getOutputVBSP() {
        return outputVBSP;
    }

    public String getOutputVVIS() {
        return outputVVIS;
    }

    public String getOutputVRAD() {
        return outputVRAD;
    }
}
