/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

/**
 *
 * @author yeyande
 */
public class StoryNode {
    public StoryNode m_Right;
    public StoryNode m_Left;
    private Scene m_Node;
    
    public StoryNode(){
        
    }
    
    public StoryNode(Scene Node){
        m_Node = Node;
    }
    
    public Scene GetScene(){
        return m_Node;
    }
}
