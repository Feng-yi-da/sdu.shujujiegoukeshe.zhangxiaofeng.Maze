package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Creat;

import java.util.Random;

import sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Creat.Dengjialei;


public class Creat {
	//迷宫 room数目：n*n，改变迷宫大小可直接更改此数值n范围2-43
		 private int n;
		 
		 //private boolean SizeOut=false;
		
		//储存迷宫信息的数组room，wall；
		 private int Maze[][];

		//电路布线法储存迷宫路径的过渡
		 private int MazeWay[];
		
		// 走出迷宫的路径
		private int Way[];
		
		private Dengjialei dengjia;
		
		private Random randomroom;
		private Random randomwall;
	public Creat(int Mazesize){

		//赋予n值
		n=Mazesize;
		Maze=new int[n*n+1][4+1];
		MazeWay=new int [n*n+1];
		
		//初始化迷宫，确定迷宫边界以及wall的状态
		
		//wall：1上墙；2右墙；3下墙；4左墙
		//wall状态:-1不可拆（迷宫围墙）；0通路(无墙)；1不通（可拆）
		for(int i=1;i<n*n+1;i++){
		 
		 //初始化所有墙均堵塞并且可拆
		 for(int j=1;j<=4;j++){
			 Maze[i][j]=1;
		 }
		 
		 //初始化特殊墙
		 //迷宫上界，墙不可拆
		if(i<=n){
			Maze[i][1]=-1;
		}
		
		//迷宫右界，墙不可拆
		if(i%n==0){
			Maze[i][2]=-1;
		}
		
		//迷宫下界，墙不可拆
		if(n*n-i<n){
			Maze[i][3]=-1;
		}
		
		//迷宫左界，墙不可拆
		if(i%n==1){
			Maze[i][4]=-1;
		}
	 }
		
		//不相交集定义  
        dengjia=new Dengjialei(n*n+1);
        //随机生成迷宫格的编号
        randomroom=new Random();
        //随机生成迷宫格墙的编号
        randomwall=new Random(); 
        while(dengjia.find(1)!=dengjia.find(n*n)){
        	
        	//随机选取迷宫格的编号1-n*n
       	 	int room=randomroom.nextInt(n*n)+1;
       	 	
       	 	//随机选取墙的编号1-4
       	 	int wall=randomwall.nextInt(4)+1;
       	 	//如果选中的墙不可拆或者已经通路继续选择墙的编号
       	 	while(Maze[room][wall]==-1){
       		 	wall=randomwall.nextInt(4)+1;
       	 	}
       	 	
       	 	//确定墙另一面的迷宫格编号以及
       	 	//以及墙在另一面的迷宫格对应的编号
       	 	int nextroom;
       	 	int nextroomwall;
       	 	switch (wall) {
       	 		case 1:
       	 			nextroom=room-n;
       	 			nextroomwall=3;
					break;
       	 		case 2:
       	 			nextroom=room+1;
       	 			nextroomwall=4;
       	 			break;
       	 		case 3:
       	 			nextroom=room+n;
       	 			nextroomwall=1;
				break;
       	 		case 4:
       	 			nextroom=room-1;
       	 			nextroomwall=2;
       	 			break;
       	 		default:
       	 			nextroom=room;
       	 			nextroomwall=wall;
       	 			break;
       	 		}
       	 	
       	 	//判断room与nextroom是否连通（等价）；
       	 	if(dengjia.find(room)==dengjia.find(nextroom)){
       	 		//连通，则重新选取迷宫格编号；
       	 		continue; 
       	 	}
       	 	else{
       	 		
       	 		//不连通，合并room与nextroom的集合；
       	 		int dengjiaroom=dengjia.find(room);
       	 		int dengjianextroom=dengjia.find(nextroom);
       	 		dengjia.union(dengjiaroom, dengjianextroom);
       	 		
       	 		//拆墙;     		 
         		//更改Maze[room][wall]与a[nextroom][nextroomwall]状态，变为通路；
       	 		Maze[room][wall]=0;
       	 		Maze[nextroom][nextroomwall]=0;
       	 	}
       	 	
        }
  
	}
	
	//获得Room的wall的状态
	public int Wall(int Room,int Wall){
			Wall=Maze[Room][Wall];
			return Wall;
	}
	
	
	//寻找迷宫路径
	public void FindWay(){
		MazeWay[1]=1;
		//电路布线方法
		//把初始位置赋值为0，0相邻位置查找没有赋值且与0位置直接连通的位置赋值为1；
		//重复执行操作直至n*n位置被赋值
		//开始寻找
		for(int i=1;i<n*n;i++){
			//n*n位置被赋值时停止查找操作
			if(MazeWay[n*n]==0)
			for(int j=1;j<=n*n;j++){
				if(MazeWay[j]==i)
				for(int k=1;k<=4;k++){
					int FindWall=Wall(j, k);
					if(FindWall==0)
					switch (k) {
					case 1:
						if(MazeWay[j-n]==0){
							MazeWay[j-n]=MazeWay[j]+1;
							}
						break;
					case 2:
						if(MazeWay[j+1]==0){
							MazeWay[j+1]=MazeWay[j]+1;
							}
						break;
					case 3:
						if(MazeWay[j+n]==0){
							MazeWay[j+n]=MazeWay[j]+1;
							}
						break;
					case 4:
						if(MazeWay[j-1]==0){
							MazeWay[j-1]=MazeWay[j]+1;
							}
						break;
					default:
						break;
					}
						
				}
					
			}
				
		}

			
		//回头寻找路径并记录在way[]中	
		int a=MazeWay[n*n];
		Way=new int[a+1];
		Way[1]=1;
		int b=n*n;
		for(int i=a;i>=1;i--)
			if(MazeWay[b]==i)
			for(int j=1;j<=4;j++){
				int FindWall=Wall(b, j);
				if(FindWall==0)
				switch (j) {
				case 1:
					if(MazeWay[b-n]==i-1){
						Way[i]=b;
						b=b-n;
						}
					break;
				case 2:
					if(MazeWay[b+1]==i-1){
						Way[i]=b;
						b=b+1;
						}
					break;
				case 3:
					if(MazeWay[b+n]==i-1){
						Way[i]=b;
						b=b+n;
						}
					break;
				case 4:
					if(MazeWay[b-1]==i-1){
						Way[i]=b;
						b=b-1;
						}
					break;

				default:
					break;
				}	
			}	 
	}
	
	//获取迷宫大小
	public int GetSize() {
		return n;
		
	}
	
	//获取迷宫 生成信息
	public int[][] GetMaze() {
		return Maze;
	}
	
	
	// 获取迷宫路径
	public int[]GetMazeWay(){
		return Way;
	}
	
}
