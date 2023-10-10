package id1012;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        short[] ans = new short[t];
        for(int i = 0;i<t;i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            short m = Short.parseShort(st.nextToken());
            short n = Short.parseShort(st.nextToken());
            short k = Short.parseShort(st.nextToken());
            byte[][] bArr = new byte[m][n];
            for(short j = 0; j < k; j++){
                String string = br.readLine();
                String[] arr = string.split(" ");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                bArr[x][y] = 1;
            }
            ans[i] = wormNumber(bArr, n,m);
        }
        for(int i = 0;i<t;i++){
            bw.write(ans[i]+"\n");
            bw.flush();
        }
        bw.close();
    }

    public static short wormNumber(byte[][] bArr, short n, short m) {
        short counter = 0;
        for(short i = 0; i<m;i++){
            for(short j = 0; j<n;j++){
                if(bArr[i][j]==1){
                    dfs(bArr, i, j,n,m);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void dfs(byte[][] bArr, short i, short j, short n, short m){
        bArr[i][j] = 0;
        if(j<n-1&& bArr[i][j+1]==1) {
            dfs(bArr, i, (short) (j + 1), n, m);
        }
        if(i<m-1&&bArr[i+1][j]==1) {
            dfs(bArr, (short) (i + 1), j, n, m);
        }
        if(j>0&&bArr[i][j-1]==1) {
            dfs(bArr, i, (short) (j - 1), n, m);
        }
        if(i>0&&bArr[i-1][j]==1){
            dfs(bArr, (short) (i-1),j, n, m);
        }
    }
}
