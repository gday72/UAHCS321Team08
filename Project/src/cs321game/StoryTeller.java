/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs321game;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author yeyande
 */
public class StoryTeller {
  public StoryTeller(){
      
  }  
  private void ParseXML(File Story){
      try {
          // This will parse an XML file and build a StoryTree out of it!
          DocumentBuilderFactory DocFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder DocBuilder = DocFactory.newDocumentBuilder();
          Document Doc = DocBuilder.parse(Story);
          Doc.getDocumentElement().normalize();
          NodeList SceneList = Doc.getElementsByTagName("Scene");
          
          for (int temp = 0; temp < SceneList.getLength(); temp++)
          {
              Node SceneNode = SceneList.item(temp);
              if (SceneNode.getNodeType() == Node.ELEMENT_NODE) 
              {
                  Element Scene = (Element) SceneNode;
                  int Scene_UID = Integer.parseInt(Scene.getAttribute("id"));
                  int Branch = Integer.parseInt(Scene.getAttribute("branchpoint"));
                  String Background = Scene.getElementsByTagName("Background").item(0).getTextContent();
                  NodeList ButtonList = Scene.getElementsByTagName("Button");
                  String Text = Scene.getElementsByTagName("Text").item(0).getTextContent();
                  
                  for (int i = 0; i < ButtonList.getLength(); i++)
                  {
                      Node ButtonNode = ButtonList.item(i);
                      if (ButtonNode.getNodeType() == Node.ELEMENT_NODE)
                      {
                          Element Button = (Element) ButtonList;
                          int Button_UID = Integer.parseInt(Button.getAttribute("id"));
                          int Button_XPos = Integer.parseInt(Button.getElementsByTagName("XPos").item(0).getTextContent());
                          int Button_YPos = Integer.parseInt(Button.getElementsByTagName("YPos").item(0).getTextContent());
                          int Button_Width = Integer.parseInt(Button.getElementsByTagName("Width").item(0).getTextContent());
                          int Button_Height = Integer.parseInt(Button.getElementsByTagName("Height").item(0).getTextContent());
                          Button.getElementsByTagName("Action").item(0).getTextContent();
                      }
                      
                  }
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      
      
  }
  public void Storybuild(StoryTree Story){
      // This will take a StoryTree and build
  }
  public void BeginStory(){
      // This will initialize the main JPanel Story
  }
  public void StopStory(){
      // This will Stop and Save the story
  }
  public void BranchStory(){
      // This wil rebuild the Scene cards and reload them into the JPanel
  }
  
}
/*public class StoryTeller {
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
/*    public StoryTeller() {
        this.ParseXML();                                                        // This parses the XML file into a list of a story
        // Parse the tree that is loaded from the XML file
        
        /*for (Story Story : m_StoryBranches)
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
                    m_Scenes.add(Scene.GetPanel());    // Add the panels to the scenes panel
               }
           }*/
            /* 
            *  StoryBoard -> Items
            *             -> Text
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
            /*m_StoryBoard.add(m_Attributes);                                     // Add the Avatar Attributes
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
}*/
