package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;
import java.util.Arrays;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
    // show folder name
    vistor.visit(rootDirectory);

    if(rootDirectory.length() != 0){
      File[] filesDir = rootDirectory.listFiles();
      Arrays.sort(filesDir);
      for(File f : filesDir){
        if(f.isDirectory()) {
          // explored sub-folder
          explore(f, vistor);
        }
      }
      for(File f : filesDir){
        if(f.isFile()){
          // show files name
          vistor.visit(f);
        }
      }
    }
  }

}
