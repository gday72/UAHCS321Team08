/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author yeyande
 */

/*
 * The Story class will:
 *      Provide a way to navigate through the story
 *      Provide story branching capabilities 
 */
public class Story implements Display {
    private List<Chapter> chapters;
    private List<JPanel> m_Story;
    
    public Story (){
        chapters = new ArrayList<>();
    }
    public Story (JPanel m_StoryBoard){
        if (m_Story == NULL)                // We need to see if we're 
            m_Story = new ArrayList<>();    // initializing for the first time
        m_Story.add(m_StoryBoard);          // Then add the new Story to the list
    }
    
    public void addChapter(Chapter c){
        chapters.add(c);
    }
    

    public List<Chapter> getChapters() {
        return chapters;
    }

}