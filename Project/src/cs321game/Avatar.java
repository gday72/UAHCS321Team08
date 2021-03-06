/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author yeyande
 */
public class Avatar 
{
     /* 
     * Basic attributes for every avatar in the game.
     */
   
    private ArrayList<Item> m_Inventory;

    public Avatar() 
    {
        m_Inventory = new ArrayList<>();
    }
    
   /* public void Move()
    {
        System.out.println("You just moved your character!");
    }*/
    
     public void PickUpItem(Item i)
    {
        m_Inventory.add(i);
        int index = m_Inventory.indexOf(i);
        System.out.println("You just picked up a " + inventory.get(index).GetItem() +"!");
        System.out.println("You have " + inventory.size() + " items in your inventory!");
    }
    
    /**
     *  Takes an Item as input and takes the Item out of the players inventory.
     *  If the Item is not in the players inventory, they can not remove it.
     * @param i 
     */
    public void UseItem(Item i)
    {
        if(inventory.contains(i))
        {
            inventory.remove(i);
            System.out.println("You just dropped a " + i.GetItem() + "!");
            System.out.println("You have " + inventory.size() + " items in your inventory!");
        }
        else
        {
            System.out.println("You do not have " + i.GetItem() + " in your inventory!");
        }
    }
    
    /**
     * This will display all of the items that are in the players inventory.
     */
    public void DisplayItems()
    {
        Iterator<Item> iter = inventory.iterator();
        
        while(iter.hasNext() == true)
        {
            System.out.println(iter.next().GetItem());
        }
    }   
}
