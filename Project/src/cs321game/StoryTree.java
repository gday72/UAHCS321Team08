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
public class StoryTree {
    private StoryNode m_Root;
    
    public StoryTree(){
        
    }
    
    public StoryTree(StoryNode rt){
        m_Root = rt;
    }
    
    public void AddNode(StoryNode left, StoryNode right){
        StoryNode temp = m_Root;
        StoryNode back = null;
        if (temp == null)
        {
            m_Root = left;
            m_Root.m_Right = right;
        }
        else
        {
            while (temp != null)
            {
                back = temp;
                if (temp.GetScene().GetUID() > left.GetScene().GetUID())
                {
                    temp = temp.m_Left;
                }
                else
                {
                    temp = temp.m_Right;
                }
            }
            back.m_Left = left;
            back.m_Right = right;
        }
        
    }
    
    public void AddNode(StoryNode left){
        this.AddNode(left, null);
    }
    
    public void DeleteNode(int UID){
        StoryNode temp = m_Root;
        StoryNode back = null;
        while (temp != null && temp.GetScene().GetUID() != UID)
        {
            back = temp;
            if (temp.GetScene().GetUID() > UID)
            {
                temp = temp.m_Left;
            }
            else
            {
                temp = temp.m_Right;
            }
            if (temp != null)
            {
                if (back.m_Left == temp)
                {
                    back.m_Left = null;
                }
                else
                {
                    back.m_Right = null;
                }
            }
        }
    }
}
