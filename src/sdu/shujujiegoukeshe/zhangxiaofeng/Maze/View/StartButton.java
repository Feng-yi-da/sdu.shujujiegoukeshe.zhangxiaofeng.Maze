package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;
///////////////////////////////////////////////////
//����һ����ť
//�ܹ�Ϊ�ð�ť����
//�����ť�ܹ���������
//�ж������Ƿ�Ϸ�
//��������ִ��ݸ�MazeJframe
//���ֺϷ����ܹ������µ�MazeJframe���ڲ��ҹر�֮ǰ�Ĵ��ڣ���ɴ��ڵ�ˢ��
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StartButton extends Button{
	
	//��������
	private String InputString;
	//InputStringת��int����
	private int number;
	
	public StartButton (String ButtonName,JFrame CloseJframe) {
		//Ϊ��ť�������
		setLabel(ButtonName);
		//Ϊ��ť����¼�
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//�Ƿ�ˢ�½���
				boolean Refresh=true;
				//�ж�����ֵ�Ƿ�Ϊ����
				try {
					InputString=JOptionPane.showInputDialog(null,"","�������Թ���С",JOptionPane.PLAIN_MESSAGE);
					number=Integer.parseInt(InputString);
						} catch (Exception e1) {
					// TODO: handle exception
							JOptionPane.showMessageDialog(null, " ����������");
							Refresh=false;
				}
				//����������Ƿ���ָ����Χ��2-43
				if(Refresh){
					try {
						if(number<2||number>43)
							throw new Exception();
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "���뷶Χ2-43");
						Refresh=false;
					}
				}
				//�Ƿ�����ˢ�½����Ҫ��
				if(Refresh){
					MazeJframe mazeJframe=new MazeJframe(number);
					CloseJframe.dispose();
				}
			}
		});
		
	}
}
