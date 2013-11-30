/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yeyande
 */
public class Chapter implements Display {

    List<Scene> scenes;

    public Chapter() {
        scenes = new ArrayList<>();
    }

    public void addScene(Scene s) {
        scenes.add(s);
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void buildChapterFromFiles() {
        //This will be a problem!!!
        File folder = new File(System.getProperty("user.dir") + "/scenes/");
        File[] listOfFiles = folder.listFiles();
        String sceneName, sceneContent;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //If you remove the extension, develop systematic
                // naming and buils a 'name' parser, would this be an aid
                // in building multiple chapters?
                sceneName = removeExtension(listOfFiles[i].getName());
                sceneContent = readFileToString(listOfFiles[i]);
                addScene(new Scene(sceneName, sceneContent));
            }
        }
    }

    private String removeExtension(final String s) {

        String separator = System.getProperty("file.separator");
        String filename;

        // Remove the path upto the filename.
        int lastSeparatorIndex = s.lastIndexOf(separator);
        if (lastSeparatorIndex == -1) {
            filename = s;
        } else {
            filename = s.substring(lastSeparatorIndex + 1);
        }

        // Remove the extension.
        int extensionIndex = filename.lastIndexOf(".");
        if (extensionIndex == -1) {
            return filename;
        }
        return filename.substring(0, extensionIndex);
    }

    private String readFileToString(final File infile) {
        boolean isReadable = false;
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(infile));
            String str;
            while ((str = in.readLine()) != null) {
                if (isReadable) {
                    sb.append(str);
                    sb.append("\n");
                } else {
                    sb.append(str);
                }

            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in == null) {
            } else {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("IO error when closing");
                }
            }
        }
        return sb.toString();
    }
}
