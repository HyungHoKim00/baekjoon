package id1260;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Short>[] connections;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        short n = Short.parseShort(st.nextToken());
        short m = Short.parseShort(st.nextToken());
        short v = Short.parseShort(st.nextToken());
        connections = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1;i<n+1;i++){
            connections[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            String string = br.readLine();
            String[] split = string.split(" ");
            short x = Short.parseShort(split[0]);
            short y = Short.parseShort(split[1]);
            connections[x].add(y);
            connections[y].add(x);
        }

        for(int i = 1 ; i<n+1;i++){
            Collections.sort(connections[i]);
        }

        dfs(v);
        bw.write("\n");
        bw.flush();
        Arrays.fill(visited, false);
        bfs(v);
    }

    public static void dfs(short v) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(v + " ");
        bw.flush();
        visited[v] = true;
        for(short i:connections[v]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(short v) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Short> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            short node = queue.poll();
            bw.write(node + " ");
            bw.flush();
            for(short i:connections[node]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
