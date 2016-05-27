package de.therazzerapp.hcr.gui;

import de.therazzerapp.hcr.CompilerLog;
import de.therazzerapp.hcr.HCR;

import java.util.List;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompilerLogSyncThread extends Thread {

    private final CompilerLog log;

    public CompilerLogSyncThread(CompilerLog log) {
        this.log = log;
    }

    @Override
    public void run() {

        List<Character> newLogs;

        while ((newLogs = log.getLastChars()) != null){
            StringBuilder builder = new StringBuilder();
            for (char c : newLogs){
                builder.append(c);
            }
            HCR.hcr_gui.getCompileOutputArea().append(builder.toString());
        }

    }
}
