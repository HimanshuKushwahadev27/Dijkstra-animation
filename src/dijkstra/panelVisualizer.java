
package dijkstra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;


public class panelVisualizer extends javax.swing.JPanel {

    
    private final int  rows;
    private final int cols;
    private final Node[][] grid;
    private Node startNode, endNode;
    
    public panelVisualizer() {
        this.rows=20;
        this.cols=50;
        this.grid=new Node[rows][cols];
        initComponents();
        init(); 
        setPreferredSize(new Dimension(cols*Node.SIZE,rows*Node.SIZE));
        addMouseListener(new MouseAdapter(){
        
         @Override
         public void mousePressed(MouseEvent e){
             //it takes the x point of the clicked point divide it by the pisxel of that node to get the col number
            handleMouse(e);
         }
        });
        
                addMouseMotionListener(new MouseAdapter(){
        
         @Override
         public void mouseDragged(MouseEvent e){
             //it takes the x point of the clicked point divide it by the pisxel of that node to get the col number
            handleMouse(e);
         }
        });
    }
   // making the grids (nodes)
    private void init(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]=new Node(i,j);
                
            }
        }
       
    }
    
    private void handleMouse(MouseEvent e){
           int col=e.getX()/Node.SIZE;
             //it takes the y point of the clivked point divide it by the pixel of that node to get the row number
             int row=e.getY()/Node.SIZE;
             //checking wether the clicked place is valid or not
             if(row<0||row>=rows||col<0||col>=cols)return;
             //intializing clicked to keep track of the clicked node which will hwlp in build walls or making start or end point
             Node clicked=grid[row][col];
             
             if(SwingUtilities.isLeftMouseButton(e)){
                 if(clicked!=startNode && clicked!=endNode){
                     //making walls 
                     clicked.isWall =true;
                 }
             }
             //making start and end;
             if(SwingUtilities.isRightMouseButton(e)){
                if(startNode==null && clicked!=endNode){
                    startNode=clicked;
                }else if(endNode==null&&clicked!=startNode){
                    endNode=clicked;
                }else{
                    startNode=clicked;
                    endNode=null;
                }
             }
             repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Node node=grid[i][j];
                node.draw(g);
            }
        }
        Graphics2D g2=(Graphics2D)g;
        //colouring starnode and endnode
        if(startNode!=null){
            GradientPaint gra1=new GradientPaint(0,0,new Color(186, 8, 138),0,getHeight(),new Color(243, 150, 218));
           // g.fillRect(startNode.col*Node.SIZE, startNode.row*Node.SIZE, Node.SIZE, Node.SIZE);
           g2.setPaint(gra1);
            g2.fillRoundRect(startNode.col*Node.SIZE, startNode.row*Node.SIZE, Node.SIZE, Node.SIZE, Node.SIZE, Node.SIZE);
        }
        if(endNode!=null){
            GradientPaint gra1=new GradientPaint(0,0,new Color(169, 15, 15),0,getHeight(),new Color(244, 104, 104));
           // g.fillRect(endNode.col*Node.SIZE, endNode.row*Node.SIZE, Node.SIZE, Node.SIZE);
           g2.setPaint(gra1);
            g2.fillRoundRect(endNode.col*Node.SIZE, endNode.row*Node.SIZE, Node.SIZE, Node.SIZE, Node.SIZE, Node.SIZE);
        }
    }
  
    
      
        public Node[][] getGrid() {
        return grid;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
    public void reset(){
        startNode=null;
        endNode=null;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Node node=grid[i][j];
                node.isPath=false;
                node.isWall=false;
                node.isVisited=false;
                node.distance=Integer.MAX_VALUE;
                node.parent=null;
            }
        }
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
