package id1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i = 0; i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int biggest = a[0];
        int smallest = Math.min(0,a[0]);
        int[] sum = new int[n];
        sum[0] = a[0];
        for(int i = 1; i<n;i++){
            sum[i] = sum[i-1] + a[i];
            if(sum[i]-smallest>biggest){
                biggest = sum[i]-smallest;
            }
            if(sum[i]<smallest){
                smallest = sum[i];
            }
            //bw.write(biggest + " " + smallest + "\n");
        }

        bw.write(biggest + "");
        bw.flush();
        bw.close();
    }

}
