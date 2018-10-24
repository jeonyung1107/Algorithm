import java.util.Scanner;

public class stack_181024 {
    int[] arr;
    int top;

    public stack_181024(int size){
        arr = new int[size];
        top = 0;
    }

    public int insert(int item){
        if(top >= arr.length-1) return 1;

        arr[++top] = item;
        return 0;
    }

    public int pop(){
        if(top <=0) return -1;

        return arr[top--];
    }

    public static void main(String args[]){
        int size = 10000;
        stack_181024 stack = new stack_181024(size);

        for(int i=0; i<size; ++i){
            stack.insert(i);
        }

        for(int i=0; i<size; ++i){
            System.out.println(stack.pop());
        }
    }
}
