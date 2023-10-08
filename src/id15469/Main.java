package id15469;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for(int i = 1; i<n+1;i++){
            arr[i] = i;
        }
        int[] output = new int[m];
        boolean[] visited = new boolean[n+1];

        printSequence(n,m,0, arr, output, visited);
    }

    public static void printSequence(int n, int m, int depth, int[] arr, int[] output, boolean[] v) throws IOException { //n:largest, m:length
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(depth == m){
            for(int i = 0; i<m;i++){
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }else{
            for(int i = 1; i<n+1;i++){
                if(!v[i]){
                    v[i] = true;
                    output[depth] = i;
                    printSequence(n,m,depth+1,arr,output,v);
                    v[i] = false;
                }
            }
        }
    }

}
