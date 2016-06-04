package de.therazzerapp.hcr.gui;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public interface ContentUpdater {

    /**
     *
     * @param contentID
     *          <br>-1 - All
     *          <br> 0 - BuildSettings
     *          <br> 1 - BuildProgram
     *          <br> 2 - Config
     *          <br> 3 - LogPattern
     */
    void updateContent(int contentID);
}
