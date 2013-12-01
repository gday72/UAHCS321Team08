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
    private List<Integer> m_UID;
    private int m_Branching;
    
    public Story (){
        chapters = new ArrayList<>();
    }
    public Story (JPanel storyBoard, int hash){
        if (m_Story == null)                // We need to see if we're 
            m_Story = new ArrayList<>();    // initializing for the first time
        this.AddBranch(storyBoard, hash);
    }
    
    public void AddBranch(JPanel storyBoard, int hash){
        m_Story.add(storyBoard);          // Then add the new Story to the list
        m_UID.add(hash);
    }
    
    public void BeginStory(){
        // This will start the story with the unbranched story
        m_Branching = m_UID.get(0);
    }
    
    public void BeginStory(int ID){
        // This will load up the story with the initial 
        m_Branching = ID;
    }
    
    public void Branch (int ID){
        // When m_Branching is changed, this method should be called to swap to a different story in the list
        for (int i = 0; i < m_UID.size(); i++)
        {
            if (m_UID.get(i) == ID)
            {
                m_Branching = ID;
                this.BeginStory(i);
                break;                
            }
        }
        
    }
    
    public List<Chapter> getChapters() {
        return chapters;
    }

}