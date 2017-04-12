package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintMaze extends JPanel {
	
	
	private static final long serialVersionUID = 1;
	
	//迷宫room数:Room*Room
	private int Room;
	
	//迷宫信息
	private int Maze[][];
	
	//迷宫路径
	private int MazeWay[];
	
	//迷宫格宽度
	private int MazeWidth=20;
	
	//迷宫正方形，大小
	private int MazeSize;
	//迷宫背景颜色
	Color MazeBackgroundColor=Color.blue;
	
	//迷宫墙的颜色
	Color MazeWallColor=Color.black;
	
	//迷宫离绘制区域边界距离:Mazed
	private int Mazed;
	public PaintMaze(int size,int maze[][],int mazeway[]){
		this.setBackground(MazeBackgroundColor);
		Room=size;
		Maze=maze;
		MazeWay=mazeway;
		MazeSize=MazeWidth*Room;
		Mazed=(900-MazeSize-10)/2;
	}
	

	//绘制迷宫
	public void paint (Graphics g){
		
		super.paint(g);
		
		//迷宫背景白色
		g.setColor(MazeBackgroundColor);
		
		//迷宫绘制区域
		g.fillRect(Mazed,Mazed , MazeSize, MazeSize);
		
		//迷宫墙黑色
		g.setColor(MazeWallColor);
		
		for(int i=0;i<Room;i++)
            for(int j=0;j<Room;j++)
                {
                  //画房间正方形:MazeWidth*MazeWidth
                  g.drawRect(MazeWidth*i+Mazed,MazeWidth*j+Mazed,MazeWidth,MazeWidth);
                }
		//迷宫去墙用背景色(MazeBackgroundColor)覆盖原来的墙的颜色(MazeWallColor)已达到去墙的目的
		g.setColor(MazeBackgroundColor);
		//迷宫的出、入口
		//入口 
		//上墙
		g.drawLine(Mazed,Mazed,MazeWidth*(1)+Mazed-1,Mazed);
		//左墙
      	g.drawLine(Mazed,Mazed,Mazed,MazeWidth*(1)+Mazed-1);
      	
      	g.setColor(MazeBackgroundColor);
      	//出口
      	//右墙
      	g.drawLine(MazeWidth*(Room)+Mazed,  MazeWidth*(Room-1)+Mazed+1,  MazeWidth*(Room)+Mazed,  MazeWidth*(Room)+Mazed);
      	//下墙
      	g.drawLine(MazeWidth*(Room-1)+Mazed+1,  MazeWidth*(Room)+Mazed,  MazeWidth*(Room)+Mazed,  MazeWidth*(Room)+Mazed);
      	 
      	for(int i=1;i<=Room*Room;i++){
      		for(int j=1;j<=4;j++){
      			
      			int x1=0,y1=0,x2=0,y2=0;
      			int wall=Maze[i][j];
      			
      			switch (j) {	
      			case 1:
      				//上墙;
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
      				//右墙
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
   					//下墙
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
   					//左墙
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
      	
      	
	}
	
	
	
	
}
