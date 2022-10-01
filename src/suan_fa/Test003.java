package suan_fa;

import java.util.HashMap;

public class Test003 {
    /**
     * ******************** 罗马数字转整数 ********************
     *  罗马数字符：I,V,X,L,C,D,M
     *  对应数值：1,5,10,50,100,500,1000
     *
     */

    public static int romanToInt(String roman){
        int num = 0;
        HashMap<Character, Integer> romanValue = romanValue();
        for (int i = roman.length()-1; i >= 0; i--) {
            if (i != roman.length()-1 && romanValue.get(roman.charAt(i)) < romanValue.get(roman.charAt(i+1))) {
                num -= romanValue.get(roman.charAt(i));
            }else {
                num += romanValue.get(roman.charAt(i));
            }
        }
        return num;
    }

    private static HashMap<Character, Integer> romanValue(){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        return hashMap;
    }


    public static void main(String[] args) {
        int i = romanToInt("MCMXCIV");
        System.out.println(i);
    }






}
