/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import javax.swing.JPanel;

/**
 *
 * @author yeyande
 */
public class Scene {

    private String m_Text;
    private int m_UID;  
    private JPanel m_ScenePanel;

    public Scene(JPanel ScenePanel, String Text, int UID) {
        m_ScenePanel = ScenePanel;
        m_Text = Text;
        m_UID = UID;
    }

    public Scene() {
        this(null, "empty", 0);
    }

    /**
     * @return the name
     */
    public String getText() {
        return m_Text;
    }
    
    public JPanel getPanel() {
        return m_ScenePanel;
    }
}
