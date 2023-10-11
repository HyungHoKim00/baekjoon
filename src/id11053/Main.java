package id11053;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int[] a = new int[t];
        for(int i = 0; i<t;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int counter = findLongest(a,t);
        bw.write(counter + "");
        bw.flush();
        bw.close();
    }

    public static int findLongest(int[] a, int size) {
        int[] lis = new int[size];
        lis[0] = a[0];
        int aIndex = 1;
        int lisIndex = 0;
        while(aIndex<size){
            if(a[aIndex]>lis[lisIndex]){
                lisIndex++;
                lis[lisIndex] = a[aIndex];
            }else{
                int pos = findIndex(lis, 0, lisIndex,a[aIndex]);
                lis[pos] = a[aIndex];
            }
            aIndex++;
        }

        return lisIndex+1;
    }

    public static int findIndex(int[] lis, int left, int right, int target) {
        while(right>left){
            int mid = (right+left)/2;
            if(lis[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }


}
