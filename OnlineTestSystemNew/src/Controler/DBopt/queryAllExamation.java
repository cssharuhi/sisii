package Controler.DBopt;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import DataAcess.JoinDB;
public class queryAllExamation extends JInternalFrame{
	private JTable table;
	private int RowsCount;
	private ResultSet rs2;
	public queryAllExamation()  
	{
		JoinDB.joinDB();
		String str = "SELECT * FROM Examation";
		JoinDB.query(str);
		try{
			JoinDB.rs.last();
			RowsCount = JoinDB.rs.getRow();
			
		}
		catch(SQLException ex)
		{
			
		}
		
		table = new JTable(RowsCount+1,7);
		table.setValueAt("���", 0, 0);
		table.setValueAt("�Ѷ�", 0, 1);
		table.setValueAt("ʱ��", 0, 2);
		table.setValueAt("��������", 0, 3);
		table.setValueAt("��", 0, 4);
		table.setValueAt("��ֵ", 0, 5);
		table.setValueAt("����", 0, 6);
		try {
			JoinDB.rs.first();
			for(int i =1;i<table.getRowCount();i++)
			{
				
				for(int j=0;j<table.getColumnCount();j++)
					table.setValueAt(JoinDB.rs.getString(j+1), i, j);
				JoinDB.rs.next();
			} 
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		add(table);
		this.pack();
		this.setVisible(true);
        this.setClosable(true); 
        this.setLocation(100,200) ; 
	}

}
