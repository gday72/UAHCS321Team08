/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yeyande
 */
public class Story implements Display {
    private List<Chapter> chapters;
    
    public Story (){
        chapters = new ArrayList<>();
    }
    
    public void addChapter(Chapter c){
        chapters.add(c);
    }
    

    public List<Chapter> getChapters() {
        return chapters;
    }

}