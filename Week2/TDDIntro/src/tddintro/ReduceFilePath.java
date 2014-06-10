package tddintro;

import java.util.ArrayList;
import java.util.Collections;

public class ReduceFilePath {
    public static String reduceFilePath(String path) {
        ArrayList<String> reducedPath = new ArrayList<String>();
        ArrayList<String> originalPath = new ArrayList<String>();
        Collections.addAll(originalPath, path.split("/"));

        for (int i = 0; i < originalPath.size(); i++) {
            String subpath = originalPath.get(i);
            
            if (subpath.equals("") || subpath.equals(".")) {
                continue;
            }
            
            else if (subpath.equals("..") && reducedPath.size() >= 1) {
                reducedPath.remove(reducedPath.size() - 1);
            }
            
            else {
                reducedPath.add(subpath);
            }
        }
        
        if (reducedPath.size() == 0) {
            return "/";
        }
        String reduced = new String();
        for (String subpath: reducedPath) {
            reduced += "/" + subpath;
        }
        return reduced;
    }
}
