package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�����رհ�ť
//�����ť�˳���������
//��Ϊ��ť����
public class EndButtton extends Button {

	public EndButtton(String ButtonName) {
		// TODO Auto-generated constructor stub
		//Ϊ��ť����
		setLabel(ButtonName);
		//Ϊ��ť����¼�
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
