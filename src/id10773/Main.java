package id10773;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        for(int i = 0; i<k;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<k;i++){
            if(arr[i] ==0){
                stack.pop();
            }else{
                stack.push(arr[i]);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum = sum+stack.pop();
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();

    }
}
