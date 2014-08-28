package Controler.DBopt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Controler.OnlienTest.TestFrame;

import java.sql.*;
/**
 * 联机测试系统主界面
 * @author 蒲桃红 
 *
 */
public class MainFrame extends JFrame {

	/*
	 * 在窗体里建立虚拟桌面并实例化
	 */
	JDesktopPane deskpane = new JDesktopPane();
	/*
	 * 创建一个面板并实例化
	 */
	JPanel p = new JPanel();
	public MainFrame(){//构造函数
		setTitle("OnlineTestSystem");//设置窗体标题
		Container con = getContentPane();
		con.setLayout(new BorderLayout());//创建一个布局
		con.add(deskpane,BorderLayout.CENTER);//实例虚拟桌面的布局
		Font f =new Font("新宋体",Font.PLAIN,12);	
		JMenuBar mb = new JMenuBar();//实例化菜单栏
	    mb.setOpaque(true);
		setJMenuBar(mb);
		
  
		JMenu OnlineTest = new JMenu("联机测试");
		OnlineTest.setFont(f);
		mb.add(OnlineTest);
		
		JMenuItem beginTest = new JMenuItem("开始测试");
		OnlineTest.add(beginTest);
		
		JMenu dbMaintance = new JMenu("数据库维护");
		dbMaintance.setFont(f);
		mb.add(dbMaintance);
		JMenu addM= new JMenu("添加试题");
		addM.setFont(f);
		JMenu viewM = new JMenu("查询试题");
		viewM.setFont(f);
		JMenu modifM = new JMenu("修改试题");
		modifM.setFont(f);		
		JMenuItem addinf = new JMenuItem("添加试题");
		addinf.setFont(f);
		addM.add(addinf);
		JMenuItem QueryAll = new JMenuItem("查看所有试题");
		viewM.add(QueryAll);
		JMenuItem queryById = new JMenuItem("按题号查询");
		
		viewM.add(queryById);
		JMenuItem update = new JMenuItem("试题修改");
	
		modifM.add(update);
		JMenuItem delete= new JMenuItem("删除试题");
		
		dbMaintance.add(addM);
		dbMaintance.add(viewM);
		dbMaintance.add(modifM);
		dbMaintance.add(delete);
	
		beginTest.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TestFrame();
			}
			
		});
           addinf.addActionListener(new ActionListener(){//添加学生信息
        	public void actionPerformed(ActionEvent e){
        		new addExamation();
        		}
        	});
    
        	
        	QueryAll.addActionListener(new ActionListener(){//学生基本信息查看
        	public void actionPerformed(ActionEvent e){
        		System.out.println("查看所有试题");
        		deskpane.add(new queryAllExamation());
        		}
        	});
        	
        	queryById.addActionListener(new ActionListener(){//学生成绩信息查看
        	public void actionPerformed(ActionEvent e){
        		System.out.println("按照Id查询试题");
        		deskpane.add(new queryExamationById());
        		}
        	});
        	update.addActionListener(new ActionListener(){//学生基本信息修改
        	public void actionPerformed(ActionEvent e){
        		System.out.println("根据Id更新试题");
        		new updateExamationById();
        		}
        	});
        	
        	delete.addActionListener(new ActionListener(){//删除学生信息
        	public void actionPerformed(ActionEvent e){
        		System.out.println("删除试题");
        		deskpane.add(new deleteExamationById());
        		}
        	});
 
        this.setBounds(200,200,700,500);
		setVisible(true);	 
             }

	public static void main(String[] args){
		new MainFrame();
		}
	}

