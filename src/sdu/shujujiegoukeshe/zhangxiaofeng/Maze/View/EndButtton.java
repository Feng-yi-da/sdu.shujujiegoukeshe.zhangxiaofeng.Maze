package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//创建关闭按钮
//点击按钮退出整个程序
//能为按钮命名
public class EndButtton extends Button {

	public EndButtton(String ButtonName) {
		// TODO Auto-generated constructor stub
		//为按钮命名
		setLabel(ButtonName);
		//为按钮添加事件
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
