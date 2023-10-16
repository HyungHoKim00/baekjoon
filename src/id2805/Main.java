package id2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int treeNumber;
    static long totalSub;
    static long treeLengthLeft;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nm = br.readLine();
        String[] nmArr = nm.split(" ");
        int n = Integer.parseInt(nmArr[0]);
        int m = Integer.parseInt(nmArr[1]);
        String trees = br.readLine();
        StringTokenizer stTrees = new StringTokenizer(trees);
        int[] treesLength = new int[n];
        for(int i = 0; i<n;i++){
            treesLength[i] = Integer.parseInt(stTrees.nextToken());
        }
        Arrays.sort(treesLength);
        treeNumber = 0;
        totalSub = 0;
        treeLengthLeft = m;
        while(treeLengthLeft>0){
            treeNumber++;
            int sub;
            if(treeNumber<n){
                sub = treesLength[n-treeNumber] - treesLength[n-treeNumber-1];
            }else{
                sub = treesLength[n-treeNumber];
            }
            treeLengthLeft = treeLengthLeft- (long) sub *treeNumber;
            totalSub += sub;
        }
        long add = (-treeLengthLeft)/treeNumber;
        totalSub -= add;
        long height = treesLength[n-1]-totalSub;
        bw.write(height+"");
        bw.flush();
        bw.close();
    }
}
