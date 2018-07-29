/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcs2101;

/**
 *
 * @author Ibtihal
 */
public class GameEntry {
    private String name;
    private int score;
    public GameEntry(){} // empty constructor
    public GameEntry(String name, int score)
    {
        this.name=name;
        this.score=score;
    }
    public String getName()
    {
        return name;
    }
    public int getScore()
    {
        return score;
    }
    public String toString()
    {
        return "Name: "+getName()+", Score: "+getScore();
    }
}
