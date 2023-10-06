package id1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        String ss = br.readLine();
        StringTokenizer sst = new StringTokenizer(ss);
        int[] arr2 = new int[m];
        for(int i = 0 ;i<m;i++){
            arr2[i] = Integer.parseInt(sst.nextToken());
        }
        for(int i = 0 ;i<m;i++){
            int j = binarySearch(arr,n-1,0,arr2[i]);
            bw.write(j+"\n");
            bw.flush();
        }
        bw.close();

    }

    public static int binarySearch(int[] arr, int highest, int lowest, int key){
        if(highest<lowest){
            return 0;
        }
        int middle = (highest+lowest)/2;
        if(arr[middle] == key){
            return 1;
        }else{
            if(arr[middle]>key){
                return binarySearch(arr,middle-1,lowest,key);
            }else {
                return binarySearch(arr, highest, middle + 1, key);
            }
        }

    }

}
