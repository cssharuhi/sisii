package Controler.DBopt;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Controler.OnlienTest.TestFrame;

import java.sql.*;
/**
 * ��������ϵͳ������
 * @author ���Һ� 
 *
 */
public class MainFrame extends JFrame {

	/*
	 * �ڴ����ｨ���������沢ʵ����
	 */
	JDesktopPane deskpane = new JDesktopPane();
	/*
	 * ����һ����岢ʵ����
	 */
	JPanel p = new JPanel();
	public MainFrame(){//���캯��
		setTitle("OnlineTestSystem");//���ô������
		Container con = getContentPane();
		con.setLayout(new BorderLayout());//����һ������
		con.add(deskpane,BorderLayout.CENTER);//ʵ����������Ĳ���
		Font f =new Font("������",Font.PLAIN,12);	
		JMenuBar mb = new JMenuBar();//ʵ�����˵���
	    mb.setOpaque(true);
		setJMenuBar(mb);
		
  
		JMenu OnlineTest = new JMenu("��������");
		OnlineTest.setFont(f);
		mb.add(OnlineTest);
		
		JMenuItem beginTest = new JMenuItem("��ʼ����");
		OnlineTest.add(beginTest);
		
		JMenu dbMaintance = new JMenu("���ݿ�ά��");
		dbMaintance.setFont(f);
		mb.add(dbMaintance);
		JMenu addM= new JMenu("�������");
		addM.setFont(f);
		JMenu viewM = new JMenu("��ѯ����");
		viewM.setFont(f);
		JMenu modifM = new JMenu("�޸�����");
		modifM.setFont(f);		
		JMenuItem addinf = new JMenuItem("�������");
		addinf.setFont(f);
		addM.add(addinf);
		JMenuItem QueryAll = new JMenuItem("�鿴��������");
		viewM.add(QueryAll);
		JMenuItem queryById = new JMenuItem("����Ų�ѯ");
		
		viewM.add(queryById);
		JMenuItem update = new JMenuItem("�����޸�");
	
		modifM.add(update);
		JMenuItem delete= new JMenuItem("ɾ������");
		
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
           addinf.addActionListener(new ActionListener(){//���ѧ����Ϣ
        	public void actionPerformed(ActionEvent e){
        		new addExamation();
        		}
        	});
    
        	
        	QueryAll.addActionListener(new ActionListener(){//ѧ��������Ϣ�鿴
        	public void actionPerformed(ActionEvent e){
        		System.out.println("�鿴��������");
        		deskpane.add(new queryAllExamation());
        		}
        	});
        	
        	queryById.addActionListener(new ActionListener(){//ѧ���ɼ���Ϣ�鿴
        	public void actionPerformed(ActionEvent e){
        		System.out.println("����Id��ѯ����");
        		deskpane.add(new queryExamationById());
        		}
        	});
        	update.addActionListener(new ActionListener(){//ѧ��������Ϣ�޸�
        	public void actionPerformed(ActionEvent e){
        		System.out.println("����Id��������");
        		new updateExamationById();
        		}
        	});
        	
        	delete.addActionListener(new ActionListener(){//ɾ��ѧ����Ϣ
        	public void actionPerformed(ActionEvent e){
        		System.out.println("ɾ������");
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

