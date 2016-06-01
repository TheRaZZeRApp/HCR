package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.filter.ExeFileFilter;
import de.therazzerapp.hcr.filter.RadFileFilter;
import de.therazzerapp.hcr.filter.VMFFileFilter;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class FileFilterManager {
    private static ExeFileFilter exeFileFilter = new ExeFileFilter();
    private static RadFileFilter radFileFilter = new RadFileFilter();
    private static VMFFileFilter vmfFileFilter = new VMFFileFilter();

    public static ExeFileFilter getExeFileFilter() {
        return exeFileFilter;
    }

    public static RadFileFilter getRadFileFilter() {
        return radFileFilter;
    }

    public static VMFFileFilter getVmfFileFilter() {
        return vmfFileFilter;
    }
}
