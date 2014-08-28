package Controler.DBopt;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataAcess.JoinDB;

public class addExamation extends JFrame{
	private JButton btnCancel,btnAdd;
    private JLabel jlab1,jlab2,jlab3,jlab4,jlab5,jlab6,jlab7;
    private JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;

    public addExamation() {//空构造
    super("添加试题");
        initComponents();
        
        this.setVisible(true);
        this.setClosable(true);
        this.setSize(260,310);
        
   }

    private void setClosable(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
    	
    	//实例化并添加控件
        jlab1 = new JLabel();
        jlab2 = new JLabel();
        jlab3 = new JLabel();
        jlab4 = new JLabel();
        jlab5 = new JLabel();
        jlab6 = new JLabel();
        jlab7 = new JLabel();       
        jtf1=new JTextField();
        jtf2=new JTextField();
        jtf3=new JTextField();
        jtf4=new JTextField();
        jtf5=new JTextField();
        jtf6=new JTextField();
        jtf7=new JTextField();     
        btnAdd = new JButton();
        btnCancel = new JButton();       
        //实例化并添加控件完成

        getContentPane().setLayout(null);//设置布局
        
        
        //为空间放置具体位置
        jlab1.setText("题号(>=1)");
        getContentPane().add(jlab1);
        jlab1.setBounds(30, 30, 70, 20);

        jlab2.setText("难度(1-3)");
        getContentPane().add(jlab2);
        jlab2.setBounds(30, 60, 70, 20);

        jlab3.setText("预期时间");
        getContentPane().add(jlab3);
        jlab3.setBounds(30, 90, 60, 20);
        
        jlab4.setText("题目内容及选项");
        getContentPane().add(jlab4);
        jlab4.setBounds(30, 120, 70, 20);

        jlab5.setText("答案");
        getContentPane().add(jlab5);
        jlab5.setBounds(30, 150, 70, 20);
        
        jlab6.setText("得分");
        getContentPane().add(jlab6);
        jlab6.setBounds(30, 180, 70, 20);
        
        jlab7.setText("类型(1-3)");
        getContentPane().add(jlab7);
        jlab7.setBounds(30, 210, 70, 20);
                
        getContentPane().add(jtf1);
        jtf1.setBounds(100, 30, 130, 24);

        getContentPane().add(jtf2);
        jtf2.setBounds(100, 60, 130, 24);

        getContentPane().add(jtf3);
        jtf3.setBounds(100, 90, 130, 24);
        
        getContentPane().add(jtf4);
        jtf4.setBounds(100, 120, 130, 24);
        
        getContentPane().add(jtf5);
        jtf5.setBounds(100, 150, 130, 24);
        
        getContentPane().add(jtf6);
        jtf6.setBounds(100, 180, 130, 24);
        
        getContentPane().add(jtf7);
        jtf7.setBounds(100, 210, 130, 24);
        
        btnAdd.setText("添加");

        getContentPane().add(btnAdd);
        btnAdd.setBounds(80, 240, 70, 27);

        btnCancel.setText("清空");
        getContentPane().add(btnCancel);
        btnCancel.setBounds(160, 240, 70, 27);

       
        //为空间放置具体位置结束


         JoinDB.joinDB();
        
//为添加和取消按钮加事件-----------------------------------------
        btnAdd.addActionListener(new ActionListener(){
        
        	public void actionPerformed(ActionEvent e){
				if(jtf1.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"题号不能为空");
					}
				else if(jtf2.getText().equals("") ){
					new JOptionPane().showMessageDialog(null,"难度不能为空");
					}
				else if(jtf3.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"预期时间不能为空");
					}
				else if(jtf4.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"内容不能为空");
					}
				else if(jtf5.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"答案不能为空");
					}
				else if(jtf6.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"得分不能为空");
					}
				else if(jtf7.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"类型不能为空");
					}
		
				else{
					String sql="insert into Examation values('"+ jtf1.getText() +"','"+ jtf2.getText() +"','"+ jtf3.getText() +"','"+ jtf4.getText()+"','"+ jtf5.getText()+"','"+ jtf6.getText()+"','"+ jtf7.getText()+"')";
					String sqlQuery="select * from Examation";
					try{
						JoinDB.query(sqlQuery);
						boolean isConflict=false; 
						while(JoinDB.rs.next())
						{
							if(JoinDB.rs.getString(1).equals(jtf1.getText()))
							{
								isConflict = true;
								break;
							}
						}
						
						if(!isConflict && JoinDB.executeSQL(sql)){
					    	new JOptionPane().showMessageDialog(null,"添加成功！");			        
         		         }
						else
							if(isConflict)
								new JOptionPane().showMessageDialog(null, "主键冲突,添加失败");
							else
								new JOptionPane().showMessageDialog(null, "输入数据有误，请按照要求输入");
						}
					catch(Exception ea){
						
					}
					}
        		}
        	});

        btnCancel.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		jtf1.setText("");
        		jtf2.setText("");
        		jtf3.setText("");
        		jtf4.setText("");
        		jtf5.setText("");
        		jtf6.setText("");
        		jtf7.setText("");
        		
        		}
        	});

    }
}
