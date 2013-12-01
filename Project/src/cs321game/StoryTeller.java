/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
/**
 *
 * @author yeyande
 */
public class StoryTeller {
    private List<Story> m_StoryBranches;                                        // Here's our story possibilites
    private List<Chapter> m_ChaptersList;                                       // A list of chapters for building
    private List<Scene> m_ScenesList;                                           // A list of scenes for building
    private Story m_Story;
    // ^ This should be a List<List<Scene>> to build all possibilites
    private int m_ChapterCount,m_SceneCount, m_StoryBranchNumber, m_MaxBranches, m_Hash;// Counters
    JPanel m_StoryBoard, m_Attributes, m_Items, m_Scenes;                       // The panels that comprise the display
    /* 
     * The StoryTeller will build the XML files into a list
     * and initialize into the actual game 
    */
    public StoryTeller() {
        this.ParseXML();                                                        // This parses the XML file into a list of a story
        //for (m_StoryBranchNumber = 0; m_StoryBranchNumber < m_MaxBranches; m_StoryBranchNumber++)
        for (Story Story : m_StoryBranches)
        {
            m_StoryBoard = new JPanel(new CardLayout());                        // Init the main card layout
            m_Scenes = new JPanel(new CardLayout());                            // Init the secondary card layout
            //m_ChaptersList = m_StoryBranches.get(m_StoryBranchNumber).getChapters();    // This will move the chapters from our story into our variables to deal with them
            m_ChaptersList = Story.getChapters();
            m_Hash = m_ChaptersList.hashCode();
            //for (m_ChapterCount = 0; m_ChapterCount < m_ChaptersList.size(); m_ChapterCount++)  // Iterate through the list
            for (Chapter Chapter : m_ChaptersList)
            {
                //m_ScenesList = m_ChaptersList.get(m_ChapterCount).getScenes();  // This will copy the scenes from each chapter
                m_ScenesList = Chapter.getScenes();
                //for (m_SceneCount = 0; m_SceneCount < m_ScenesList.size(); m_SceneCount++)  // Iterate through the list
                for (Scene Scene: m_ScenesList)
                {   
                    m_Scenes.add(Scene.getPanel());    // Add the panels to the scenes panel
                }
            }
            /* 
            *  StoryBoard -> Avatar
            *             -> Items
            *             -> Scenes -> Individual Scenes
            * So,
            * m_Scenes = new JPanel(new CardLayout());
            * for each scene,
            * m_Scenes.add(scene, SOMETHING);
            * m_StoryBoard = new JPanel(new CardLayout());
            * m_StoryBoard.add(Avatar, AVATARPANEL);
            * m_StoryBoard.add(Items, ITEMPANEL);
            * m_StoryBoard.add(m_Scenes, DISPLAYPANEL);
            */
            m_StoryBoard.add(m_Attributes);                                     // Add the Avatar Attributes
            m_StoryBoard.add(m_Items);                                          // Add the Avatar Items
            m_StoryBoard.add(m_Scenes);                                         // Add the Scenes for the Story 
            if (m_Story == null)
                m_Story = new Story(m_StoryBoard, m_Hash);
            else
                m_Story.AddBranch(m_StoryBoard, m_Hash);
        }
    }
    private void ParseXML() {
        
    }
}
