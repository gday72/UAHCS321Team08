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
public class Scene implements Display {

    private String name, content;
    private JPanel m_ScenePanel;

    public Scene(String n, String c) {
        name = n;
        content = c;
    }

    public Scene() {
        this("none", "empty");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    public JPanel getPanel() {
        return m_ScenePanel;
    }
}
