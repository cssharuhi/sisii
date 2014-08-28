package Controler.OnlienTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import Class.Examation;
import DataAcess.JoinDB;
public class TestFrame extends BasicExamationFrame{
	private JButton btnSubmit,btnNext,btnFinish;
	private JRadioButton rda,rdb,rdc,rdd;
	public ButtonGroup bgp1,bgp2;
	private JCheckBox cbYes,cbNo;
	private JTextField txt;
	private int RandomIndex;
	private ArrayList<Examation> listData ;
	private int TatalScore;
	private JComboBox DifficultySelecte;
	public void initComp()
	{
	
		this.setTitle("开始答题");
		btnSubmit = new JButton("提交");
		btnNext = new JButton("下一题");
		btnFinish = new JButton("完成测试");
		
		bgp2 = new ButtonGroup();
		bgp1 = new ButtonGroup();
		txt = new JTextField();
		cbYes = new JCheckBox("是");
		cbNo = new JCheckBox("否");
		DifficultySelecte = new JComboBox();
		DifficultySelecte.addItem("难度1");
		DifficultySelecte.addItem("难度2");
		DifficultySelecte.addItem("难度3");
		DifficultySelecte.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getDataFromDBByHard();
			}
			
		});
		this.add(DifficultySelecte);
		DifficultySelecte.setBounds(40, 130, 100, 20);
		bgp2.add(cbYes);
		bgp2.add(cbNo);
		this.add(cbNo);
		this.add(cbYes);
		cbYes.setBounds(200, 150, 40, 40);
		cbNo.setBounds(240, 150, 40, 40);
		
		rda = new JRadioButton("A");
		rdb = new JRadioButton("B");
		rdc = new JRadioButton("C");
		rdd = new JRadioButton("D");
		
		bgp1.add(rda);
		bgp1.add(rdb);
		bgp1.add(rdc);
		bgp1.add(rdd);

		this.add(rda);
		this.add(rdb);
		this.add(rdc);
		this.add(rdd);
		this.add(txt);
		txt.setBounds(280, 160, 60, 20);
		btnSubmit.setEnabled(false);
		rda.setBounds(40, 150, 40, 40);
		rdb.setBounds(80, 150, 40, 40);
		rdc.setBounds(120, 150, 40, 40);
		rdd.setBounds(160, 150, 40, 40);
		
		add(btnSubmit);
		add(btnNext);
		add(btnFinish);
		btnSubmit.setBounds(0, 200, 100, 20);
		btnNext.setBounds(100, 200, 100, 20);
		btnFinish.setBounds(200, 200, 100, 20);
		btnFinish.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new JOptionPane().showMessageDialog(null, "你总得分："+TatalScore);
			}
			
		});
		btnNext.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnSubmit.setEnabled(true);
				Random rd = new Random();
				
				int k = rd.nextInt(listData.size());
				while(k>listData.size()||k<0)
					k = rd.nextInt();
				RandomIndex = k;
				Examation data = listData.get(k);
				txtContent.setText("题目 "+data.getId()+":"+data.getContent());
				switch(data.getType())
				{
				case 1:
					getSelectFrame();
					break;
				case 2:
					getCheckFrame();
					break;
				case 3:
					getBlankFrame();
					break;
				
				}
				btnNext.setEnabled(false);
			}
			
		});
		btnSubmit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Examation data = listData.get(RandomIndex);
			//	txtContent.setText(data.getContent());
				switch(data.getType())
				{
				case 1:
					if(getSelectString().equals(""))
						new JOptionPane().showMessageDialog(null, "请选择");
					else
					{
						if(data.getAnswer().equals(getSelectString()))
							TatalScore+=data.getScore();
						btnNext.setEnabled(true);
						btnSubmit.setEnabled(false);
					}		
					break;
				case 2:
					if(getCheckString().equals(""))
						new JOptionPane().showMessageDialog(null, "请选择!");
					else
					{
						if(data.getAnswer().equals(getCheckString()))
							TatalScore+=data.getScore();
						btnNext.setEnabled(true);
						btnSubmit.setEnabled(false);
					}
					break;
				case 3:
					if(getBlankString().equals(""))
						new JOptionPane().showMessageDialog(null, "请填空!");
					else 
						{
							if(data.getAnswer().equals(getBlankString()))
								TatalScore+=data.getScore();
							btnNext.setEnabled(true);
							btnSubmit.setEnabled(false);
						}	
					break;
				
				}
				
			}
			
		});
	}
	public String getSelectString()
	{
		String result="";
		if(rda.isSelected())
			result = "A";
		else if(rdb.isSelected())
				result = "B";
		else if(rdc.isSelected())
				result = "C";
		else if(rdd.isSelected())
			result ="D";
		
		return result;
	}
	public String getCheckString()
	{
		String result = "";
		if(cbYes.isSelected())
			result = "是";
		else if(cbNo.isSelected())
			result = "否";
		return result;
	}
	public String getBlankString()
	{
		String result;
		result = txt.getText();
		return result;
	}
	public void getCheckFrame() 
	{
		bgp1.clearSelection();
		txt.setText("");
		rda.setEnabled(false);
		rdb.setEnabled(false);
		rdc.setEnabled(false);
		rdd.setEnabled(false);
		txt.setEnabled(false);
		cbYes.setEnabled(true);
		cbNo.setEnabled(true);
	}
	public void getSelectFrame()
	{
		bgp2.clearSelection();
		txt.setText("");
		cbYes.setEnabled(false);
		cbNo.setEnabled(false);
		txt.setEnabled(false);
		rda.setEnabled(true);
		rdb.setEnabled(true);
		rdc.setEnabled(true);
		rdd.setEnabled(true);
	}
	public void getBlankFrame()
	{
		txt.setEnabled(true);
		rda.setEnabled(false);
		rdb.setEnabled(false);
		rdc.setEnabled(false);
		rdd.setEnabled(false);
		cbYes.setEnabled(false);
		cbNo.setEnabled(false);
	
	}
	public void getDataFromDB()  
	{
		JoinDB.joinDB();
		String sql = "select * from Examation";
		JoinDB.query(sql);
		listData = new ArrayList<Examation>();
		try{
			if(JoinDB.rs == null)
			{
				new JOptionPane().showMessageDialog(this, "数据库已经没有试题!");
				return ;
			}
			while(JoinDB.rs.next())
			{
				Examation temp = new Examation();
				temp.setId(Integer.parseInt(JoinDB.rs.getString(1)));
				temp.setDifficulty(JoinDB.rs.getString(2));
				temp.setXTime(Integer.parseInt(JoinDB.rs.getString(3)));
				temp.setContent(JoinDB.rs.getString(4));
				temp.setAnswer(JoinDB.rs.getString(5));
				temp.setScore(Integer.parseInt(JoinDB.rs.getString(6)));
				temp.setType(Integer.parseInt(JoinDB.rs.getString(7)));
				listData.add(temp);
			}
		}
		catch(SQLException ex)
		{
			
		}
	}
	public void getDataFromDBByHard()
	{
		listData.clear();
		int index = DifficultySelecte.getSelectedIndex()+1;
		System.out.println(index);
		String Sql = "select * from Examation where Difficulty='"+index+"'";
		JoinDB.joinDB();
		JoinDB.query(Sql);
		listData = new ArrayList<Examation>();
		try{
			if(JoinDB.rs == null)
			{
				new JOptionPane().showMessageDialog(this, "数据库已经没有试题!");
				return ;
			}
			while(JoinDB.rs.next())
			{
				Examation temp = new Examation();
				temp.setId(Integer.parseInt(JoinDB.rs.getString(1)));
				temp.setDifficulty(JoinDB.rs.getString(2));
				temp.setXTime(Integer.parseInt(JoinDB.rs.getString(3)));
				temp.setContent(JoinDB.rs.getString(4));
				temp.setAnswer(JoinDB.rs.getString(5));
				temp.setScore(Integer.parseInt(JoinDB.rs.getString(6)));
				temp.setType(Integer.parseInt(JoinDB.rs.getString(7)));
				listData.add(temp);
			}
		}
		catch(SQLException ex)
		{
			
		}
	}
	public TestFrame()
	{
		getDataFromDB();
		initComp();
		
		this.setSize(400, 300);
		this.setVisible(true);
	}
}
