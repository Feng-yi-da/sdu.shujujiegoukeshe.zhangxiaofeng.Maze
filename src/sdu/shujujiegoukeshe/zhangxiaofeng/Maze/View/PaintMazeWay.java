package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintMazeWay extends PaintMaze {
	
	
	private static final long serialVersionUID = 1;
	
	//�Թ�room��:Room*Room
	private int Room;
	
	//�Թ���Ϣ
	private int Maze[][];
	
	//�Թ�·��
	private int MazeWay[];
	
	//�Թ�����
	private int MazeWidth=20;
	
	//�Թ������Σ���С
	private int MazeSize;
	//�Թ�������ɫ
	private static Color MazeBackgroundColor=Color.green;
	
	//�Թ�ǽ����ɫ
	private Color MazeWallColor=Color.black;
	//�Թ����������߽����:Mazed
	private int Mazed;
	public PaintMazeWay(int size,int maze[][],int mazeway[]){
		super(size, maze, mazeway);
		this.setBackground(MazeBackgroundColor);
		Room=size;
		Maze=maze;
		MazeWay=mazeway;
		MazeSize=MazeWidth*Room;
		Mazed=(900-MazeSize-10)/2;
	}
	
	

	//�����Թ�
	public void paint (Graphics g){
		
		super.paint(g);
		
		//�Թ�������ɫ
		g.setColor(MazeBackgroundColor);
		
		//�Թ���������
		g.fillRect(Mazed,Mazed , MazeSize, MazeSize);
		
		//�Թ�ǽ��ɫ
		g.setColor(MazeWallColor);
		
		for(int i=0;i<Room;i++)
            for(int j=0;j<Room;j++)
                {
                  //������������:MazeWidth*MazeWidth
                  g.drawRect(MazeWidth*i+Mazed,MazeWidth*j+Mazed,MazeWidth,MazeWidth);
                }
		//�Թ�ȥǽ�ñ���ɫ(MazeBackgroundColor)����ԭ����ǽ����ɫ(MazeWallColor)�Ѵﵽȥǽ��Ŀ��
		g.setColor(MazeBackgroundColor);
		//�Թ��ĳ������
		//��� 
		//��ǽ
		g.drawLine(Mazed,Mazed,MazeWidth*(1)+Mazed-1,Mazed);
		//��ǽ
      	g.drawLine(Mazed,Mazed,Mazed,MazeWidth*(1)+Mazed-1);
      	
      	g.setColor(MazeBackgroundColor);
      	//����
      	//��ǽ
      	g.drawLine(MazeWidth*(Room)+Mazed,  MazeWidth*(Room-1)+Mazed+1,  MazeWidth*(Room)+Mazed,  MazeWidth*(Room)+Mazed);
      	//��ǽ
      	g.drawLine(MazeWidth*(Room-1)+Mazed+1,  MazeWidth*(Room)+Mazed,  MazeWidth*(Room)+Mazed,  MazeWidth*(Room)+Mazed);
      	 
      	for(int i=1;i<=Room*Room;i++){
      		for(int j=1;j<=4;j++){
      			
      			int x1=0,y1=0,x2=0,y2=0;
      			int wall=Maze[i][j];
      			
      			switch (j) {	
      			case 1:
      				//��ǽ;
      				if(wall==0){
      					
      					if(i%Room==0)
      						x1=MazeWidth*(Room-1)+Mazed+1;
      					else {
      						x1=MazeWidth*(i%Room-1)+Mazed+1;
      					}
      				
      					if(i%Room==0)
      						y1=MazeWidth*(i/Room-1)+Mazed;
      					else {
      						y1=MazeWidth*(i/Room)+Mazed;	
      					}
      				
      					x2=x1+MazeWidth-2;
					
      					y2=y1;
      				}
      				
   					break;
      			case 2:
      				//��ǽ
      				if(wall==0){
      					x1=MazeWidth*(i%Room)+Mazed;
					
      					if(i%Room==0)
      						y1=MazeWidth*(i/Room-1)+Mazed+1;
						else {
							y1=MazeWidth*(i/Room)+Mazed+1;	
						}
					
      					x2=x1;
					
      					y2=y1+MazeWidth-2;
      				}
   					break;
   				case 3:
   					//��ǽ
   					if(wall==0){
      					if(i%Room==0)
      						x1=MazeWidth*(Room-1)+Mazed+1;
      					else {
      						x1=MazeWidth*(i%Room-1)+Mazed+1;
      					}
					
      					if(i%Room==0)
      						y1=MazeWidth*(i/Room)+Mazed;
      					else {
      						y1=MazeWidth*(i/Room+1)+Mazed;	
						}
					
      					x2=x1+MazeWidth-2;
					
      					y2=y1;   					
      				}				
   					break;
   				case 4:
   					//��ǽ
   					if(wall==0){
      					if(i%Room==0)
      						x1=MazeWidth*(Room-1)+Mazed;
      					else {
      						x1=MazeWidth*(i%Room-1)+Mazed;
      					}
					
      					if(i%Room==0)
      						y1=MazeWidth*(i/Room-1)+Mazed+1;
						else {
							y1=MazeWidth*(i/Room)+Mazed+1;	
						}
					
      					x2=x1;
      					
      					y2=y1+MazeWidth-2;    					
   					}					
      				break;
      						
      			default:
      				break;
      					}
      			g.setColor(MazeBackgroundColor);
      			g.drawLine(x1, y1, x2, y2);
      		}
      		
      	}
      	//����·��
      	if(MazeWay!=null)
      	for(int i=1;i<=MazeWay.length-1;i++){ 
      		int a=MazeWay[i];
      		if(a>0){
      			int x,y;
  
  				if(a%Room==0)
  					x=MazeWidth*(Room-1)+Mazed+1+(MazeWidth/2);
  				else {
  					x=MazeWidth*(a%Room-1)+Mazed+1+(MazeWidth/2);
  				}
  				
  				if(a%Room==0)
  					y=MazeWidth*(a/Room-1)+Mazed+(MazeWidth/2);
  				else {
  					y=MazeWidth*(a/Room)+Mazed+(MazeWidth/2);	
  				}
  			//�õ㻭��·������ɫ��MazeWallColor��
      		g.setColor(MazeWallColor);
      		g.fillOval(x-2, y-2, 5, 5);
      		}
      		
      	}
      	
	}
	
	
}
