package sdu.shujujiegoukeshe.zhangxiaofeng.Maze.Creat;

public class Dengjialei {  
    
    private int[] s;  
    //��ʼ���ȼ���  
    public Dengjialei(int numElements)  
    {  
        s=new int[numElements];  
        for(int i=0;i<s.length;i++)  
            s[i]=-1;  
    } 
    //�ϲ��ȼ���
    public void union(int root1,int root2)  
    {  
        s[root2]=root1;  
    } 
    //�������ڵȼ���
        public int find(int x)  
    {  
        if(s[x]<0)  
            return x;  
        else  
                 return find(s[x]);           
    }  
        
} 
