package de.therazzerapp.hcr.content;

import java.io.File;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class VRADSettings extends BuildProgramSettings{

    private boolean ldr;
    private boolean hdr;
    private boolean both;
    private boolean fast;
    private boolean finalCompile;
    private String lights;
    private boolean staticPropLighting;
    private boolean staticPropPolys;
    private boolean textureShadows;
    private Integer staticPropSampleScale;
    private Integer bounce;
    private Integer extraSky;
    private Integer smooth;
    private Float luxelDensity;
    private Float softSun;
    private boolean mpi;
    private String mpi_pw;
    private boolean noExtra;
    private Integer chop;
    private Integer maxChop;
    private boolean largeDispSampleRadius;
    private Integer compressconstant;
    private boolean rederrors;
    private boolean dump;
    private boolean dumpNormals;
    private boolean debugExtra;
    private boolean dlightmap;
    private boolean stopOnExit;
    private boolean noDetailLight;
    private boolean centerSamples;
    private boolean logHash;
    private boolean onlyDetail;
    private Integer maxDispSampleSize;
    private boolean fullMinidump;
    private boolean onlyStaticProps;
    private boolean staticPropNormals;
    private boolean noSkyBoxRecurse;
    private boolean noSProps;

    public VRADSettings(String game, Integer threads, boolean verbose, boolean low, boolean noVConfig, String vProject, boolean ldr, boolean hdr, boolean both, boolean fast, boolean finalCompile, String lights, boolean staticPropLighting, boolean staticPropPolys, boolean textureShadows, Integer staticPropSampleScale, Integer bounce, Integer extraSky, Integer smooth, Float luxelDensity, Float softSun, boolean mpi, String mpi_pw, boolean noExtra, Integer chop, Integer maxChop, boolean largeDispSampleRadius, Integer compressconstant, boolean rederrors, boolean dump, boolean dumpNormals, boolean debugExtra, boolean dlightmap, boolean stopOnExit, boolean noDetailLight, boolean centerSamples, boolean logHash, boolean onlyDetail, Integer maxDispSampleSize, boolean fullMinidump, boolean onlyStaticProps, boolean staticPropNormals, boolean noSkyBoxRecurse, boolean noSProps) {
        super(game, threads, verbose, low, noVConfig, vProject);
        this.ldr = ldr;
        this.hdr = hdr;
        this.both = both;
        this.fast = fast;
        this.finalCompile = finalCompile;
        this.lights = lights;
        this.staticPropLighting = staticPropLighting;
        this.staticPropPolys = staticPropPolys;
        this.textureShadows = textureShadows;
        this.staticPropSampleScale = staticPropSampleScale;
        this.bounce = bounce;
        this.extraSky = extraSky;
        this.smooth = smooth;
        this.luxelDensity = luxelDensity;
        this.softSun = softSun;
        this.mpi = mpi;
        this.mpi_pw = mpi_pw;
        this.noExtra = noExtra;
        this.chop = chop;
        this.maxChop = maxChop;
        this.largeDispSampleRadius = largeDispSampleRadius;
        this.compressconstant = compressconstant;
        this.rederrors = rederrors;
        this.dump = dump;
        this.dumpNormals = dumpNormals;
        this.debugExtra = debugExtra;
        this.dlightmap = dlightmap;
        this.stopOnExit = stopOnExit;
        this.noDetailLight = noDetailLight;
        this.centerSamples = centerSamples;
        this.logHash = logHash;
        this.onlyDetail = onlyDetail;
        this.maxDispSampleSize = maxDispSampleSize;
        this.fullMinidump = fullMinidump;
        this.onlyStaticProps = onlyStaticProps;
        this.staticPropNormals = staticPropNormals;
        this.noSkyBoxRecurse = noSkyBoxRecurse;
        this.noSProps = noSProps;
    }

    public boolean isLdr() {
        return ldr;
    }

    public boolean isHdr() {
        return hdr;
    }

    public boolean isBoth() {
        return both;
    }

    public boolean isFast() {
        return fast;
    }

    public boolean isFinalCompile() {
        return finalCompile;
    }

    public Integer getExtraSky() {
        return extraSky;
    }

    public String getLights() {
        return lights;
    }

    public Integer getBounce() {
        return bounce;
    }

    public Integer getSmooth() {
        return smooth;
    }

    public Float getLuxelDensity() {
        return luxelDensity;
    }

    public Float getSoftSun() {
        return softSun;
    }

    public boolean isStaticPropLighting() {
        return staticPropLighting;
    }

    public boolean isStaticPropPolys() {
        return staticPropPolys;
    }

    public boolean isTextureShadows() {
        return textureShadows;
    }

    public boolean isMpi() {
        return mpi;
    }

    public String getMpi_pw() {
        return mpi_pw;
    }

    public boolean isNoExtra() {
        return noExtra;
    }

    public Integer getChop() {
        return chop;
    }

    public Integer getMaxChop() {
        return maxChop;
    }

    public boolean isLargeDispSampleRadius() {
        return largeDispSampleRadius;
    }

    public Integer getCompressconstant() {
        return compressconstant;
    }

    public Integer getStaticPropSampleScale() {
        return staticPropSampleScale;
    }

    public boolean isRederrors() {
        return rederrors;
    }

    public boolean isDump() {
        return dump;
    }

    public boolean isDumpNormals() {
        return dumpNormals;
    }

    public boolean isDebugExtra() {
        return debugExtra;
    }

    public boolean isDlightmap() {
        return dlightmap;
    }

    public boolean isStopOnExit() {
        return stopOnExit;
    }

    public boolean isNoDetailLight() {
        return noDetailLight;
    }

    public boolean isCenterSamples() {
        return centerSamples;
    }

    public boolean isLogHash() {
        return logHash;
    }

    public boolean isOnlyDetail() {
        return onlyDetail;
    }

    public Integer getMaxDispSampleSize() {
        return maxDispSampleSize;
    }

    public boolean isFullMinidump() {
        return fullMinidump;
    }

    public boolean isOnlyStaticProps() {
        return onlyStaticProps;
    }

    public boolean isStaticPropNormals() {
        return staticPropNormals;
    }

    public boolean isNoSkyBoxRecurse() {
        return noSkyBoxRecurse;
    }

    public boolean isNoSProps() {
        return noSProps;
    }

    public String getParam(String gameDir){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(getGameDir(gameDir));
        if (ldr)
            stringBuilder.append("-ldr ");
        if (hdr)
            stringBuilder.append("-hdr ");
        if (both)
            stringBuilder.append("-both ");
        if (fast)
            stringBuilder.append("-fast ");
        if (finalCompile)
            stringBuilder.append("-final ");
        if (extraSky != null)
            stringBuilder.append("-extrasky " + extraSky + " ");
        if (lights != null)
            stringBuilder.append("-lights \"" + lights + "\" ");
        if (bounce != null)
            stringBuilder.append("-bounce " + bounce + " ");
        if (smooth != null)
            stringBuilder.append("-smooth " + smooth + " ");
        if (luxelDensity != null)
            stringBuilder.append("-luxeldensity " + luxelDensity + " ");
        if (softSun != null)
            stringBuilder.append("-softsun " + softSun + " ");
        if (staticPropLighting)
            stringBuilder.append("-StaticPropLighting ");
        if (staticPropPolys)
            stringBuilder.append("-StaticPropPolys ");
        if (textureShadows)
            stringBuilder.append("-TextureShadows ");
        if (low)
            stringBuilder.append("-low ");
        if (threads != null)
            stringBuilder.append("-threads " + threads + " ");
        if (mpi)
            stringBuilder.append("-mpi");
        if (mpi_pw != null)
            stringBuilder.append("-mpi_pw " + mpi_pw + " ");
        if (noExtra)
            stringBuilder.append("-noextra ");
        if (chop != null)
            stringBuilder.append("-chop " + chop + " ");
        if (maxChop != null)
            stringBuilder.append("-maxchop " + maxChop + " ");
        if (largeDispSampleRadius)
            stringBuilder.append("-LargeDispSampleRadius ");
        if (compressconstant != null)
            stringBuilder.append("-compressconstant " + compressconstant + " ");
        if (staticPropSampleScale != null)
            stringBuilder.append("-StaticPropSampleScale " + staticPropSampleScale + " ");
        if (rederrors)
            stringBuilder.append("-rederrors ");
        if (vProject != null)
            stringBuilder.append("-vproject " + vProject + " ");
        if (verbose)
            stringBuilder.append("-verbose ");
        if (noVConfig)
            stringBuilder.append("-novconfig ");
        if (dump)
            stringBuilder.append("-dump ");
        if (dumpNormals)
            stringBuilder.append("-dumpnormals ");
        if (debugExtra)
            stringBuilder.append("-debugextra ");
        if (dlightmap)
            stringBuilder.append("-dlightmap ");
        if (stopOnExit)
            stringBuilder.append("-stoponexit ");
        if (noDetailLight)
            stringBuilder.append("-nodetaillight ");
        if (centerSamples)
            stringBuilder.append("-centersamples ");
        if (logHash)
            stringBuilder.append("-loghash ");
        if (onlyDetail)
            stringBuilder.append("-onlydetail");
        if (maxDispSampleSize != null)
            stringBuilder.append("-maxdispsamplesize " + maxDispSampleSize + " ");
        if (fullMinidump)
            stringBuilder.append("-FullMinidump ");
        if (onlyStaticProps)
            stringBuilder.append("-OnlyStaticProps ");
        if (staticPropNormals)
            stringBuilder.append("-StaticPropNormals ");
        if (noSkyBoxRecurse)
            stringBuilder.append("-noskyboxrecurse ");
        if (noSProps)
            stringBuilder.append("-nossprops ");

        return stringBuilder.toString();
    }

    @Override
    public String getFileType() {
        return ".bsp";
    }
}
