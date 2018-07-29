/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcs2101;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Ibtihal
 */
public class ProjectCS2101 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws Exception{
        GUInterface g= new GUInterface();
        
   Scanner userinput=new Scanner(System.in);
       
   int choice=0;
   GameEntry game;
   ScoreBoard  scoreb=new ScoreBoard();
   String name;
   int score;
 
     System.out.println("\nPlease enter:\n1.Add a new game score.\n2. Remove a game score\n3. Clear the scoreboard\n4.print Scoreboard \n5.Exit");

 
       
   do{

          
         while(!userinput.hasNextInt()){
         
   System.out.println("Error!! Please enter correct input");
       
        userinput=new Scanner(System.in);

        System.out.println("\nPlease enter:\n1.Add a new game score.\n2.Remove a game score\n3.Clear the scoreboard\n4.print Scoreboard \n5.Exit");

   
     } 
           choice=userinput.nextInt(); 
      
   
     switch (choice){
         
         case 1:
             String answer="";
             do{
                
             System.out.println("Enter name and score:");
             
       
           name=userinput.next();
         
             if(!userinput.hasNextInt()){
                 System.out.println("Sorry wrong entry");
                   userinput=new Scanner(System.in);

 
             }
             else
             {
            score=userinput.nextInt(); 
           
            game= new GameEntry(name,score);
           
            scoreb.add(game);
            
            scoreb.SortByMin();} 
            System.out.println("Want to add more? Y for yes and N for No");
            answer=userinput.next();
            
     }
     while(answer.equalsIgnoreCase("y"));
     
           break;
             
         case 2:
           
             System.out.println("Enter position of name and score:");
         if(!userinput.hasNextInt()){
                System.out.println("please enter an integer value");
                                    userinput=new Scanner(System.in);

           } 
//             
       
         else {
             
             int position=userinput.nextInt(); 
           /**  if(scoreb.remove(position)==null)
                 System.out.println("No scores available");
             else*/
                if(!(position>scoreb.size()||position<=0)){
                 
                 System.out.print(scoreb.remove(position)+" -- Removed");}
           else{
                 System.out.println("please enter proper value");
                 userinput=new Scanner(System.in);

         }}
             break;
         case 3:
             scoreb.removeAll();
             break;
             
         case 4:
  
             System.out.println(scoreb.listScores());
             break;
        
         default:
             if(choice==5)
                 System.exit(0);
             else
             { System.out.println("Please enter a number within the specified options");
             break;}
             

   }


         System.out.println("\nPlease enter:\n1.Add a new game score.\n2. Remove a game score\n3. Clear the scoreboard\n4.print Scoreboard \n5.Exit");

       
  }while(choice!=5); 
  
   
 
   
   
   
   
    
    
}


}