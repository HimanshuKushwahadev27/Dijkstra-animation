
package dijkstra;

import java.awt.Color;
import java.awt.Graphics;


public class Node {
    public int row,col;
    public Node parent=null;  // too keep track of the node from the back in dijkstra 
    public boolean isWall=false; //return true if the path is not walkable 
    public boolean isPath=false; //return true if the path is walkable
    public boolean isVisited=false; //marked during dijkstra
    public int distance=Integer.MIN_VALUE; 
    
    public static final int SIZE=20;

    
    public Node(int row,int col){
        this.row=row;
        this.col=col;
    }
    
    public Color getColor(){
        if(isWall)return Color.BLACK;
        if(isPath) return Color.YELLOW;
        if(isVisited) return Color.CYAN;
         return Color.WHITE;
    }
     public void draw(Graphics g) {
        g.setColor(getColor()); //get color defines for the specific node;
       // g.fillRect(col * SIZE, row * SIZE, SIZE, SIZE); //fill the node the with the specific color
       g.fillRoundRect(col*SIZE, row*SIZE, SIZE, SIZE, SIZE, SIZE);
        //outline color to gray better visualization
        g.setColor(Color.BLACK);
        //draw border to keep the rows and cols distinct
        //g.drawRect(col * SIZE, row * SIZE, SIZE, SIZE);
        g.drawRoundRect(col*SIZE, row*SIZE, SIZE, SIZE, SIZE, SIZE);
    }
    
    @Override
    public String toString(){
        return String.format("Node(%d%d)", row,col);
    }
}

