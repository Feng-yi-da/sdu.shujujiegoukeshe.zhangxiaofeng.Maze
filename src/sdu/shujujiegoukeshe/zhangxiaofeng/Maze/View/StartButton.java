package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;
///////////////////////////////////////////////////
//创建一个按钮
//能够为该按钮命名
//点击按钮能够输入数字
//判断输入是否合法
//输入的数字传递给MazeJframe
//数字合法后能够创建新的MazeJframe窗口并且关闭之前的窗口，完成窗口的刷新
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StartButton extends Button{
	
	//输入内容
	private String InputString;
	//InputString转化int类型
	private int number;
	
	public StartButton (String ButtonName,JFrame CloseJframe) {
		//为按钮添加名称
		setLabel(ButtonName);
		//为按钮添加事件
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//是否刷新界面
				boolean Refresh=true;
				//判断输入值是否为数字
				try {
					InputString=JOptionPane.showInputDialog(null,"","请输入迷宫大小",JOptionPane.PLAIN_MESSAGE);
					number=Integer.parseInt(InputString);
						} catch (Exception e1) {
					// TODO: handle exception
							JOptionPane.showMessageDialog(null, " 请输入数字");
							Refresh=false;
				}
				//输入的数字是否在指定范围内2-43
				if(Refresh){
					try {
						if(number<2||number>43)
							throw new Exception();
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "输入范围2-43");
						Refresh=false;
					}
				}
				//是否满足刷新界面的要求
				if(Refresh){
					MazeJframe mazeJframe=new MazeJframe(number);
					CloseJframe.dispose();
				}
			}
		});
		
	}
}
