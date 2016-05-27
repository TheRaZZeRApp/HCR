package de.therazzerapp.hcr.content;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class VBSPSettings extends BuildProgramSettings{
    private boolean onlyEnts;
    private boolean onlyProps;
    private boolean glview;
    private boolean noDetail;
    private boolean noWater;
    private String embed;
    private boolean verboseEntities;
    private boolean noWeld;
    private boolean noCSG;
    private boolean noShare;
    private boolean noJunc;
    private boolean noOpt;
    private boolean noPrune;
    private boolean noMerge;
    private boolean noMergeWater;
    private boolean noSubDiv;
    private Double micro;
    private boolean fullDetail;
    private boolean leakTest;
    private boolean bumpAll;
    private boolean snapaxial;
    private Double block1;
    private Double block2;
    private Double blocks1;
    private Double blocks2;
    private Double blocks3;
    private Double blocks4;
    private boolean dumpStaticProps;
    private boolean dumpCollide;
    private Double luxelscale;
    private boolean lightIfMissing;
    private boolean localphysx;
    private boolean keepStaleZip;
    private boolean replacematerials;
    private boolean fullMindumps;

    public VBSPSettings(String game, Integer threads, boolean verbose, boolean low, boolean noVConfig, String vProject, boolean onlyEnts, boolean onlyProps, boolean glview, boolean noDetail, boolean noWater, String embed, boolean verboseEntities, boolean noWeld, boolean noCSG, boolean noShare, boolean noJunc, boolean noOpt, boolean noPrune, boolean noMerge, boolean noMergeWater, boolean noSubDiv, Double micro, boolean fullDetail, boolean leakTest, boolean bumpAll, boolean snapaxial, Double block1, Double block2, Double blocks1, Double blocks2, Double blocks3, Double blocks4, boolean dumpStaticProps, boolean dumpCollide, Double luxelscale, boolean lightIfMissing, boolean localphysx, boolean keepStaleZip, boolean replacematerials, boolean fullMindumps) {
        super(game, threads, verbose, low, noVConfig, vProject);
        this.onlyEnts = onlyEnts;
        this.onlyProps = onlyProps;
        this.glview = glview;
        this.noDetail = noDetail;
        this.noWater = noWater;
        this.embed = embed;
        this.verboseEntities = verboseEntities;
        this.noWeld = noWeld;
        this.noCSG = noCSG;
        this.noShare = noShare;
        this.noJunc = noJunc;
        this.noOpt = noOpt;
        this.noPrune = noPrune;
        this.noMerge = noMerge;
        this.noMergeWater = noMergeWater;
        this.noSubDiv = noSubDiv;
        this.micro = micro;
        this.fullDetail = fullDetail;
        this.leakTest = leakTest;
        this.bumpAll = bumpAll;
        this.snapaxial = snapaxial;
        this.block1 = block1;
        this.block2 = block2;
        this.blocks1 = blocks1;
        this.blocks2 = blocks2;
        this.blocks3 = blocks3;
        this.blocks4 = blocks4;
        this.dumpStaticProps = dumpStaticProps;
        this.dumpCollide = dumpCollide;
        this.luxelscale = luxelscale;
        this.lightIfMissing = lightIfMissing;
        this.localphysx = localphysx;
        this.keepStaleZip = keepStaleZip;
        this.replacematerials = replacematerials;
        this.fullMindumps = fullMindumps;
    }

    public boolean isOnlyEnts() {
        return onlyEnts;
    }

    public boolean isOnlyProps() {
        return onlyProps;
    }

    public boolean isGlview() {
        return glview;
    }

    public boolean isNoDetail() {
        return noDetail;
    }

    public boolean isNoWater() {
        return noWater;
    }

    public String getEmbed() {
        return embed;
    }

    public boolean isVerboseEntities() {
        return verboseEntities;
    }

    public boolean isNoWeld() {
        return noWeld;
    }

    public boolean isNoCSG() {
        return noCSG;
    }

    public boolean isNoShare() {
        return noShare;
    }

    public boolean isNoJunc() {
        return noJunc;
    }

    public boolean isNoOpt() {
        return noOpt;
    }

    public boolean isNoPrune() {
        return noPrune;
    }

    public boolean isNoMerge() {
        return noMerge;
    }

    public boolean isNoMergeWater() {
        return noMergeWater;
    }

    public boolean isNoSubDiv() {
        return noSubDiv;
    }

    public Double getMicro() {
        return micro;
    }

    public boolean isFullDetail() {
        return fullDetail;
    }

    public boolean isLeakTest() {
        return leakTest;
    }

    public boolean isBumpAll() {
        return bumpAll;
    }

    public boolean isSnapaxial() {
        return snapaxial;
    }

    public Double getBlock1() {
        return block1;
    }

    public Double getBlock2() {
        return block2;
    }

    public Double getBlocks1() {
        return blocks1;
    }

    public Double getBlocks2() {
        return blocks2;
    }

    public Double getBlocks3() {
        return blocks3;
    }

    public Double getBlocks4() {
        return blocks4;
    }

    public boolean isDumpStaticProps() {
        return dumpStaticProps;
    }

    public boolean isDumpCollide() {
        return dumpCollide;
    }

    public Double getLuxelscale() {
        return luxelscale;
    }

    public boolean isLightIfMissing() {
        return lightIfMissing;
    }

    public boolean isLocalphysx() {
        return localphysx;
    }

    public boolean isKeepStaleZip() {
        return keepStaleZip;
    }

    public boolean isReplacematerials() {
        return replacematerials;
    }

    public boolean isFullMindumps() {
        return fullMindumps;
    }

    public String getParam(String gameDir){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(getGameDir(gameDir));
        if (vProject != null)
            stringBuilder.append("-vproject " + vProject + " ");
        if (verbose)
            stringBuilder.append("-verbose ");
        if (onlyEnts)
            stringBuilder.append("-onlyents ");
        if (onlyProps)
            stringBuilder.append("-onlyprops ");
        if (glview)
            stringBuilder.append("-glview ");
        if (noDetail)
            stringBuilder.append("-nodetail ");
        if (noWater)
            stringBuilder.append("-nowater ");
        if (low)
            stringBuilder.append("-low ");
        if (embed != null)
            stringBuilder.append("-embed " + embed + " ");
        if (noVConfig)
            stringBuilder.append("-novconfig ");
        if (threads != null)
            stringBuilder.append("-threads " + threads + " ");
        if (verboseEntities)
            stringBuilder.append("-verboseentities ");
        if (noWeld)
            stringBuilder.append("-noweld ");
        if (noCSG)
            stringBuilder.append("-nocsg ");
        if (noShare)
            stringBuilder.append("-noshare ");
        if (noJunc)
            stringBuilder.append("-notjunc ");
        if (noOpt)
            stringBuilder.append("-noopt ");
        if (noPrune)
            stringBuilder.append("-noprune ");
        if (noMerge)
            stringBuilder.append("-nomerge ");
        if (noMergeWater)
            stringBuilder.append("-nomergewater ");
        if (noSubDiv)
            stringBuilder.append("-nosubdiv ");
        if (micro != null)
            stringBuilder.append("-micro " + micro + " ");
        if (fullDetail)
            stringBuilder.append("-fulldetail ");
        if (leakTest)
            stringBuilder.append("-leaktest ");
        if (bumpAll)
            stringBuilder.append("-bumpall ");
        if (snapaxial)
            stringBuilder.append("-snapaxial ");
        if (block1 != null && block2 != null)
            stringBuilder.append("-block " + block1 + " " + block2 + " ");
        if (blocks1 != null && blocks2 != null && blocks3 != null && blocks4 != null)
            stringBuilder.append("-blocks " + blocks1 + " " + blocks2 + " " + blocks3 + " " + blocks4 + " ");
        if (dumpStaticProps)
            stringBuilder.append("-dumpstaticprops ");
        if (dumpCollide)
            stringBuilder.append("-dumpcollide ");
        if (luxelscale != null)
            stringBuilder.append("-luxelscale " + luxelscale + " ");
        if (lightIfMissing)
            stringBuilder.append("-lightifmissing ");
        if (localphysx)
            stringBuilder.append("-localphysx ");
        if (keepStaleZip)
            stringBuilder.append("-keepstalezip ");
        if (replacematerials)
            stringBuilder.append("-replacematerials ");
        if (fullMindumps)
            stringBuilder.append("-FullMinidumps");

        return stringBuilder.toString();
    }

    @Override
    public String getFileType() {
        return ".vmf";
    }
}
