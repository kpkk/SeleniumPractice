package utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SubArrayLength {

    @Test
    public void test1(){
        int [] arr={1,3,3,};
        int N=3;
        int k=6;
        Assert.assertEquals(findSubArrayLength(arr, k, N),3);
    }

    private int findSubArrayLength(int[] arr, int k, int n) {

        int sum=0;
        HashMap<Integer, Integer>map=new HashMap<>();
        map.put(0,1);
        for (int i=0;i<arr.length;i++){

        }
return 1;
    }
}
