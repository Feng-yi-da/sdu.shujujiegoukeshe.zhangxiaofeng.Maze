package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;
//迷宫游戏存放控制游戏开始，重玩，结束按钮的jpannel类
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Main.Main;

public class ContrelJpanel extends JPanel{
	//创建开始按钮
	private StartButton startButton;
	//创建结束按钮
	private EndButtton endButtton ;
	 public ContrelJpanel(String Startname,JFrame CloseJframe,String Endname) {
		// TODO Auto-generated constructor stub
		 //设置流动布局
		 this.setPreferredSize(new Dimension(1300,40));
		  setLayout(new FlowLayout(1, 60, 10));
		  //初始化按钮
		  startButton=new StartButton(Startname, CloseJframe);
		  endButtton=new EndButtton(Endname);
		  //添加按钮
		  add(startButton);
		  add(endButtton);
	  } 
}
