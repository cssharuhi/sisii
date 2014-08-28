package Controler.DBopt;



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataAcess.JoinDB;

public class deleteExamationById extends JInternalFrame{
	private JButton butCancel,butOk;
    private JLabel jLabel1;
    private JTextField jtf1;
    private JPanel p;
    public deleteExamationById() {//�չ���
    super("ɾ������");
        initComponents();
        
        this.setVisible(true);
        this.setClosable(true); 
        this.setLocation(100,200) ;   
   }
  
	
	void initComponents()
    {
		  jLabel1 = new JLabel();
	       Container con=getContentPane();
			con.setLayout(new FlowLayout());
			jLabel1.setText("���������");
			jtf1=new JTextField("",10);
			butOk=new JButton("ɾ��");
			butCancel=new JButton("���");
			p=new JPanel();
			p.add(jLabel1);
			p.add(jtf1);
			p.add(butOk);
			p.add(butCancel);
			con.add(p);
			setVisible(true);
			this.pack();
	        JoinDB.joinDB();
	        butOk.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
					if(jtf1.getText().equals("")){
						new JOptionPane().showMessageDialog(null,"���������");
						}
					else {
						String sql="select * from Examation where Id=" +jtf1.getText();
						
						try{
							if(JoinDB.query(sql))
							{
						    if(!JoinDB.rs.first())
						    {
						    	JOptionPane.showMessageDialog(null,"���ⲻ����...");
						    }
						    else
						    {
						    	String sqq="delete from Examation where Id=" +jtf1.getText();
						    	System.out.println("here");
						    	JoinDB.executeSQL(sqq);
						    	new JOptionPane().showMessageDialog(null, "ɾ���ɹ�");
						    }
						    
	    
							}
							else
							{
								new JOptionPane().showMessageDialog(null, "��������");
							}
						}
			    catch(SQLException sqle)
				{
					System.out.println(sqle.toString());
				}
				catch(Exception ex)
				{
					System.out.println(ex.toString());
				}
						}
	        		}
	        	});
	                
	      
	        butCancel.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		jtf1.setText("");
	        		}
	        	});

	    }
	        
}
