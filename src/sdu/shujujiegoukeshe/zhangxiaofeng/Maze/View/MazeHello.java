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
		//�����Թ���ӭ����
		mazehello=new JFrame("Hello");
		//�������
		MazeCon=mazehello.getContentPane();
		//�������ҳ�ʼ���Թ��������
		contrelJpanel=new ContrelJpanel(" ��ʼ��Ϸ",mazehello,"������Ϸ");
		//�������ҳ�ʼ��ͼƬ
		icon =new ImageIcon("src/sdu/shujujiegoukeshe/zhangxiaofeng/Maze/View/�Թ�.jpg");
		//����ͼƬ��ǩ
		jLabel =new JLabel(icon);
		//���ò��ֹ��������߽粼��
		MazeCon.setLayout(new BorderLayout());
		//��������ӱ�ǩ�����
		MazeCon.add(jLabel, BorderLayout.CENTER);
		MazeCon.add(contrelJpanel, BorderLayout.SOUTH);
		//���ô��ڴ�С��������ʾ����С���ɵ����رշ�ʽ
		mazehello.setSize(900, 1000);
		mazehello.setResizable(false);
		mazehello.setVisible(true);
		mazehello.setLocationRelativeTo(null);
		mazehello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
