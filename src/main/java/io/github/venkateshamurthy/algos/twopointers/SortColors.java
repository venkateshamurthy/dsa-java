package io.github.venkateshamurthy.algos.twopointers;
import java.util.Arrays;

import static io.github.venkateshamurthy.Utils.*;

public class SortColors {
    static int RED=0, WHITE=1, BLUE=2;
    public int[] sortColors(int[] c){
        int left = 0, mid = 0, right = c.length - 1;
        while (mid <= right) {
            if       (RED == c[mid])   swap(c, left++,  mid++);
            else  if (BLUE== c[mid])   swap(c, right--, mid  );
            else/*if(WHITE== c[mid])*/ mid++;
        }
        return c;
    }

    public static void main(String[] args){
        int[] colors = new int[]{RED, WHITE,RED, WHITE, BLUE, RED, BLUE,RED, WHITE, BLUE, RED, RED};
        System.out.println("Sorted Colors:"+ Arrays.toString(colors));
        SortColors sorter = new SortColors();
        int[] sortedColors = sorter.sortColors(colors);
        System.out.println("Sorted Colors:"+ Arrays.toString(sortedColors));
    }

}
