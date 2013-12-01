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
    private Story m_Story;
    private List<Chapter> m_Chapters;
    JPanel m_StoryBoard;
    /* 
     * The StoryTeller will build the XML files into a list
     * and initialize into the actual game 
    */
    public StoryTeller() {
        m_StoryBoard = new JPanel(new CardLayout());
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
        m_Story = new Story();
        m_Chapters = new ArrayList<>();
    }
}
