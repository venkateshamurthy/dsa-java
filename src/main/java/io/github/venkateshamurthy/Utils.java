package io.github.venkateshamurthy;

public class Utils {
    public static <T> void swap(T[] t, int a, int b){
        T temp = t[a];
        t[a] = t[b];
        t[b] = temp;
    }

    public static void swap(byte[] t, int a, int b){
        byte temp = t[a];
        t[a] = t[b];
        t[b] = temp;
    }

    public static void swap(int[] t, int a, int b){
        int temp = t[a];
        t[a] = t[b];
        t[b] = temp;
    }

    public static void swap(char[] t, int a, int b) {
        char temp = t[a];
        t[a] = t[b];
        t[b] = temp;
    }

    public static void swapRange(char[] arr, int left, int right){
        while(left < right) swap(arr, left++, right--);
    }
    public static void swapRange(byte[] arr, int left, int right){
        while(left < right) swap(arr, left++, right--);
    }
    public static void swapRange(int[]  arr, int left, int right){
        while(left < right) swap(arr, left++, right--);
    }
}
