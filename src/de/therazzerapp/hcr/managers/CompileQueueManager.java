package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.content.CompileSet;
import de.therazzerapp.hcr.content.loader.CompileQueueLoader;
import de.therazzerapp.hcr.content.saver.CompileQueueSaver;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompileQueueManager {
    private static ArrayList<CompileSet> compileQueue = new ArrayList<>();

    public static void load(){
        compileQueue = CompileQueueLoader.load();
    }

    public static void save(){
        CompileQueueSaver.save(compileQueue);
    }

    public static void addCompileToQueue(CompileSet compileSet){
        compileQueue.add(compileSet);
        save();
    }

    public static void removeCompileFromQueue(CompileSet compileSet){
        compileQueue.remove(compileSet);
        save();
    }

    public static ArrayList<CompileSet> getCompileQueue() {
        return compileQueue;
    }

    public static void runCompiles(){
        for (CompileSet compileSet : compileQueue) {
            //compileSet.run();
            try{
                removeCompileFromQueue(compileSet);
            } catch (ConcurrentModificationException e){

            }
        }
    }
}
