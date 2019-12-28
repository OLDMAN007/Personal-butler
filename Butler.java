package personalButler;

import java.io.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Butler {
	public static void main(String args[]) {
		new Welcome("welcome");
	}
}


class Welcome extends JFrame{
	JButton land=new JButton("��¼");
	Box box1,box2,box;       //������������
	Welcome(String s){
		setTitle(s);          //��Ӵ��ڱ�ǩ
		box1=Box.createHorizontalBox();
		box1.add(new JLabel("���ã���ӭʹ�ø���С�ܼң�"));
		box2=Box.createVerticalBox(); 
		box2.add(land);
		box=Box.createVerticalBox(); 
		box.add(box1);
		box.add(Box.createVerticalStrut(100));       //���봹ֱ֧��
		box.add(box2);
		setLayout(new FlowLayout());
		add(box);        //�������                                                                                                                    
		PolicStation1 police=new PolicStation1();               
		land.addActionListener(police);              //��������� 
		validate();
		setVisible(true);
		setBounds(600,300,500,300);          //���ô��ڵ�λ�úʹ�С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //�˳�����
	}
}

class PolicStation1 implements ActionListener{         //�ӿ�
	public void actionPerformed(ActionEvent e){
		new Function("����ѡ��");                    //��ת������ѡ�����
	}
}


