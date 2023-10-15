package id1541;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String exp = br.readLine();
        String[] divMinus = exp.split("-");
        int length = divMinus.length;
        int total = 0;
        String[] first = divMinus[0].split("\\+");
        for (String s : first) {
            total += Integer.parseInt(s);
        }
        if(length>1){
            for(int i = 1; i<length;i++){
                String[] arr = divMinus[i].split("\\+");
                for (String s : arr) {
                    total -= Integer.parseInt(s);
                }
            }
        }
        bw.write(total+"");
        bw.flush();
        bw.close();
    }
}
