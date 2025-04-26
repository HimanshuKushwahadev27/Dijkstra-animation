
package dijkstra;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class dijkstra {
    public static void helperDijkstra(Node [][]grid,Node start,Node end,panelVisualizer anim){
        int rows=grid.length;
        int cols=grid[0].length;
        
        //All nodes intitalizing
        for(Node []row:grid){
            for(Node node:row){
                node.distance=Integer.MAX_VALUE;
                node.isVisited=false;
                node.parent=null;
            }
        }

        start.distance=0;
        
        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(n->n.distance));
        pq.add(start);
        
        
        while(!pq.isEmpty()){
            Node current=pq.poll();
            
            if (current==end)break;
            if(current.isVisited)continue;
            
            current.isVisited=true;
            
            for(Node ne:getNeighbours(current,grid)){
                if(ne.isWall||ne.isVisited)continue;
                
                int newDist=current.distance+1;
                if(newDist<ne.distance){
                    ne.distance=newDist;
                    ne.parent=current;
                    pq.add(ne);
                }
            }
               try {
                Thread.sleep(10); //  delay for animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            anim.repaint();
        }
        
        //repaint form end to start
        
        if(end.parent!=null){
            Node current=end;
            while(current!=start){
                current.isPath=true;
                  anim.repaint();
           try {
               Thread.sleep(30); //aniate ecah node 
               } catch (InterruptedException e) {
                 e.printStackTrace();
               }
                current=current.parent;
            }
        }
        anim.repaint();
    }
    
    private static ArrayList<Node> getNeighbours(Node node,Node[][]grid){
        ArrayList<Node> neighbors=new ArrayList<>();
        int row=node.row;
        int col=node.col;
        
        
        int rows = grid.length;
        int cols = grid[0].length;

        // Safely check 4-directional neighbors
        if (row + 1 < rows) neighbors.add(grid[row + 1][col]); // Down
        if (row - 1 >= 0)  neighbors.add(grid[row - 1][col]); // Up
        if (col + 1 < cols) neighbors.add(grid[row][col + 1]); // Right
        if (col - 1 >= 0)  neighbors.add(grid[row][col - 1]); // Left

        return neighbors;
    }
}
