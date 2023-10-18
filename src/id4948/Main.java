package id4948;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean isZero = false;
        Queue<Integer> inputNumbers = new LinkedList<>();
        while(!isZero){
            int n = Integer.parseInt(br.readLine());
            if(n==0){
                isZero = true;
            }else{
                inputNumbers.add(n);
            }
        }
        boolean[] notPrimeNumbers = new boolean[246913];
        for(int i = 2; i< 500;i++){
            if(!notPrimeNumbers[i]){
                for(int j = 2; j*i<246913;j++){
                    notPrimeNumbers[j*i] = true;
                }
            }
        }
        while(!inputNumbers.isEmpty()){
            int i = inputNumbers.poll();
            int primeNumberNumbers = 0;
            for(int j = i+1;j<=2*i;j++){
                if(!notPrimeNumbers[j]){
                    primeNumberNumbers++;
                }
            }
            bw.write(primeNumberNumbers+"\n");
            bw.flush();
        }
        bw.close();
    }
}
