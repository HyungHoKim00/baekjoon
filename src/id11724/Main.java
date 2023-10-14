package id11724;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] connections;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connections = new ArrayList[n+1];
        visited = new boolean[n+1];
        int counter = 0;
        for(int i = 1;i<n+1;i++){
            connections[i] = new ArrayList<>();
        }
        for(int i =0;i<m;i++){
            String newLine = br.readLine();
            String[] newNumber = newLine.split(" ");
            int x = Integer.parseInt(newNumber[0]);
            int y = Integer.parseInt(newNumber[1]);
            connections[x].add(y);
            connections[y].add(x);
        }
        for(int i = 1; i<n+1;i++){
            if(!connections[i].isEmpty()&&!visited[i]){
                bfs(i);
                counter++;
            }else if(connections[i].isEmpty()){
                counter++;
            }
        }

        bw.write(counter+"");
        bw.flush();
        bw.close();

    }

    public static void bfs(int point){
        visited[point] = true;
        int size = connections[point].size();
        for(int i = 0;i<size;i++){
            int nextPoint = connections[point].get(i);
            if(!visited[nextPoint]){
                bfs(nextPoint);
            }
        }
    }
}
