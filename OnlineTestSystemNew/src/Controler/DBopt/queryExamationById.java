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
    public queryExamationById() {//空构造
    super("按Id查询试题");
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
			jlab1.setText("请输入题号");
			jtf1=new JTextField("",10);
			btnQuery=new JButton("查询");
			btnCancel=new JButton("清空");
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
						new JOptionPane().showMessageDialog(null,"请输入题号");
						}
					else {
						String str="select * from Examation where Id=" +jtf1.getText();
						
						try{
							if(JoinDB.query(str))
							{//此处用了个JoinDB.executeSQL(sql)提示resultset 关闭
								if(!JoinDB.rs.first())
								{
									JOptionPane.showMessageDialog(null,"此题不存在...");
								}
								else
								{
									for(int j=0;j<table.getColumnCount();j++)
										table.setValueAt(JoinDB.rs.getString(j+1), 0, j);
									new JOptionPane().showMessageDialog(null, "查询成功");
								}        
							}
							else
								new JOptionPane().showMessageDialog(null, "输入错误");
								
						}
			    catch(SQLException sqle)
				{
			    	new JOptionPane().showMessageDialog(null, "输入错误");
				}
				catch(Exception ex)
				{
					new JOptionPane().showMessageDialog(null, "输入错误");
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
