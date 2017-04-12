package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Creat;

import java.util.Random;

import sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Creat.Dengjialei;


public class Creat {
	//�Թ� room��Ŀ��n*n���ı��Թ���С��ֱ�Ӹ��Ĵ���ֵn��Χ2-43
		 private int n;
		 
		 //private boolean SizeOut=false;
		
		//�����Թ���Ϣ������room��wall��
		 private int Maze[][];

		//��·���߷������Թ�·���Ĺ���
		 private int MazeWay[];
		
		// �߳��Թ���·��
		private int Way[];
		
		private Dengjialei dengjia;
		
		private Random randomroom;
		private Random randomwall;
	public Creat(int Mazesize){

		//����nֵ
		n=Mazesize;
		Maze=new int[n*n+1][4+1];
		MazeWay=new int [n*n+1];
		
		//��ʼ���Թ���ȷ���Թ��߽��Լ�wall��״̬
		
		//wall��1��ǽ��2��ǽ��3��ǽ��4��ǽ
		//wall״̬:-1���ɲ��Թ�Χǽ����0ͨ·(��ǽ)��1��ͨ���ɲ�
		for(int i=1;i<n*n+1;i++){
		 
		 //��ʼ������ǽ���������ҿɲ�
		 for(int j=1;j<=4;j++){
			 Maze[i][j]=1;
		 }
		 
		 //��ʼ������ǽ
		 //�Թ��Ͻ磬ǽ���ɲ�
		if(i<=n){
			Maze[i][1]=-1;
		}
		
		//�Թ��ҽ磬ǽ���ɲ�
		if(i%n==0){
			Maze[i][2]=-1;
		}
		
		//�Թ��½磬ǽ���ɲ�
		if(n*n-i<n){
			Maze[i][3]=-1;
		}
		
		//�Թ���磬ǽ���ɲ�
		if(i%n==1){
			Maze[i][4]=-1;
		}
	 }
		
		//���ཻ������  
        dengjia=new Dengjialei(n*n+1);
        //��������Թ���ı��
        randomroom=new Random();
        //��������Թ���ǽ�ı��
        randomwall=new Random(); 
        while(dengjia.find(1)!=dengjia.find(n*n)){
        	
        	//���ѡȡ�Թ���ı��1-n*n
       	 	int room=randomroom.nextInt(n*n)+1;
       	 	
       	 	//���ѡȡǽ�ı��1-4
       	 	int wall=randomwall.nextInt(4)+1;
       	 	//���ѡ�е�ǽ���ɲ�����Ѿ�ͨ·����ѡ��ǽ�ı��
       	 	while(Maze[room][wall]==-1){
       		 	wall=randomwall.nextInt(4)+1;
       	 	}
       	 	
       	 	//ȷ��ǽ��һ����Թ������Լ�
       	 	//�Լ�ǽ����һ����Թ����Ӧ�ı��
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
       	 	
       	 	//�ж�room��nextroom�Ƿ���ͨ���ȼۣ���
       	 	if(dengjia.find(room)==dengjia.find(nextroom)){
       	 		//��ͨ��������ѡȡ�Թ����ţ�
       	 		continue; 
       	 	}
       	 	else{
       	 		
       	 		//����ͨ���ϲ�room��nextroom�ļ��ϣ�
       	 		int dengjiaroom=dengjia.find(room);
       	 		int dengjianextroom=dengjia.find(nextroom);
       	 		dengjia.union(dengjiaroom, dengjianextroom);
       	 		
       	 		//��ǽ;     		 
         		//����Maze[room][wall]��a[nextroom][nextroomwall]״̬����Ϊͨ·��
       	 		Maze[room][wall]=0;
       	 		Maze[nextroom][nextroomwall]=0;
       	 	}
       	 	
        }
  
	}
	
	//���Room��wall��״̬
	public int Wall(int Room,int Wall){
			Wall=Maze[Room][Wall];
			return Wall;
	}
	
	
	//Ѱ���Թ�·��
	public void FindWay(){
		MazeWay[1]=1;
		//��·���߷���
		//�ѳ�ʼλ�ø�ֵΪ0��0����λ�ò���û�и�ֵ����0λ��ֱ����ͨ��λ�ø�ֵΪ1��
		//�ظ�ִ�в���ֱ��n*nλ�ñ���ֵ
		//��ʼѰ��
		for(int i=1;i<n*n;i++){
			//n*nλ�ñ���ֵʱֹͣ���Ҳ���
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

			
		//��ͷѰ��·������¼��way[]��	
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
	
	//��ȡ�Թ���С
	public int GetSize() {
		return n;
		
	}
	
	//��ȡ�Թ� ������Ϣ
	public int[][] GetMaze() {
		return Maze;
	}
	
	
	// ��ȡ�Թ�·��
	public int[]GetMazeWay(){
		return Way;
	}
	
}
