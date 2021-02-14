package com.baseball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame extends JFrame implements ActionListener{
	//�����
	//���Ͱ� ä���� ���� 3���� ���� �迭�� �����ϱ�
	int com[] = new int[3];//���� 3���濡�� 0�� ��� �ִ�.
	//����ڰ� �Է��� ���ڸ� ���� �迭�� ���� ��������.
	int my[] = new int[3];
	//jf�� ���������̰� ���� �� �ʱ�ȭ �Ϸ�
	//jp_center������ �߾Ӹ��� - jta_display
	//jp_center������ ���ʸ��� - jtf_user
	//jta_display->jp_center����->JFrame��ġ
	//Jp_center������ ���̾ƿ��� BorderLayout����
	JPanel    jp_center 	= new JPanel();
	JTextArea  jta_display  = new JTextArea();
	//JScrollBar���� JTextArea ���
	JScrollPane jsp_display  = 
			new JScrollPane(jta_display
        				   ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
					       ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
					       );
	JTextField jtf_user     = new JTextField();
	//jp_east������ ��ư �װ� �߰� -new GridLayout(4,1);
	JPanel     jp_east 	    = new JPanel();
	JButton   jbtn_new      = new JButton("������");
	JButton   jbtn_dap      = new JButton("����");
	JButton   jbtn_clear    = new JButton("�����");
	JButton   jbtn_exit     = new JButton("������");
	//��ȸ���� ���� ���� ����
	int count = 0;
	//������ �����ϱ�
	public BaseBallGame() {
		ranCom();
		initDisplay();		
	}
	//�������� ������ �� ������ ���ڸ� ä���ϴ� �޼ҵ� ������ ����.
	public void ranCom() {
		Random r = new Random();
		com[0] = r.nextInt(10);//0~9
		
		do {
			com[1] = r.nextInt(10);
		}while(com[0]==com[1]);
		
		do {
			com[2] = r.nextInt(10);
		}while((com[0]==com[2]) || (com[1]==com[2]));
	}////////////////end of ranCom/////////////////
	
	//ȭ��ó����
	public void initDisplay() {
		//�̺�Ʈ �ҽ��� �̺�Ʈó���� ����ϴ� Ŭ���� ����
		jtf_user.addActionListener(this);
		jbtn_new.addActionListener(this);
		jbtn_dap.addActionListener(this);
		jbtn_clear.addActionListener(this);
		jbtn_exit.addActionListener(this);
		//��ư�� ������ ���ڻ�����
		jbtn_new.setBackground(new Color(158,9,9));
		jbtn_new.setForeground(new Color(212,212,212));
		jbtn_dap.setBackground(new Color(19,99,57));
		jbtn_dap.setForeground(new Color(212,212,212));
		jbtn_clear.setBackground(new Color(7,84,170));
		jbtn_clear.setForeground(new Color(212,212,212));
		jbtn_exit.setBackground(new Color(54,54,54));
		jbtn_exit.setForeground(new Color(212,212,212));
		jp_center.setBackground(Color.orange);
		jp_east.setBackground(Color.black);
		int width=400;//�������� - �޼ҵ� �ȿ� �������� ��
		int height=200;
		String title = "�߱����ڰ��� - Ver1.0";
		//������ ���̾ƿ��� BorderLayout���� ����
		jp_center.setLayout(new BorderLayout());
		//jp_east���� ���̾ƿ��� GridLayout���� ����
		jp_east.setLayout(new GridLayout(4,1));
		//jp_center �߾ӿ� ��ġ��
		jp_center.add("Center",jsp_display);
		jta_display.setBackground(new Color(255,255,200));
		jtf_user.setBackground(new Color(255,255,200));
		jp_center.add("South",jtf_user);
		//JFrame�߾ӿ� jp_center���� ���̰� ���ʿ��� jp_east���� ������
		this.add("Center",jp_center);
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		this.add("East",jp_east);
		this.setTitle(title);
		this.setSize(width, height);
		this.setVisible(true);
	}
	//�����ϴ� �޼ҵ�
	/****************************************************************
	 * 
	 * @param user - ����ڰ� �Է��� ���ڸ� ���� ����
	 * @return - ����ڰ� �Է��� ���ڿ� ä���� ���ڸ� ���ؼ� ��Ʈ���� ��ȯ
	 ***************************************************************/
	public String account(String user) {
		//�Ķ���ͷ� ���ο� ���ڸ� �޾ƿö� ���� ��ī��Ʈ�� �ٽ� �ؾ� �Ѵ�.
		//�� ����ڰ� �Է��� ���� ����ڰ�  JTextField�� ���ڸ� �Է��� �� ���͸� ���� ��
		//account("256")�� ȣ���ؾ� ���� ������?
		int strike = 0;//���ڸ� ������ �� �ڸ��� �°� ���ڵ� �°�
		int ball = 0;//���ڴ� �°� �ڸ��� Ʋ���� ��
		int temp = 0;//���ڿ� 256�� ���� Ÿ������ ����ȯ�Ͽ� ���� ���� ����
		try {
			temp = Integer.parseInt(user);
		} catch (NumberFormatException e) {
			return "���ڸ� �Է��ض�~~~~";
		}
		my[0] = temp/100;//256-> 2
		my[1] = (temp%100)/10;//56/10=5.6 5�� ���´�.
		my[2] = temp%10;//25.6 ->6
		//����ڰ� �Է��� ���ڰ� 256���ڿ��� �Ѿ� ���ϱ�....my�迭�� �ٽ� ����־�� �Ѵ�.
		//insert here- my�迭�� �ʱ�ȭ����
		//���� �ڸ� user/100=2
		//���� �ڸ� (256%100)/10=5
		//���� �ڸ� 256%10=6
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				//�ʰ� �Է��� ���ڰ� com�ȿ� �ִ�? �� - ��
				if(com[i]==my[j]) {
					if(i==j) {//Ȥ�� �ڸ����� �Ȱ��� �ž�? �� ��Ʈ����ũ �ƴ� ������
						strike++;
					}/////end of ��Ʈ����ũ
					else {
						ball++;
					}/////end of  ������
				}
			}////////////end of inner for
		}////////////////end of outter for
		if(strike==3) {
			return "�����Դϴ�. �����մϴ�.^^";
		}
		return strike+"��"+ball+"��";
	}
	
	//���θ޼ҵ� - entry point - callback method
	public static void main(String[] args) {
		//insert here
		BaseBallGame bbGame = new BaseBallGame();
	}
	//�ݹ�޼ҵ��� �� - �����ڰ� ȣ���ϴ°��� �ƴ϶� �ý��ۿ��� �ڵ� ȣ��
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ �ҽ�(jtf_user)�� ���� �ּҹ����� �б�

		//�� ������ ���� �����ž�?
		if(obj == jbtn_dap) {
			jta_display.append(com[0]+""+com[1]+""+com[2]+"�Դϴ�.\n");
		}
		//�� ����ģ�Ŵ�?
		else if(obj==jtf_user) {
			//System.out.println("�����Ƴ�...");
			String userInput = jtf_user.getText();
			if(userInput.length()!=3) {
				JOptionPane.showMessageDialog(this, "���ڸ� ���ڸ� �Է��ϼ���.", "����", JOptionPane.ERROR_MESSAGE);
				jtf_user.setText("");
				return;//actionPerformed Ż��
			}
			jta_display.append(++count+". "+userInput+" : "+account(userInput)+"\n");
			jtf_user.setText("");
		}
		//������ �ҰŴ�?
		else if(obj==jbtn_new) {
			ranCom();
			jta_display.append(com[0]+""+com[1]+""+com[2]+"\n");
			count=0;
		}
		//�� ����� ��ư �����ž�?
		else if(obj==jbtn_clear) {
			jta_display.setText("");
		}
	}

}
