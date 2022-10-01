package suan_fa;

public class Test009 {
    /**
     * ****************** 最后一个单词的长度 ******************
     *  给定一个字符串s，由若干单词组成。单词前后用一些空格字符隔开。返
     * 回字符串中最后一个单词长度。
     *  单词指仅由字母组成、不包含任何空格的最大子字符串。
     */

    public static int lenLastWord(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            if(i >= 1 && s.charAt(i) != ' ' && s.charAt(i-1) == ' '){
                count = 1;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        String s = "fly me to the moon  ";
        System.out.println(lenLastWord(s));

    }



}
