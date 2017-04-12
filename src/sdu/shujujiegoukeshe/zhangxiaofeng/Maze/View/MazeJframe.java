package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Creat.Creat;

public class MazeJframe extends JFrame {
	private JFrame Mazejf;
	private Container MazeCon;
	private Creat creat;
	private static PaintMaze paint;
	private static PaintMazeWay paintMazeWay;
	private ContrelJpanel contrelJpanel;
	private JTabbedPane jTabbedPane;
	
	public MazeJframe(int size) {
	// TODO Auto-generated constructor stub
		//创建迷宫欢迎窗口
		Mazejf=new JFrame("迷宫");
		//创建容器
		MazeCon=Mazejf.getContentPane();
		//创建并且初始化迷宫
		creat=new Creat(size);
		//寻找迷宫路经
		creat.FindWay();
		//创建并且初始化迷宫绘制
		paint=new PaintMaze(creat.GetSize(),creat.GetMaze(),creat.GetMazeWay());
		paintMazeWay=new PaintMazeWay(creat.GetSize(),creat.GetMaze(),creat.GetMazeWay());
		jTabbedPane=new JTabbedPane();
		jTabbedPane.addTab("游戏",null,paint,null);  
	    jTabbedPane.addTab("通路",null,paintMazeWay,null); 
		//创建并且初始化迷宫控制面板
		contrelJpanel=new ContrelJpanel("重新开始",Mazejf,"结束游戏");
		//设置布局管理器，边界布局
		MazeCon.setLayout(new BorderLayout());
		MazeCon.add(jTabbedPane,BorderLayout.CENTER);
		MazeCon.add(contrelJpanel, BorderLayout.SOUTH);
		//设置窗口大小，居中显示，大小不可调，关闭方式
		Mazejf.setSize(900, 1000);
		Mazejf.setResizable(false);
		Mazejf.setVisible(true);
		Mazejf.setLocationRelativeTo(null);
		Mazejf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
