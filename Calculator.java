package calculator;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

public class Calculator extends JFrame implements ActionListener{
	int i;
	JTextField[] text = new JTextField[2];
	
	JButton[] numberButtons = new JButton[10];
	JButton[] Functions = {
			new JButton("+"),new JButton("-"),new JButton("×"),new JButton("÷")
			,new JButton("."),new JButton("="),new JButton("Clear"),new JButton("Delete")
			,new JButton("(-)"),new JButton("Ans")
			};
	
	Font myFont1 = new Font ("",Font.HANGING_BASELINE,35);
	Font myFont = new Font ("",Font.HANGING_BASELINE,24);
	Font myFont0 = new Font ("",Font.HANGING_BASELINE,25);
	
	JPanel myPanel = new JPanel();  		//grid butt
	JPanel myPanel2 = new JPanel(); 		// main componant (text,grid butt, cle,del,=)
	JPanel myPanel3 = new JPanel();  
	JPanel myPanel4 = new JPanel();
	JPanel myPanel5 = new JPanel();
	JPanel myPanel6 = new JPanel();
	JPanel myPanel7 = new JPanel(); 		//text
	JPanel myPanel8 = new JPanel(); 		//(cle,del,=)
	JPanel myPanel9 = new JPanel(); 		//(=)
	JPanel myPanel10 = new JPanel();		//(cle,del)
	
	public Calculator() throws IOException{
		super(" MK Calculator");
		
		myPanel.setBackground(Color.decode("#141414"));
		myPanel2.setBackground(Color.decode("#141414"));
		myPanel3.setBackground(Color.decode("#141414"));
		myPanel4.setBackground(Color.decode("#141414"));
		myPanel5.setBackground(Color.decode("#141414"));
		myPanel6.setBackground(Color.decode("#141414"));
		myPanel7.setBackground(Color.decode("#141414"));
		myPanel8.setBackground(Color.decode("#141414"));
		myPanel9.setBackground(Color.decode("#141414"));
		myPanel10.setBackground(Color.decode("#141414"));
		
	    this.setIconImage(new ImageIcon("D:/Study/Tasks/JAVA/calculator/src/calculator/calculator-icon1.png").getImage());
	    
		this.getContentPane().setBackground(Color.decode("#141414"));
		this.setMinimumSize(new Dimension(388, 500));
		this.setPreferredSize(new Dimension(410, 530));
        this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout(20,20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPanel2.setLayout(new BorderLayout(20,20));
		
		for(i=0;i<2;i++) {
			text[i] = new JTextField();
			text[i].setHorizontalAlignment(JTextField.RIGHT);
			text[i].setFont(myFont);
			//text[i].setBorder(null);
			text[i].setEditable(false);
			text[i].setBackground(Color.decode("#141414"));
			text[i].setForeground(Color.WHITE);
			text[i].setPreferredSize(new Dimension(50,50));
			text[i].setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 6));
		}
		text[1].setText("0");
		text[0].setFont(myFont0);
		text[1].setFont(myFont1);
		
		for (i=0;i<10;i++) {
			Functions[i].addActionListener(this);
			Functions[i].setFocusable(false);
			Functions[i].setFont(myFont);
			Functions[i].setBackground(Color.decode("#333333"));
			Functions[i].setForeground(Color.WHITE);
			Functions[i].setBorder(null);
		}
		
		for (i=0;i<10;i++) {
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setBorder(null);
			numberButtons[i].setBackground(Color.decode("#008080"));
			numberButtons[i].setForeground(Color.WHITE);
		}
		
		myPanel.setLayout(new GridLayout(4,4,10,10));
		 
		for(i=1;i<4;i++) myPanel.add(numberButtons[i]);
		myPanel.add(Functions[0]);//+
		
		for(i=4;i<7;i++) myPanel.add(numberButtons[i]);
		myPanel.add(Functions[1]);//-
		
		for(i=7;i<10;i++) myPanel.add(numberButtons[i]);
		myPanel.add(Functions[2]);//*
		
		myPanel.add(Functions[8]);//=
		myPanel.add(numberButtons[0]);
		myPanel.add(Functions[4]);//.
		myPanel.add(Functions[3]);// ÷
		
		myPanel8.setLayout(new BorderLayout(5,5));
		myPanel10.setLayout(new GridLayout(0,2,10,0));
		myPanel9.setLayout(new GridLayout(0,2,5,0));
		
		myPanel9.setPreferredSize(new Dimension(120,40));
		Functions[5].setPreferredSize(new Dimension(87,40));
		
