package de.therazzerapp.hcr.gui;

import java.util.HashSet;
import java.util.Set;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class ContentObserver {
    private static Set<ContentUpdater> contentUpdaterSet = new HashSet<>();

    public static void addContentUser(ContentUpdater contentUpdater){
        contentUpdaterSet.add(contentUpdater);
    }

    public static void removeContentUser(ContentUpdater contentUpdater){
        contentUpdaterSet.remove(contentUpdater);
    }

    public static void update(){
        for (ContentUpdater contentUpdater : contentUpdaterSet) {
            contentUpdater.updateContent();
        }
    }
}
