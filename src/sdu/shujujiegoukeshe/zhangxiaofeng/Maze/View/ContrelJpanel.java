package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;
//�Թ���Ϸ��ſ�����Ϸ��ʼ�����棬������ť��jpannel��
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
	//������ʼ��ť
	private StartButton startButton;
	//����������ť
	private EndButtton endButtton ;
	 public ContrelJpanel(String Startname,JFrame CloseJframe,String Endname) {
		// TODO Auto-generated constructor stub
		 //������������
		 this.setPreferredSize(new Dimension(1300,40));
		  setLayout(new FlowLayout(1, 60, 10));
		  //��ʼ����ť
		  startButton=new StartButton(Startname, CloseJframe);
		  endButtton=new EndButtton(Endname);
		  //��Ӱ�ť
		  add(startButton);
		  add(endButtton);
	  } 
}
