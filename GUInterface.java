//
package projectcs2101;
import java.awt.Frame;
import java.awt.*;
import java.awt.BorderLayout.*;
import static java.awt.GridBagConstraints.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Ibtihal
 */
public class GUInterface extends Frame implements ActionListener{
    private final Label  mainLabel;
    private Label mainLabel1;
    private Panel Panel;
    private Label newLine;
    private Panel PanelMain2;
    private Frame JFrame1;
    private Panel JPanel1;
    private Label addingName;
    private Label addingScore;
    private Label removingAscore;
    private TextField NameText;
    private TextField ScoreText;
    private TextField removeText;
    private Button BackToMainMenu;
    private final Label welcomingLabel;
    private Button add;
    private Button remove;
    private Button removeFromG;
    private Button clearAll;
    private Button display;
    private Button exit;
    private Button addToG;
    private Frame JFrame2;
    private Panel JPanel2;
    ScoreBoard scoreb=new ScoreBoard();
     GameEntry game; 
    public GUInterface() //The primary constructor that which is called in the main
    {
        
        setLayout(new GridLayout());
        
        welcomingLabel=new Label("Welcome to your score board", Label.CENTER);
        newLine=new Label("\n");
        mainLabel=new Label("Choose an action", Label.CENTER);
//        mainLabel1=new Label("First time using the window?Please press the buttons in ");
        Panel=new Panel();
        Panel.setSize(200, 200);
        PanelMain2=new Panel();
        PanelMain2.setSize(200,200);
        Panel.add(welcomingLabel, BorderLayout.PAGE_START);
        Panel.add(newLine);
        Panel.add(mainLabel,BorderLayout.CENTER);
        add=new Button("Add a new score");
        remove=new Button("Remove a score");
        clearAll=new Button("Clear all scores");
        display=new Button("Display all scores");
        exit=new Button("Exit");
        BackToMainMenu=new Button("Back To Main Menue");
        addToG=new Button("Add");
        removeFromG=new Button("Remove");
        PanelMain2.add(add, BorderLayout.CENTER);
        PanelMain2.add(remove, BorderLayout.CENTER);
        PanelMain2.add(clearAll, BorderLayout.CENTER);
        PanelMain2.add(display, BorderLayout.CENTER);
        PanelMain2.add(exit, BorderLayout.AFTER_LINE_ENDS);
        add(Panel, BorderLayout.PAGE_START);
        add(PanelMain2, BorderLayout.CENTER);
        
        add.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent ae) {
                AddingScoreFrame();}});
        BackToMainMenu.addActionListener(new ActionListener()
        {@Override 
            public void actionPerformed(ActionEvent a) 
                {BackToMenu();}});
        addToG.addActionListener(new ActionListener()
        {@Override
            public void actionPerformed(ActionEvent a){
                scoreb.add(new GameEntry(NameText.getText(),Integer.parseInt(ScoreText.getText())));
                scoreb.SortByMin();}});
        display.addActionListener(new ActionListener()
        {@Override
            public void actionPerformed(ActionEvent e)
                {Displaying();}});
        remove.addActionListener(new ActionListener()
        { @Override
            public void actionPerformed(ActionEvent e)
            {
                RemoveAScore();
            }
        });
        Label unproperValue=new Label("Please enter a proper value");
        Label returnTheRemoved=new Label();
        removeFromG.addActionListener(new ActionListener()
        {@Override
            public void actionPerformed(ActionEvent e)
            {   Integer removedScore=Integer.parseInt(removeText.getText());
                    if(!(removedScore>scoreb.size()||removedScore<=0))
                    {
                        unproperValue.setText("");
                        JPanel2.add(unproperValue);
                        JFrame2.add(JPanel2);
                        GameEntry g1=scoreb.remove(removedScore);
                        returnTheRemoved.setText(g1.toString()+" --- Removed");
                        JPanel2.add(returnTheRemoved);
                        JFrame2.add(JPanel2);
                        JFrame2.setVisible(true);
                    }
                    else
                    {
                       unproperValue.setText("Please enter a proper value");
                       JPanel2.add(unproperValue);
                       JFrame2.add(JPanel2);
                       JFrame2.setVisible(true);
                    }   
                    
            }   
        });
        clearAll.addActionListener(new ActionListener()
        {@Override        
            public void actionPerformed(ActionEvent e)
            {
               clearAll(); 
            }
        });
        
        exit.addActionListener(new ActionListener ()
        {@Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        setTitle("Game Score Board");
        setSize(500,500);
        setVisible(true);
//        addWindowListener(this);
    }
    public void AddingScoreFrame() //the method of the adding a score frame
    {
        JFrame1=new JFrame("Adding a new Score");
        JFrame1.setSize(500,500);
        JPanel1=new Panel();
        addingName=new Label("Player Name");
        addingScore=new Label("Player Score");
        NameText=new TextField(20);
        ScoreText=new TextField(10);
        ScoreText.setSize(50, 50);
        JPanel1.add(addingName);
        JPanel1.add(NameText);
        JPanel1.add(addingScore);
        JPanel1.add(ScoreText);
        JPanel1.add(addToG);
        JPanel1.add(BackToMainMenu);
        JFrame1.add(JPanel1);
//        JFrame1.add(JPanel11);
        JFrame1.setVisible(true);
        setVisible(false);
    }
    private Panel JPanel4;
    private Frame JFrame4;
    //private Label scores;
    private Label noScores;
    public void Displaying() // The method for displaying frame
    {
        JPanel4=new Panel();
        JFrame4=new Frame("Display All Scores");
        Label scores=new Label();
        noScores=new Label("No scores available");
        scores.setSize(WIDTH, WIDTH);
        if(scoreb.isEmpty())
            JPanel4.add(noScores);
        else
            JPanel4.add(scores);
        scores.setText(scoreb.listScores());
        JPanel4.add(BackToMainMenu);
        JFrame4.add(JPanel4);
        JFrame4.setSize(500,500);
        JFrame4.setVisible(true);
        setVisible(false);
    }
    
    public void BackToMenu() //it should be in each frame
    {   //so weird method, It should be in order! how to make it aplicable to random?
    
        setVisible(true);
//        if(!JFrame1.equals(null)){
        if (JFrame1.isVisible()){
            JFrame1.setVisible(false);
         }
//        else
//            JFrame1.setVisible(false);
//        }       
       else if (JFrame4.isVisible()){
            JFrame4.setVisible(false);
        }
       else if(JFrame2.isVisible()){
        //(!JFrame2.equals(null)){ 
            
            JFrame2.setVisible(false);
             }
//        else
//            JFrame2.setVisible(false);
//        }
        
//        else
//            JFrame3.setVisible(false);
//        }
        
        else if (JFrame3.isVisible()){
                
                JFrame3.setVisible(false);
               }    
//                
//                JFrame4.setVisible(false);
//               }
//        else
//            JFrame4.setVisible(false);
        
    }
    
    public void RemoveAScore() //The method of the remove score frame
    {
        JFrame2=new Frame("Removing a score");
        JPanel2=new Panel();
        TextField emptyList=new TextField("List is empty");
        emptyList.setEditable(false);
        JFrame2.setSize(500,500);
        removeText=new TextField(20);
        removingAscore=new Label("Enter position of name and score:");
        if(scoreb.isEmpty())
        {
            JPanel2.add(emptyList);
            JPanel2.add(BackToMainMenu);
            JFrame2.add(JPanel2);
            JFrame2.setVisible(true);
            setVisible(false); 
        }
        else
        {
        JPanel2.add(removingAscore);
        JPanel2.add(removeText);
        JPanel2.add(removeFromG);
        JPanel2.add(BackToMainMenu);
        JFrame2.add(JPanel2);
        JFrame2.setVisible(true);
        setVisible(false); 
        }
    }
    private Frame JFrame3;
    private Panel JPanel3;
    private Label removedItems;
    public void clearAll() //The method for clear all scores frame
    {
        JFrame3=new JFrame("Clearing All Scores");
        JFrame3.setSize(500,500);
        JPanel3=new Panel();
        removedItems=new Label("All scores are removed");
        scoreb.removeAll();
        JPanel3.add(removedItems, BorderLayout.CENTER);
        JPanel3.add(BackToMainMenu);
        JFrame3.add(JPanel3);
        setVisible(false);
        JFrame3.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}

    