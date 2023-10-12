package id1874;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<n;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Character> plusMinus = new LinkedList<>();
        int pointer = 1;
        stackPossible(stack,queue,pointer,plusMinus);
    }

    public static void stackPossible(Stack<Integer> stack, Queue<Integer> queue,int pointer,Queue<Character> plusMinus) throws IOException {
        while(!queue.isEmpty()) {
            int element = queue.poll();
            if (pointer <= element) {
                for (int i = pointer; i <= element; i++) {
                    stack.push(i);
                    plusMinus.add('+');
                }
                pointer = stack.pop();
                plusMinus.add('-');
                pointer++;
            } else {
                if(stack.peek()!=element){
                    plusMinus.clear();
                    break;
                }else{
                    stack.pop();
                    plusMinus.add('-');
                }
            }
        }
        printPossible(plusMinus);
    }

    public static void printPossible(Queue<Character> plusMinus) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(plusMinus.isEmpty()){
            bw.write("NO");
            bw.flush();
        }else{
            while(!plusMinus.isEmpty()){
                bw.write(plusMinus.poll()+"\n");
                bw.flush();
            }
        }
        bw.close();
    }
}
