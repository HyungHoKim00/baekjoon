package id2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] mazeString = new String[n];
        for(int i = 0; i<n;i++){
            mazeString[i] = br.readLine();
        }
        MazeSearch mazeSearch = new MazeSearch(m,n,mazeString);
        mazeSearch.bfs();
        bw.write(mazeSearch.getShortestLength()+"");
        bw.flush();
        bw.close();
    }
}

class MazeSearch{
    private byte[][] maze;
    private int shortestLength;
    private int mazeWidth;
    private int mazeHeight;
    private Queue<Integer> courseQueue = new LinkedList<>();
    MazeSearch(int mazeWidth,int mazeHeight, String[] mazeString){
        maze = new byte[mazeWidth][mazeHeight];
        for(int y = 0; y<mazeHeight;y++){
            for(int x = 0; x<mazeWidth;x++){
                maze[x][y] = (byte) Character.getNumericValue(mazeString[y].charAt(x));
            }
        }
        shortestLength = 1;
        this.mazeWidth = mazeWidth;
        this.mazeHeight = mazeHeight;
        courseQueue.add(0);
    }
    public void bfs(){
        while(!courseQueue.isEmpty()){
            int xy = courseQueue.poll();
            if(xy == 100*(mazeWidth-1)+mazeHeight-1){
                break;
            }
            int x = xy/100;
            int y = xy%100;
            if(x<mazeWidth-1&&maze[x+1][y]==1){
                courseQueue.add(xy+100);
                maze[x+1][y] = 0;
            }
            if(y<mazeHeight-1&&maze[x][y+1]==1){
                courseQueue.add(xy+1);
                maze[x][y+1] = 0;
            }
            if(x>0&&maze[x-1][y]==1){
                courseQueue.add(xy-100);
                maze[x-1][y] = 0;
            }
            if(y>0&&maze[x][y-1]==1){
                courseQueue.add(xy-1);
                maze[x][y-1] = 0;
            }
            if(!courseQueue.isEmpty()){
                int nextXy = courseQueue.peek();
                if((nextXy%100+nextXy/100+x+y)%2 == 1){
                    shortestLength++;
                }
            }
        }
    }
    public int getShortestLength(){
        return shortestLength;
    }
}