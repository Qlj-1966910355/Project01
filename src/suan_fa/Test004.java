package suan_fa;

public class Test004 {

    /**
     * ************* 最长公共前缀 *************
     *  编写一个方法查找字符串数组中的最长公共前缀。
     *  如果不存在公共前缀，返回空字符串""。
     */

    public static String maxIsStr(String[] s){

        String str = s[0];

        for (int i = 1; i < s.length; i++) {
            if(str == "" || s[i] == ""){
                return "";
            }

            for (int j = 0; j < str.length(); j++) {
                if (s[i].length() == j || str.charAt(j) != s[i].charAt(j)) {
                    str = str.substring(0,j);
                    break;
                }
            }
        }

        return str;
    }


    public static void main(String[] args) {
        String[] s = {"abcd", "abcgda", "acb"};
        String str = maxIsStr(s);
        System.out.println(str);
    }



}
