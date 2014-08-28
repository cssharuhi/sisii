package Controler.OnlienTest;

import javax.swing.*;
public class BasicExamationFrame extends JFrame{
	public JLabel lbId;
	public JTextArea txtContent;
	public BasicExamationFrame()
	{
		lbId = new JLabel("ÌâÄ¿:");
		txtContent = new JTextArea();
		this.setLayout(null);
		add(lbId);
		lbId.setBounds(10, 20, 30,30 );
		txtContent.setSize(100, 200);
		add(txtContent);
		txtContent.setBounds(40,20,300 ,100 );
		this.setSize(400, 200);
		this.setVisible(true);
	}
	
}
