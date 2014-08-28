package Controler.DBopt;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DataAcess.JoinDB;

public class queryExamationById extends JInternalFrame {
	private JButton btnCancel,btnQuery;
    private JLabel jlab1;
    private JTextField jtf1;
    private JPanel p;
    private JTable table;
    private JPanel Tp;
    public queryExamationById() {//�չ���
    super("��Id��ѯ����");
        initComponents();
        
        this.setVisible(true);
        this.setClosable(true); 
        this.setLocation(100,200) ;   
   }
  
	
	void initComponents()
    {
		  jlab1 = new JLabel();
	       Container con=getContentPane();
			con.setLayout(new BorderLayout());
			jlab1.setText("���������");
			jtf1=new JTextField("",10);
			btnQuery=new JButton("��ѯ");
			btnCancel=new JButton("���");
			table = new JTable(1,7);
			Tp = new JPanel();
			Tp.add(table);
			p=new JPanel();
			p.add(jlab1);
			p.add(jtf1);
			p.add(btnQuery);
			p.add(btnCancel);
			
			con.add(p);
			con.add(Tp,"South");
			setVisible(true);
			this.pack();
	        JoinDB.joinDB();
	        btnQuery.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
					if(jtf1.getText().equals("")){
						new JOptionPane().showMessageDialog(null,"���������");
						}
					else {
						String str="select * from Examation where Id=" +jtf1.getText();
						
						try{
							if(JoinDB.query(str))
							{//�˴����˸�JoinDB.executeSQL(sql)��ʾresultset �ر�
								if(!JoinDB.rs.first())
								{
									JOptionPane.showMessageDialog(null,"���ⲻ����...");
								}
								else
								{
									for(int j=0;j<table.getColumnCount();j++)
										table.setValueAt(JoinDB.rs.getString(j+1), 0, j);
									new JOptionPane().showMessageDialog(null, "��ѯ�ɹ�");
								}        
							}
							else
								new JOptionPane().showMessageDialog(null, "�������");
								
						}
			    catch(SQLException sqle)
				{
			    	new JOptionPane().showMessageDialog(null, "�������");
				}
				catch(Exception ex)
				{
					new JOptionPane().showMessageDialog(null, "�������");
				}
						}
	        		}
	        	});
	                
	      
	        btnCancel.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		jtf1.setText("");
	        		}
	        	});

	    }
	        
}
