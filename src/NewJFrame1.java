import static java.nio.file.Files.size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

 
public class NewJFrame1 extends javax.swing.JFrame {

    
    String s,algo;
    int head;

    public NewJFrame1() {
        initComponents();
    }
    
    public int substract(int a,int b){
	if(a>b)
	    return(a-b);
	else
	    return(b-a);    
    }
    
    static int[] fcfs(int arr[], int head) 
    {
        int size=arr.length;
        Vector<Integer> list = new Vector<Integer>();
        int [] a = new int[size+1];
        list.add(head);
        
        for (int i = 0; i < size; i++){
           list.add(arr[i]);
        }
    
        for (int i = 0; i < list.size(); i++){
           a[i]=list.get(i);
           System.out.println(a[i]);
        }
        
        return a;
    }
    
    public int[] sstf(int a[]){
        
        int [] done=new int[20];
        int [] sstf=new int[20];
        int i,l,column=0,temp,j=0;
        int nearest= substract(a[0],a[1]);
        sstf[0]=a[0];
        temp=a[0];
        
        for(i=0;i<a.length;i++)
            done[i]=0;
        
   
	for(i=1;i<a.length;i++){

		l=1;     
		while(l<10 && done[l]!=0){
			l++;
		}
		     			 
		nearest=substract(a[l],temp);	      
				    
   		for(j=1;j<a.length;j++){
   	   		if(done[j]!=1 && (substract(a[j],temp)<=nearest) && (substract(a[j],temp)!=0)){     	   	 	   	  		
   	   	      		nearest=substract(a[j],temp); 
   	   	      		column=j;					  	  					
			}
   		}
   		done[column]=1; 
   		sstf[i]= a[column];
   		temp=sstf[i];  		 		 
        }
        
        for(i=0;i<a.length;i++)
            a[i]=sstf[i];
        
        return a;
    }
    
static int[] scan(int arr[], int head, String direction)
{
    int size=arr.length;
    int cur_track;
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+2];
    list.add(head);

    if (direction == "left")
        left.add(0);
    else if (direction == "right")
        right.add(199);
 
    for (int i = 0; i < size; i++) 
    {
        if (arr[i] < head)
            left.add(arr[i]);
        if (arr[i] > head)
            right.add(arr[i]);
    }
    
    Collections.sort(left);
    Collections.sort(right);

    int run = 2;
    while (run-- >0)
    {
        if (direction == "left") 
        {
            for (int i = left.size() - 1; i >= 0; i--) 
            {
                cur_track = left.get(i);
                seek_sequence.add(cur_track);
                head = cur_track;
            }
            direction = "right";
        }
        else if (direction == "right") 
        {
            for (int i = 0; i < right.size(); i++) 
            {
                cur_track = right.get(i);
                seek_sequence.add(cur_track);
                head = cur_track;
            }
            direction = "left";
        }
    }
 
    
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
    }
    
    return a;
}

static int[] cscan(int arr[], int head) 
{ 
    int size=arr.length;
    int cur_track; 
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>(); 
    Vector<Integer> seek_sequence = new Vector<Integer>(); 
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+3];
    list.add(head);
    
    left.add(0); 
    right.add(199); 
  
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.add(arr[i]); 
        if (arr[i] > head) 
            right.add(arr[i]); 
    } 
 
    Collections.sort(left);
    Collections.sort(right); 
 
    for (int i = 0; i < right.size(); i++) { 
        cur_track = right.get(i);
        seek_sequence.add(cur_track);
        head = cur_track; 
    } 

    head = 0; 
 
    for (int i = 0; i < left.size(); i++) { 
        cur_track = left.get(i);  
        seek_sequence.add(cur_track); 
        head = cur_track; 
    } 
 
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
    }
    
    return a; 
} 

