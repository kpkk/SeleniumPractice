package utilities;

import java.nio.charset.MalformedInputException;

public class Main {

    int a , b=9;
    public int sum(){
        return a+b;

    }
    private int add(){
        return a+b;

    }
    int result(){
        return new Main().sum();
    }

    }
 class Examp3 {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.sum() + m.result());
    }
}
