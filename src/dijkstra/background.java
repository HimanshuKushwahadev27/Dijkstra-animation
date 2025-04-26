
package dijkstra;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class background extends javax.swing.JPanel {

  
    public background() {
        initComponents();
    }

    @Override
        public void paintComponent(Graphics g){
         Graphics2D g2=(Graphics2D)g;
         GradientPaint gra=new GradientPaint(0,0,new Color(1,72,113),0,getHeight(),new Color(215,237,226));
         g2.setPaint(gra);
         g2.fillRect(0, 0, getWidth(), getHeight());
         super.paintComponent(g);
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
