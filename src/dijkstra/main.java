
package dijkstra;


import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import swing.Button;


public class main extends javax.swing.JFrame {
    public panelVisualizer panel1;
    public background back;
    private Button button ;
    private MigLayout layout;
    private Button resetButton;
    
    public main() {
        initComponents();
        init();
    }
    
    
     public void init(){
         back=new background();
         resetButton=new Button();
         button =new Button();
         button.setFont(new Font("Gibson",1,20));
         button.setText("FIND");
         button.setBackground(new Color(215,237,226));
         button.setForeground(new Color(1,72,113));
         
          resetButton.setFont(new Font("Gibson",1,20));
         resetButton.setText("RESET");
         resetButton.setBackground(new Color(220, 53, 69));
         resetButton.setForeground(new Color(250,250,250));
         
         resetButton.addActionListener(e->{
         panel1.reset();
         });
         button.addActionListener(e->{
         new Thread(()->{
          dijkstra.helperDijkstra(panel1.getGrid(), panel1.getStartNode(), panel1.getEndNode(), panel1);
         }).start();
         });
         panel1=new panelVisualizer();
         JLabel head=new JLabel("DIJKSTRA ALGORITHM ANIMATION");
         head.setFont(new Font("Gibson",1,24));
         head.setForeground(new Color(215,237,226));
        JPanel container = new JPanel(new MigLayout("fill, wrap 1", "[grow]", "[]20[]10[grow]"));
        container.setOpaque(false);
        container.add(head,"center, w 30%,h 45");
        container.add(button, "split 2,center ,w 20%,h 40");
        container.add(resetButton,"center, w 20%,h 40");
        container.add(panel1, "grow");
         back.setLayout(new MigLayout("fill"));
        back.add(container,"grow");
            setContentPane(back);
       

     }
     

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("frame1");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