class Function extends JFrame{                   //����ѡ�񴰿�
	PolicStation2 polic2=new PolicStation2();	
	PolicStation3 polic3=new PolicStation3();
	PolicStation4 polic4=new PolicStation4();		//����������
	JButton shouru=new JButton("�������");
	JButton zhichu=new JButton("֧������");
	JButton zijin=new JButton("�����ʽ����");
	Box box;
	Function(String s){
		setTitle(s);
		box=Box.createVerticalBox();
		box.add(shouru);
		box.add(Box.createVerticalStrut(20));         //��ֱ֧��
		box.add(zhichu);
		box.add(Box.createVerticalStrut(20));
		box.add(zijin);
		setLayout(new FlowLayout());				//Flow����
		add(box);                             //�����ʽ����
		shouru.addActionListener(polic2);
		zhichu.addActionListener(polic3);       
		zijin.addActionListener(polic4);         //������
		validate();
		setVisible(true);           //���ڿɼ�
		setBounds(700,300,400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        //�ͷŴ���
	}
}

class PolicStation2 implements ActionListener{
	public void actionPerformed(ActionEvent e){				//����������ת����
		new Shouru("�������");
	} 
}


class Shouru extends JFrame {					//�������
	JTextField text1=new JTextField(10);
	JTextField text2=new JTextField(10);
	JButton save=new JButton("����");
	Shouru(String s){
		setTitle(s);
		Box box0,box1,box2,box3,box;
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createVerticalBox();
		box=Box.createHorizontalBox();				//��ʼ��box
		box1.add(new JLabel("�����빤������"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("�������������"));
		box2.add(text1);
		box2.add(Box.createVerticalStrut(10));			//��ֱ֧��
		box2.add(text2);
		box3.add(save);
		box.add(box1);
		box.add(Box.createHorizontalStrut(20));			//ˮƽ֧��
		box.add(box2);
		box.add(Box.createHorizontalStrut(20));
		box.add(box3);
		setLayout(new FlowLayout());     			//ʹ��Flow����
		add(box);								//�����ʽ����
		save.addActionListener(new ActionListener() {				//save����������������
			public void actionPerformed(ActionEvent e) {
				try {
					String a1=text1.getText();			//��ȡ�û����������
					String a2=text2.getText();
					FileReader in1 =new FileReader("data.txt");				//�ļ��ַ���
					BufferedReader in2=new BufferedReader(in1);			//������
					String str=in2.readLine();
					in1.close();						//��ʱ�ر��ļ��ַ���
					in2.close();					//�رջ�����
					FileWriter out1 =new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1); 
					if(str==null) str="0";
					
					int a3=Integer.parseInt(a1)+Integer.parseInt(a2)+Integer.parseInt(str);		//��Stringת����intȻ�����
					String a=String.valueOf(a3);			//intת����String��
					out2.write(a);				//��������
					out2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		setVisible(true);
		setBounds(500, 300, 500, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}

class PolicStation3 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Zhichu("֧������");
	}
}

class Zhichu extends JFrame{				//֧������
	JTextField text1=new JTextField(10);
	JTextField text2=new JTextField(10);
	JTextField text3=new JTextField(10);
	JButton save=new JButton("����");
	Zhichu(String s){
		setTitle(s);
		Box box1,box2,box3,box;					//ʹ�ú�ʽ����
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createVerticalBox();
		box=Box.createHorizontalBox();
		box1.add(new JLabel("�ճ���������"));
		box1.add(Box.createVerticalStrut(10));			//��ֱ֧��
		box1.add(new JLabel("����̶��ʲ�"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("Ͷ��"));				//�����ǩ
		box2.add(text1);
		box2.add(Box.createVerticalStrut(10));
		box2.add(text2);
		box2.add(Box.createVerticalStrut(10));
		box2.add(text3);
		box3.add(save);
		box.add(box1);
		box.add(Box.createHorizontalStrut(20));				//ˮƽ֧��
		box.add(box2);
		box.add(Box.createHorizontalStrut(20));
		box.add(box3);										//���ӵ�Ƕ��
		setLayout(new FlowLayout());
		add(box);
		save.addActionListener(new ActionListener() {			//��ť�ļ�����
			public void actionPerformed(ActionEvent e) {
				try {	
					String b1=text1.getText();
					String b2=text2.getText();
					String b3=text3.getText();
					FileReader in1=new FileReader("data.txt");
					BufferedReader in2=new BufferedReader(in1);			//������
					String str=in2.readLine();					//���ж�ȡԭ�ļ�����
					in1.close();
					in2.close();
					FileWriter out1=new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1);
					int b4=Integer.parseInt(str)-Integer.parseInt(b1)-Integer.parseInt(b2)-Integer.parseInt(b3);
					String b=String.valueOf(b4);   			//ԭʼ���ݼ�ȥ�û��������ݣ��Լ���������ת��
					out2.write(b);
					out2.close();
					
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
			});
		setVisible(true);
		setBounds(500, 300, 500, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}

class PolicStation4 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Money("�����ʽ����");
	}
}

class Money extends JFrame{					//�����ʽ����
	JButton Zeng=new JButton("�����ʽ���Ϣ");
	JButton Shan=new JButton("ɾ���ʽ���Ϣ");
	JButton Gai=new JButton("�޸��ʽ���Ϣ");
	JButton Cha=new JButton("�����ʽ���Ϣ");
	JButton Tongji=new JButton("ͳ�Ʒ���");				//���ù���ѡ�ť
	Money(String s){
		Box box;						//���ú���
		setTitle(s); 
		box=Box.createVerticalBox();
		box.add(Zeng);
		box.add(Box.createVerticalStrut(20));
		box.add(Shan);
		box.add(Box.createVerticalStrut(20));           //���밴ť�ʹ�ֱ֧��
		box.add(Gai);
		box.add(Box.createVerticalStrut(20));
		box.add(Cha);
		box.add(Box.createVerticalStrut(20));
		box.add(Tongji);
		setLayout(new FlowLayout());				//Flow����
		add(box);							//�����ʽ����
		PolicStation5 police5=new PolicStation5();
		Zeng.addActionListener(police5);
		PolicStation6 police6=new PolicStation6();
		Shan.addActionListener(police6);
		PolicStation7 police7=new PolicStation7();
		Gai.addActionListener(police7);
		PolicStation8 police8=new PolicStation8();
		Cha.addActionListener(police8);
		PolicStation9 police9=new PolicStation9();				//���ÿ����ť�ļ����
		Tongji.addActionListener(police9);
		setVisible(true);
		setBounds(500, 300, 400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}	
}

class PolicStation5 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Zeng("�����ʽ���Ϣ");
	}
}

class Zeng extends JFrame{				//�����ʽ���Ϣ����
	Zeng(String s){
		setTitle(s);
		Box box1,box2,box3,box4,box;
		JButton save=new JButton("ȷ��");
		JTextField text=new JTextField(10);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createVerticalBox();
		box=Box.createVerticalBox();
		box1.add(new JLabel("��������Ҫ���ӽ��"));			//�����ǩ
		box2.add(text);
		box2.add(Box.createVerticalStrut(10));
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(box2);
		box4.add(save);
		box.add(box3);
		box.add(Box.createVerticalStrut(20));
		box.add(box4);
		setLayout(new FlowLayout());
		add(box);
		save.addActionListener(new ActionListener() {				//save��ť�Ӽ����
			public void actionPerformed(ActionEvent e) {
				try {
					String a1=text.getText();
					FileReader in1 =new FileReader("data.txt");
					BufferedReader in2=new BufferedReader(in1);				//
					String str=in2.readLine();				//���ж�ȡ����
					in1.close();
					in2.close();
					FileWriter out1 =new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1); 
					if(str==null) str="0";
					int a3=Integer.parseInt(a1)+Integer.parseInt(str);		//��ԭ�������û�����������ӣ�
					String a=String.valueOf(a3);					//��������ת��
					out2.write(a);
					out2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);				//�쳣�ദ��
				}
			}
		});
		setVisible(true);
		setBounds(500, 200, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}
	
class PolicStation6 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Shan("ɾ���ʽ���Ϣ");
	}
}

class Shan extends JFrame{					//ɾ���ʽ���Ϣ����
	Shan(String s){
		setTitle(s);
		Box box1,box2,box3,box4,box;
		JButton save=new JButton("ȷ��");
		JTextField text=new JTextField(10);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createVerticalBox();
		box=Box.createVerticalBox();
		box1.add(new JLabel("��������Ҫɾ�����"));
		box2.add(text);
		box2.add(Box.createVerticalStrut(10));
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(box2);
		box4.add(save);
		box.add(box3);							//���ӵ�Ƕ��
		box.add(Box.createVerticalStrut(20));			//Ƕ��ʱ���봹ֱ֧��
		box.add(box4);							
		setLayout(new FlowLayout());
		add(box);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {									//�쳣��
					String a1=text.getText();
					FileReader in1 =new FileReader("data.txt");
					BufferedReader in2=new BufferedReader(in1);
					String str=in2.readLine();
					in1.close();
					in2.close();
					FileWriter out1 =new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1); 
					if(str==null) str="0";
					int a3=Integer.parseInt(str)-Integer.parseInt(a1);
					String a=String.valueOf(a3);
					out2.write(a);
					out2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		setVisible(true);
		setBounds(500, 200, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}

class PolicStation7 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Gai("�޸��ʽ���Ϣ");
	}
}

class Gai extends JFrame{				//�޸��ʽ���Ϣ����
	Gai(String s){
		setTitle(s);
		Box box1,box2,box3,box4,box;
		JButton save=new JButton("ȷ��");
		JTextField text=new JTextField(10);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createVerticalBox();
		box=Box.createVerticalBox();
		box1.add(new JLabel("���������µ��ʽ���Ϣ"));
		box2.add(text);
		box2.add(Box.createVerticalStrut(10));
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(box2);
		box4.add(save);
		box.add(box3);
		box.add(Box.createVerticalStrut(20));
		box.add(box4);
		setLayout(new FlowLayout());
		add(box);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a1=text.getText();
					FileWriter out1 =new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1); 
					out2.write(a1);
					out2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		setVisible(true);
		setBounds(500, 200, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}

class PolicStation8 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Cha("��ѯ�ʽ���Ϣ");
	}
}

class Cha extends JFrame{				//�����ʽ���Ϣ����
	Cha(String s){
		setTitle(s);
		Box box1,box2,box;
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box=Box.createVerticalBox();
		box2.add(new JLabel("��ǰ�ʽ����Ϊ"));
		try {
			FileReader in1 =new FileReader("data.txt");
			BufferedReader in2=new BufferedReader(in1);
			String str=in2.readLine();
			in1.close();
			in2.close();
			box2.add(new JLabel(str));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		box.add(box1);
		box.add(Box.createVerticalStrut(30));
		box.add(box2);
		setLayout(new FlowLayout());
		add(box);
		setVisible(true);
		setBounds(500, 200, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}

class PolicStation9 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Tongji("ͳ���ʽ���Ϣ");
	}
}

class Tongji extends JFrame{               //ͳ���ʽ���Ϣ����
	Tongji(String s){
		setTitle(s);
		Box box1,box2,box;
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box=Box.createVerticalBox();
		box2.add(new JLabel("��ǰ�ʽ����Ϊ"));
		try {
			FileReader in1 =new FileReader("data.txt");
			BufferedReader in2=new BufferedReader(in1);
			String str=in2.readLine();
			in1.close();
			in2.close();
			box2.add(new JLabel(str));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		box.add(box1);
		box.add(Box.createVerticalStrut(30));
		box.add(box2);
		setLayout(new FlowLayout());
		add(box);
		setVisible(true);
		setBounds(500, 200, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //�ͷŴ���
	}
}
