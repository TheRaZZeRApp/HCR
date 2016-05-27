package de.therazzerapp.hcr.content;


/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class VVISSettings extends BuildProgramSettings{

    private boolean fast;
    private Integer radius_override;
    private boolean noSort;
    private boolean tmpin;
    private boolean tmpout;
    private boolean mpi;
    private String mpi_pw;

    public VVISSettings(String game, Integer threads, boolean verbose, boolean low, boolean noVConfig, String vProject, boolean fast, Integer radius_override, boolean noSort, boolean tmpin, boolean tmpout, boolean mpi, String mpi_pw) {
        super(game, threads, verbose, low, noVConfig, vProject);
        this.fast = fast;
        this.radius_override = radius_override;
        this.noSort = noSort;
        this.tmpin = tmpin;
        this.tmpout = tmpout;
        this.mpi = mpi;
        this.mpi_pw = mpi_pw;
    }

    public boolean isFast() {
        return fast;
    }

    public Integer getRadius_override() {
        return radius_override;
    }

    public boolean isNoSort() {
        return noSort;
    }

    public boolean isTmpin() {
        return tmpin;
    }

    public boolean isTmpout() {
        return tmpout;
    }

    public boolean isMpi() {
        return mpi;
    }

    public String getMpi_pw() {
        return mpi_pw;
    }

    @Override
    public String getParam(String gameDir){
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(getGameDir(gameDir));
        if (fast)
            stringBuilder.append("-fast ");
        if (radius_override != null)
            stringBuilder.append("-radius_override " + radius_override + " ");
        if (noSort)
            stringBuilder.append("-nosort ");
        if (tmpin)
            stringBuilder.append("-tmpin ");
        if(tmpout)
            stringBuilder.append("-tmpout ");
        if (low)
            stringBuilder.append("-low ");
        if (threads != null && !(threads <= 0))
            stringBuilder.append("-threads " + threads + " ");
        if(verbose)
            stringBuilder.append("-verbose ");
        if(noVConfig)
            stringBuilder.append("-novconfig ");
        if (mpi)
            stringBuilder.append("-mpi ");
        if (mpi_pw != null && !mpi_pw.isEmpty())
            stringBuilder.append("-mpi_pw " + mpi_pw + " ");
        if (vProject != null && !vProject.isEmpty())
            stringBuilder.append("-vproject " + vProject + " ");
        return stringBuilder.toString();
    }

    @Override
    public String getFileType() {
        return ".bsp";
    }
}
