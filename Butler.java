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
	JButton land=new JButton("登录");
	Box box1,box2,box;       //设置三个盒子
	Welcome(String s){
		setTitle(s);          //添加窗口标签
		box1=Box.createHorizontalBox();
		box1.add(new JLabel("您好，欢迎使用个人小管家！"));
		box2=Box.createVerticalBox(); 
		box2.add(land);
		box=Box.createVerticalBox(); 
		box.add(box1);
		box.add(Box.createVerticalStrut(100));       //插入垂直支撑
		box.add(box2);
		setLayout(new FlowLayout());
		add(box);        //插入盒子                                                                                                                    
		PolicStation1 police=new PolicStation1();               
		land.addActionListener(police);              //插入监视器 
		validate();
		setVisible(true);
		setBounds(600,300,500,300);          //设置窗口的位置和大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //退出程序
	}
}

class PolicStation1 implements ActionListener{         //接口
	public void actionPerformed(ActionEvent e){
		new Function("功能选择");                    //跳转到功能选择界面
	}
}


class Function extends JFrame{                   //功能选择窗口
	PolicStation2 polic2=new PolicStation2();	
	PolicStation3 polic3=new PolicStation3();
	PolicStation4 polic4=new PolicStation4();		//创建监视器
	JButton shouru=new JButton("收入管理");
	JButton zhichu=new JButton("支出管理");
	JButton zijin=new JButton("个人资金管理");
	Box box;
	Function(String s){
		setTitle(s);
		box=Box.createVerticalBox();
		box.add(shouru);
		box.add(Box.createVerticalStrut(20));         //垂直支撑
		box.add(zhichu);
		box.add(Box.createVerticalStrut(20));
		box.add(zijin);
		setLayout(new FlowLayout());				//Flow布局
		add(box);                             //插入盒式布局
		shouru.addActionListener(polic2);
		zhichu.addActionListener(polic3);       
		zijin.addActionListener(polic4);         //监视器
		validate();
		setVisible(true);           //窗口可见
		setBounds(700,300,400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        //释放窗口
	}
}

class PolicStation2 implements ActionListener{
	public void actionPerformed(ActionEvent e){				//监视器，跳转窗口
		new Shouru("收入管理");
	} 
}


class Shouru extends JFrame {					//收入管理
	JTextField text1=new JTextField(10);
	JTextField text2=new JTextField(10);
	JButton save=new JButton("保存");
	Shouru(String s){
		setTitle(s);
		Box box0,box1,box2,box3,box;
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createVerticalBox();
		box=Box.createHorizontalBox();				//初始化box
		box1.add(new JLabel("请输入工资收入"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("请输入理财收入"));
		box2.add(text1);
		box2.add(Box.createVerticalStrut(10));			//垂直支撑
		box2.add(text2);
		box3.add(save);
		box.add(box1);
		box.add(Box.createHorizontalStrut(20));			//水平支撑
		box.add(box2);
		box.add(Box.createHorizontalStrut(20));
		box.add(box3);
		setLayout(new FlowLayout());     			//使用Flow布局
		add(box);								//插入盒式布局
		save.addActionListener(new ActionListener() {				//save监视器，保存数据
			public void actionPerformed(ActionEvent e) {
				try {
					String a1=text1.getText();			//获取用户输入的数据
					String a2=text2.getText();
					FileReader in1 =new FileReader("data.txt");				//文件字符流
					BufferedReader in2=new BufferedReader(in1);			//缓冲流
					String str=in2.readLine();
					in1.close();						//及时关闭文件字符流
					in2.close();					//关闭缓冲流
					FileWriter out1 =new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1); 
					if(str==null) str="0";
					
					int a3=Integer.parseInt(a1)+Integer.parseInt(a2)+Integer.parseInt(str);		//将String转化成int然后相加
					String a=String.valueOf(a3);			//int转化成String型
					out2.write(a);				//保存数据
					out2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		setVisible(true);
		setBounds(500, 300, 500, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}

class PolicStation3 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Zhichu("支出管理");
	}
}

class Zhichu extends JFrame{				//支出管理
	JTextField text1=new JTextField(10);
	JTextField text2=new JTextField(10);
	JTextField text3=new JTextField(10);
	JButton save=new JButton("保存");
	Zhichu(String s){
		setTitle(s);
		Box box1,box2,box3,box;					//使用盒式布局
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createVerticalBox();
		box=Box.createHorizontalBox();
		box1.add(new JLabel("日常生活消费"));
		box1.add(Box.createVerticalStrut(10));			//垂直支撑
		box1.add(new JLabel("购买固定资产"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("投资"));				//插入标签
		box2.add(text1);
		box2.add(Box.createVerticalStrut(10));
		box2.add(text2);
		box2.add(Box.createVerticalStrut(10));
		box2.add(text3);
		box3.add(save);
		box.add(box1);
		box.add(Box.createHorizontalStrut(20));				//水平支撑
		box.add(box2);
		box.add(Box.createHorizontalStrut(20));
		box.add(box3);										//盒子的嵌套
		setLayout(new FlowLayout());
		add(box);
		save.addActionListener(new ActionListener() {			//按钮的监视器
			public void actionPerformed(ActionEvent e) {
				try {	
					String b1=text1.getText();
					String b2=text2.getText();
					String b3=text3.getText();
					FileReader in1=new FileReader("data.txt");
					BufferedReader in2=new BufferedReader(in1);			//缓冲流
					String str=in2.readLine();					//按行读取原文件内容
					in1.close();
					in2.close();
					FileWriter out1=new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1);
					int b4=Integer.parseInt(str)-Integer.parseInt(b1)-Integer.parseInt(b2)-Integer.parseInt(b3);
					String b=String.valueOf(b4);   			//原始数据减去用户输入数据，以及数据类型转化
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}

class PolicStation4 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Money("个人资金管理");
	}
}

class Money extends JFrame{					//个人资金管理
	JButton Zeng=new JButton("增加资金信息");
	JButton Shan=new JButton("删除资金信息");
	JButton Gai=new JButton("修改资金信息");
	JButton Cha=new JButton("查找资金信息");
	JButton Tongji=new JButton("统计分析");				//设置功能选项按钮
	Money(String s){
		Box box;						//设置盒子
		setTitle(s); 
		box=Box.createVerticalBox();
		box.add(Zeng);
		box.add(Box.createVerticalStrut(20));
		box.add(Shan);
		box.add(Box.createVerticalStrut(20));           //插入按钮和垂直支撑
		box.add(Gai);
		box.add(Box.createVerticalStrut(20));
		box.add(Cha);
		box.add(Box.createVerticalStrut(20));
		box.add(Tongji);
		setLayout(new FlowLayout());				//Flow布局
		add(box);							//插入盒式布局
		PolicStation5 police5=new PolicStation5();
		Zeng.addActionListener(police5);
		PolicStation6 police6=new PolicStation6();
		Shan.addActionListener(police6);
		PolicStation7 police7=new PolicStation7();
		Gai.addActionListener(police7);
		PolicStation8 police8=new PolicStation8();
		Cha.addActionListener(police8);
		PolicStation9 police9=new PolicStation9();				//添加每个按钮的监控器
		Tongji.addActionListener(police9);
		setVisible(true);
		setBounds(500, 300, 400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}	
}

class PolicStation5 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Zeng("增加资金信息");
	}
}

class Zeng extends JFrame{				//增加资金信息窗口
	Zeng(String s){
		setTitle(s);
		Box box1,box2,box3,box4,box;
		JButton save=new JButton("确定");
		JTextField text=new JTextField(10);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createVerticalBox();
		box=Box.createVerticalBox();
		box1.add(new JLabel("请输入您要增加金额"));			//插入标签
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
		save.addActionListener(new ActionListener() {				//save按钮加监控器
			public void actionPerformed(ActionEvent e) {
				try {
					String a1=text.getText();
					FileReader in1 =new FileReader("data.txt");
					BufferedReader in2=new BufferedReader(in1);				//
					String str=in2.readLine();				//按行读取数据
					in1.close();
					in2.close();
					FileWriter out1 =new FileWriter("data.txt");
					BufferedWriter out2=new BufferedWriter(out1); 
					if(str==null) str="0";
					int a3=Integer.parseInt(a1)+Integer.parseInt(str);		//将原数据与用户输入数据相加，
					String a=String.valueOf(a3);					//数据类型转化
					out2.write(a);
					out2.close();
				}
				catch(Exception ex) {
					System.out.println(ex);				//异常类处理
				}
			}
		});
		setVisible(true);
		setBounds(500, 200, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}
	
class PolicStation6 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Shan("删除资金信息");
	}
}

class Shan extends JFrame{					//删除资金信息窗口
	Shan(String s){
		setTitle(s);
		Box box1,box2,box3,box4,box;
		JButton save=new JButton("确定");
		JTextField text=new JTextField(10);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createVerticalBox();
		box=Box.createVerticalBox();
		box1.add(new JLabel("请输入您要删除金额"));
		box2.add(text);
		box2.add(Box.createVerticalStrut(10));
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(box2);
		box4.add(save);
		box.add(box3);							//盒子的嵌套
		box.add(Box.createVerticalStrut(20));			//嵌套时加入垂直支撑
		box.add(box4);							
		setLayout(new FlowLayout());
		add(box);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {									//异常类
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}

class PolicStation7 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Gai("修改资金信息");
	}
}

class Gai extends JFrame{				//修改资金信息窗口
	Gai(String s){
		setTitle(s);
		Box box1,box2,box3,box4,box;
		JButton save=new JButton("确定");
		JTextField text=new JTextField(10);
		box1=Box.createVerticalBox();
		box2=Box.createVerticalBox();
		box3=Box.createHorizontalBox();
		box4=Box.createVerticalBox();
		box=Box.createVerticalBox();
		box1.add(new JLabel("请输入您新的资金信息"));
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}

class PolicStation8 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Cha("查询资金信息");
	}
}

class Cha extends JFrame{				//查找资金信息窗口
	Cha(String s){
		setTitle(s);
		Box box1,box2,box;
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box=Box.createVerticalBox();
		box2.add(new JLabel("当前资金余额为"));
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}

class PolicStation9 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		new Tongji("统计资金信息");
	}
}

class Tongji extends JFrame{               //统计资金信息窗口
	Tongji(String s){
		setTitle(s);
		Box box1,box2,box;
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box=Box.createVerticalBox();
		box2.add(new JLabel("当前资金余额为"));
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);     //释放窗口
	}
}
