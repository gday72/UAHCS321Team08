/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs321game;

/**
 *
 * @author Kris Jordan
 */
public class Item 
{
     private String m_sItemName;
     
     public Item() {
         m_sItemName = "none";
     }
     
     public Item(String Name) {
         m_sItemName = Name;
     }
     
     public String GetItem(){
         return m_sItemName;
     }
}
