package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MazeHello extends JFrame {
	private JFrame mazehello;
	private Container MazeCon;
	private ContrelJpanel contrelJpanel;
	private Icon icon;
	private JLabel jLabel ;
	public MazeHello(){
		//创建迷宫欢迎界面
		mazehello=new JFrame("Hello");
		//获得容器
		MazeCon=mazehello.getContentPane();
		//创建并且初始化迷宫控制面板
		contrelJpanel=new ContrelJpanel(" 开始游戏",mazehello,"结束游戏");
		//创建并且初始化图片
		icon =new ImageIcon("src/sdu/shujujiegoukeshe/zhangxiaofeng/Maze/View/迷宫.jpg");
		//创建图片标签
		jLabel =new JLabel(icon);
		//设置布局管理器，边界布局
		MazeCon.setLayout(new BorderLayout());
		//向容器添加标签或面板
		MazeCon.add(jLabel, BorderLayout.CENTER);
		MazeCon.add(contrelJpanel, BorderLayout.SOUTH);
		//设置窗口大小，居中显示，大小不可调，关闭方式
		mazehello.setSize(900, 1000);
		mazehello.setResizable(false);
		mazehello.setVisible(true);
		mazehello.setLocationRelativeTo(null);
		mazehello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