		myPanel10.add(Functions[6]);
		myPanel10.add(Functions[7]);
		myPanel9.add(Functions[9]);
		myPanel9.add(Functions[5]);
		
		myPanel8.add(myPanel10,BorderLayout.CENTER);
		myPanel8.add(myPanel9,BorderLayout.EAST);
		
		myPanel7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		myPanel7.setLayout(new GridLayout(0,1));
		
		for(i=0;i<2;i++) myPanel7.add(text[i]);
		
		myPanel2.add(myPanel7,BorderLayout.NORTH);
		myPanel2.add(myPanel, BorderLayout.CENTER);
		myPanel2.add(myPanel8, BorderLayout.SOUTH);
		
		this.add(myPanel2,BorderLayout.CENTER);//main
		this.add(myPanel3,BorderLayout.NORTH);
		this.add(myPanel4,BorderLayout.SOUTH);
		this.add(myPanel5,BorderLayout.EAST);
		this.add(myPanel6,BorderLayout.WEST);
		Icon icon = new ImageIcon("D:/Study/Tasks/JAVA/calculator/src/calculator/calculator-");
		Functions[5].setIcon(icon);
		this.setVisible(true);
		
	}
	public static void main (String args[]) throws IOException {
		new Calculator();
	}
	
	float numb1=0,numb2=0; 
	float result=0;
	char op='c';
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(i=0;i<10;i++) {
			if (e.getSource()==numberButtons[i]) {
				text[1].setText(text[1].getText().concat(String.valueOf(i)));
				text[1].setText(String.valueOf(Integer.parseInt(text[1].getText())));
			}
		}
		if (e.getSource()==Functions[4]) { 
			text[1].setText(text[1].getText().concat("."));
			
		}
		//add
		else if (e.getSource()==Functions[0]) { 
			op='+';
			numb1=Float.parseFloat(text[1].getText());
			text[0].setText(text[1].getText()+" "+op+" ");
			text[1].setText("0");
		}
		//subtract
		else if (e.getSource()==Functions[1]) { 
			op='-';
			numb1=Float.parseFloat(text[1].getText());
			text[0].setText(text[1].getText()+" "+op+" ");
			text[1].setText("0");
		}
		//multpluie
		else if (e.getSource()==Functions[2]) { 
			op='×';
			numb1=Float.parseFloat(text[1].getText());
			text[0].setText(text[1].getText()+" "+op+" ");
			text[1].setText("0");
		}
		//divided
		else if (e.getSource()==Functions[3]) { 
			op='÷';
			numb1=Float.parseFloat(text[1].getText());
			text[0].setText(text[1].getText()+" "+op+" ");
			text[1].setText("0");
		}
		//=
		else if (e.getSource()==Functions[5]) { 
			numb2=Float.parseFloat(text[1].getText());
			//text[1].setText(text[1].getText());
			text[0].setText(text[0].getText().concat(text[1].getText()).concat(" = "));
			text[1].setText("");
			switch(op) {
				case'+': result = numb1+numb2 ;
				break;
				case'÷': result = numb1/numb2 ;
				break;
				case'×': result = numb1*numb2 ;
				break;
				case'-': result = numb1-numb2 ;
				break;
//				default: result = Float.parseFloat(text[0].getText());
			}
			
			int x = (int) (result);
			//intger 										note: (3.0 = 3)
			if (result==x) {
				text[1].setText(String.valueOf(x));
			}
			else {
				text[1].setText(String.valueOf(result));
			}
			numb1 = 0;
			numb2=result;
		}
		else if (e.getSource()==Functions[6]) {
			text[0].setText("");
			text[1].setText("0");
		}
		else if (e.getSource()==Functions[7]) {
			String St = text[1].getText();
			text[1].setText("");
			for(i=0;St.length()-1>i;i++) {
				text[1].setText(text[1].getText()+St.charAt(i));
			}
		}
		if (e.getSource()==Functions[8]) {
			float temp = Float.parseFloat(text[1].getText());
			temp*=-1;
			text[1].setText(String.valueOf(temp));
			
			int x = (int) temp;
			//intger 										note: (3.0 = 3)
			if (temp==x) {
				text[1].setText(String.valueOf(x));		//if it Integer input
			}
			else {
				text[1].setText(String.valueOf(temp)); //if it double input
			}
		} 
		else if (e.getSource()==Functions[9]) {
			int x = (int) result;
			//intger 										note: (3.0 = 3)
			if (result==x) {
				text[1].setText(String.valueOf((int)result));		//if it Integer input
			}
			else {
				text[1].setText(String.valueOf(result)); //if it double input
			}
			
		}
	}
}
