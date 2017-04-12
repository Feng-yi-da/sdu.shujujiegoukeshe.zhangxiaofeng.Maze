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
		//�����Թ���ӭ����
		Mazejf=new JFrame("�Թ�");
		//��������
		MazeCon=Mazejf.getContentPane();
		//�������ҳ�ʼ���Թ�
		creat=new Creat(size);
		//Ѱ���Թ�·��
		creat.FindWay();
		//�������ҳ�ʼ���Թ�����
		paint=new PaintMaze(creat.GetSize(),creat.GetMaze(),creat.GetMazeWay());
		paintMazeWay=new PaintMazeWay(creat.GetSize(),creat.GetMaze(),creat.GetMazeWay());
		jTabbedPane=new JTabbedPane();
		jTabbedPane.addTab("��Ϸ",null,paint,null);  
	    jTabbedPane.addTab("ͨ·",null,paintMazeWay,null); 
		//�������ҳ�ʼ���Թ��������
		contrelJpanel=new ContrelJpanel("���¿�ʼ",Mazejf,"������Ϸ");
		//���ò��ֹ��������߽粼��
		MazeCon.setLayout(new BorderLayout());
		MazeCon.add(jTabbedPane,BorderLayout.CENTER);
		MazeCon.add(contrelJpanel, BorderLayout.SOUTH);
		//���ô��ڴ�С��������ʾ����С���ɵ����رշ�ʽ
		Mazejf.setSize(900, 1000);
		Mazejf.setResizable(false);
		Mazejf.setVisible(true);
		Mazejf.setLocationRelativeTo(null);
		Mazejf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
