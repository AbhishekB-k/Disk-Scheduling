import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;


public class NewJFrame2 extends javax.swing.JFrame {

    int temp1;
    int[] a = new int[20];
    int[] b = new int[20];
    int[] print = new int[20];
    int[] add = new int[20];
   
   

    public NewJFrame2(int c[],int x[]){
       temp1=c.length;
        for(int i=0;i<c.length;i++){
            b[i]=c[i];
            print[i]=x[i];
            a[i]=(b[i]*3+700);
        }
        
        initComponents();
         JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new NewJFrame1().setVisible(true);
        });
        getContentPane().add(backButton);
        backButton.setBounds(330, 930, 100, 30); 
        
    }
    
        public void paint(Graphics g)
   {
     Color myNewBlue = new Color (0, 59, 94);  //creates your new color
     Color myNewwhite = new Color (245, 245, 245);  //creates your new color
     
     //background
     g.setColor(myNewBlue); 
     g.fillRect(0,0,3000,1700);  
       
     // Heading 
     g.setColor(Color.WHITE);
     g.setFont(new Font("TimesRoman", Font.PLAIN, 40));   
     g.drawString("DISK SCHEDULING ",450,130);
     
     // Queue and Head
     g.setColor(Color.white);
     g.setFont(new Font("TimesRoman", Font.BOLD, 15));
     g.drawString("Queue :", 40, 250);                   
     int j=110;
     for(int i=1;i<temp1;i++){
         if(i==temp1-1)
             g.drawString(Integer.toString(print[i]), j, 250);        
         else
             g.drawString(Integer.toString(print[i])+" , ", j, 250);  
         j=j+40;
     }
     
     //Head
     g.drawString("Head Start At :", 40, 280);           
     g.drawString(Integer.toString((a[0]-700)/3), 150, 280);     
     
     // Total Head movement
     g.drawString("Total Head Movement :", 40, 460);
     
     //  string  0 and 199
     g.setColor(Color.white);
     g.setFont(new Font("TimesRoman", Font.BOLD, 15)); 
     g.drawString("0",700,210);            //190
     g.drawString("199",1297,210);         //190
     
     // vertical lines at 0 and 199
     g.setColor(Color.BLACK);
     g.drawRect(700,220,1,(temp1-1)*50);                 //190
     g.drawRect(1297,220,1,(temp1-1)*50);                //190
     
     // horizontal lines
     g.setColor(Color.BLACK);
     for(int i=220;i<=(((temp1-1)*50)+220);i=i+50){   //190
         for(int y=700;y<=1210;y=y+100){
            g.drawRect(y,i,100,1); 
            try{
                Thread.sleep(40);
            }
            catch(InterruptedException e){}
                
            }
         }
     
     // request queue points and verical lines 
     g.setColor(Color.WHITE);
     for(int i=0;i<temp1;i++)
        { 
           g.setColor(Color.WHITE); 
           g.setFont(new Font("TimesRoman", Font.BOLD, 15));
           if((((a[i]-700)/3)!=0) && (((a[i]-700)/3)!=199) ) {         
              g.drawString(Integer.toString((a[i]-700)/3),a[i]-2 , 210);   //190
           }
           g.setColor(Color.BLACK);
           g.drawRect(a[i],220,1,(temp1-1)*50);   //190
           
        }    
     
      try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
     
      //line between two points
      int x1,x2,y1,y2;
      
      y1=220;              // 190
      y2=y1+50;
      int t=40;
      for(int i=0;i<temp1-1;i++){
          x1=a[i];
          x2=a[i+1];
          g.setColor(Color.WHITE);
          g.drawLine(x1, y1, x2, y2);
          g.fillOval(x2-4,y2-4,8,8);
          if(x1>x2){
              if(i==temp1-2){
                  g.drawString("("+Integer.toString(((a[i]-700)/3))+"-"+Integer.toString((a[i+1]-700)/3)+" )",t, 490);
                   add[i]=(a[i]-700)/3-(a[i+1]-700)/3;}
              else{
                  g.drawString("("+Integer.toString(((a[i]-700)/3))+"-"+Integer.toString((a[i+1]-700)/3)+" ) +",t, 490);
                   add[i]=(a[i]-700)/3-(a[i+1]-700)/3;}
          }
          else{
              if(i==temp1-2){
                  g.drawString("("+Integer.toString(((a[i+1]-700)/3))+"-"+Integer.toString((a[i]-700)/3)+" )",t, 490);
                    add[i]=(a[i+1]-700)/3-(a[i]-700)/3;}
              else{
                    g.drawString("("+Integer.toString(((a[i+1]-700)/3))+"-"+Integer.toString((a[i]-700)/3)+" ) +",t, 490);
                    add[i]=(a[i+1]-700)/3-(a[i]-700)/3;}                 
          }
          y1=y1+50;
          y2=y2+50;
          t=t+78;
          try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}               
            
      }
       
       int sum=0;
       for(int i=0;i<temp1;i++){
           sum=sum+add[i];
       }
      
       // total head movements
       g.setFont(new Font("TimesRoman", Font.BOLD, 15));        
       g.drawString(" = "+Integer.toString(sum)+"  Cylinders",40 , 520);
     
     }  
    

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualization");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1513, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new NewJFrame2().setVisible(true);
            }
        });
    }

    
}


