package de.therazzerapp.hcr.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class VMFFileFilter extends FileFilter{
    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".vmf");
    }

    @Override
    public String getDescription() {
        return "Valve Map File";
    }
}
