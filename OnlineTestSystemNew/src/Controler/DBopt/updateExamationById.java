package Controler.DBopt;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataAcess.JoinDB;

public class updateExamationById extends JFrame{

	private JButton btnCancel,btnUpdate,btnShow;
    private JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlab6,jlab7;
    private JTextField Id,Difficulty,Time,Content,Answer,Score,Type;

    public updateExamationById() {//空构造
    super("修改试题");
        initComponents();
  
        this.setVisible(true);
        this.setSize(300,310);
        
   }
    private void initComponents() {
    	
    	//实例化并添加控件
        jlb1 = new JLabel();
        jlb2 = new JLabel();
        jlb3 = new JLabel();
        jlb4 = new JLabel();
        jlb5 = new JLabel();
        jlab6 = new JLabel();
        jlab7 = new JLabel();       
        Id=new JTextField();
        
        Difficulty=new JTextField();
        Time=new JTextField();
        Content=new JTextField();
        Answer=new JTextField();
        Score=new JTextField();
        Type=new JTextField();     
        btnUpdate = new JButton();
        btnUpdate.setEnabled(false);
        btnCancel = new JButton();
        btnShow = new JButton();       
        //实例化并添加控件完成

        getContentPane().setLayout(null);//设置布局
        
        
        //为空间放置具体位置
        jlb1.setText("试题编号");
        getContentPane().add(jlb1);
        jlb1.setBounds(30, 30, 70, 20);
      

        jlb2.setText("难度");
        getContentPane().add(jlb2);
        jlb2.setBounds(30, 60, 70, 20);

        jlb3.setText("预期时间");
        getContentPane().add(jlb3);
        jlb3.setBounds(30, 90, 60, 20);
        
        jlb4.setText("试题内容及选项");
        getContentPane().add(jlb4);
        jlb4.setBounds(30, 120, 70, 20);

        jlb5.setText("答案");
        getContentPane().add(jlb5);
        jlb5.setBounds(30, 150, 70, 20);
        
        jlab6.setText("得分");
        getContentPane().add(jlab6);
        jlab6.setBounds(30, 180, 70, 20);
        
        jlab7.setText("类型");
        getContentPane().add(jlab7);
        jlab7.setBounds(30, 210, 70, 20);
                
        getContentPane().add(Id);
        Id.setBounds(100, 30, 130, 24);

        getContentPane().add(Difficulty);
        Difficulty.setBounds(100, 60, 130, 24);

        getContentPane().add(Time);
        Time.setBounds(100, 90, 130, 24);
        
        getContentPane().add(Content);
        Content.setBounds(100, 120, 130, 24);
        
        getContentPane().add(Answer);
        Answer.setBounds(100, 150, 130, 24);
        
        getContentPane().add(Score);
        Score.setBounds(100, 180, 130, 24);
        
        getContentPane().add(Type);
        Type.setBounds(100, 210, 130, 24);
        
        btnShow.setText("显示信息");
        getContentPane().add(btnShow);
        btnShow.setBounds(20, 240,90, 27);

        btnUpdate.setText("修改");
        getContentPane().add(btnUpdate);
        btnUpdate.setBounds(120, 240, 70, 27);
        btnUpdate.enable(false);
        
        btnCancel.setText("清空");
        getContentPane().add(btnCancel);
        btnCancel.setBounds(200,240,70,27);
        
        //为空间放置具体位置结束
        JoinDB.joinDB();
        btnUpdate.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
				
					String sql="update Examation set Difficulty='"+ Difficulty.getText() +"',xTime="+ Time.getText() +",Content='"+ Content.getText()+"',Answer='"+ Answer.getText()+"',Score="+ Score.getText()+",Type="+ Type.getText()+" where Id="+Id.getText();
					try{
						if(JoinDB.executeSQL(sql)){
							Id.setEditable(true);
							btnShow.setEnabled(true);
					    	new JOptionPane().showMessageDialog(null,"更新成功！");			        
         		         }
						else
							new JOptionPane().showMessageDialog(null,"请按照要求修改数据");	
						}
					catch(Exception ea){}
					}  	
        	});
        btnShow.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
				if(Id.getText().equals("")){
					new JOptionPane().showMessageDialog(null,"请输入题号");
					}
				else {
					String sql="select * from Examation where Id=" +Id.getText();
					try{
						if(JoinDB.query(sql)){//此处用了个JoinDB.executeSQL(sql)提示resultset 关闭
					    if(!JoinDB.rs.first())
			{
				JOptionPane.showMessageDialog(null,"此试题不存在...");
			}
				else {	
						JoinDB.rs.first();
					    String num1=JoinDB.rs.getString(2);
				        Difficulty.setText(num1);
		                Time.setText(JoinDB.rs.getString(3));
		                Content.setText(JoinDB.rs.getString(4));
		                Answer.setText(JoinDB.rs.getString(5));
		                Score.setText(JoinDB.rs.getString(6));
		                Type.setText(JoinDB.rs.getString(7));
		                Id.setEditable(false);
		                btnShow.setEnabled(false);
		                btnUpdate.setEnabled(true);		        
         		        } }
						}
			catch(NullPointerException upe)
		        {
		        	System.out.println(upe.toString());
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
                
        	btnCancel.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		Id.setText("");
        		Difficulty.setText("");
        		Time.setText("");
        		Content.setText("");
        		Answer.setText("");
        		Score.setText("");
        		Type.setText("");
        		btnUpdate.setEnabled(false);
        		
        		}
        	});

    }
}