static int[] look(int arr[], int head, String direction)
{
    int size=arr.length;
    int cur_track;
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+1];
    list.add(head);
    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.add(arr[i]); 
        if (arr[i] > head) 
            right.add(arr[i]); 
    } 

    Collections.sort(left);
    Collections.sort(right);

    int run = 2; 
    while (run>0) { 
        if (direction == "left") { 
            for (int i = left.size() - 1; i >= 0; i--) { 
                cur_track = left.get(i); 
                seek_sequence.add(cur_track); 
                head = cur_track; 
            } 
            direction = "right"; 
        } 
        else if (direction == "right") { 
            for (int i = 0; i < right.size(); i++) { 
                cur_track = right.get(i); 
                seek_sequence.add(cur_track); 
                head = cur_track; 
            } 

            direction = "left"; 
        } 
        
       run--;
    } 
 
    
    for (int i = 0; i < seek_sequence.size(); i++){
        list.add(seek_sequence.get(i));       
    }
    
    for (int i = 0; i < list.size(); i++){
        a[i]=list.get(i);
    }
    
    return a;
}

static int[] clook(int arr[], int head) 
{ 
    int size=arr.length;
    int cur_track; 
    Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
    Vector<Integer> list = new Vector<Integer>();
    int [] a = new int[size+1];
    list.add(head); 

    for (int i = 0; i < size; i++) { 
        if (arr[i] < head) 
            left.add(arr[i]); 
        if (arr[i] > head) 
            right.add(arr[i]); 
    } 

    Collections.sort(left);
    Collections.sort(right);

    for (int i = 0; i < right.size(); i++) { 
        
        cur_track = right.get(i); 
        seek_sequence.add(cur_track); 
        head = cur_track; 
    } 

    head = left.get(0); 
  
    for (int i = 0; i < left.size(); i++) { 
        cur_track = left.get(i); 
        seek_sequence.add(cur_track); 
        head = cur_track; 
    } 
    
    for (int i = 0; i < seek_sequence.size(); i++)
    {
        list.add(seek_sequence.get(i));
        
    }
    
    for (int i = 0; i < list.size(); i++)
    {
        a[i]=list.get(i);
    }
    
    return a;
  
    
} 
    
    

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DISK SCHEDULING");
        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints;

        jLabel1.setFont(new java.awt.Font("Imprint MT Shadow", 0, 36)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DISK SCHEDULING");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("R/W Head Position :");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabel5, gridBagConstraints);

        jTextField1.setColumns(10);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jTextField1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Request Queue :");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabel2, gridBagConstraints);

        jTextField3.setColumns(15);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jTextField3, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Algorithm :");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jLabel3, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "SSTF", "SCAN", "C SCAN", "LOOK", "C LOOK" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jComboBox1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); 
        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        getContentPane().add(jButton1, gridBagConstraints);



        pack();
        setLocationRelativeTo(null);
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        s=jTextField3.getText();
        head=Integer.parseInt(jTextField1.getText());
        String[] strArray = s.split(",");
        
        
        if(algo=="FCFS"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+1];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=fcfs(a,head);
            new NewJFrame2(c,c).setVisible(true);
            
        }
        
        else if(algo=="SSTF"){
            int [] a = new int[strArray.length+1];
            int [] b = new int[strArray.length+1];

            ArrayList<Integer> list = new ArrayList<Integer>(strArray.length+1);
            list.add(head);
            for(int i=0;i<strArray.length;i++){
               list.add(Integer.parseInt(strArray[i]));
            }
        
            for(int i=0;i<list.size();i++){
                a[i]=list.get(i);
            }

            b=a;
            a=sstf(a);
            new NewJFrame2(a,b).setVisible(true);
            
        }
        
        else if(algo=="SCAN"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+2];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=scan(a,head,"left");
            new NewJFrame2(c,c).setVisible(true);
            
        }
        
        
        else if(algo=="C SCAN"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+3];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=cscan(a,head);
            new NewJFrame2(c,c).setVisible(true);
            
        }
        
         else if(algo=="LOOK"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+1];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=look(a,head,"left");
            new NewJFrame2(c,c).setVisible(true);
            
        }
        
        else if(algo=="C LOOK"){
            int [] a = new int[strArray.length];
            int [] c = new int[strArray.length+1];

            for(int i=0;i<strArray.length;i++){
               a[i]=Integer.parseInt(strArray[i]);
            }

            c=clook(a,head);
            new NewJFrame2(c,c).setVisible(true);
            
        }
             
        
       
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox1.getSelectedItem() != null) {
            algo=jComboBox1.getSelectedItem().toString();
        }
    }

    /**
     * @param args 
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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame1 frame = new NewJFrame1();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame to fit the screen
                frame.setVisible(true);
                    
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
}
