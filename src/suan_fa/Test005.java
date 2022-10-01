package suan_fa;

public class Test005 {

    /**
     * ****************** 有效的括号 ******************
     *  给定一个只包括'('、')'、'{'、'}'、'['、']'的字符串s。
     *  判断字符串是否有效。
     *  有效字符串的条件：
     *      1、左括号必须有相同类型的右括号匹配；
     *      2、左括号必须以正确的顺序闭合；
     *      3、每个右括号都有一个对应的相同类型的左括号。
     */


    public static boolean bracketPair(String str){

        String zhanStr = "";
        String leftBracketStr = "([{";
        String rightBracketStr = ")]}";

        // 左括号进栈，右括号与栈顶括号匹配
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            // 是左括号，进栈
            if (leftBracketStr.contains(s)) {
                zhanStr += s;
            }
            // 右括号，匹配栈顶的左括号
            if (rightBracketStr.contains(s)) {
                // 栈顶左括号
                char top = zhanStr.charAt(zhanStr.length() - 1);
                if(leftBracketStr.charAt(rightBracketStr.indexOf(s)) != top){
                    return false;
                }else {
                    // 删除栈顶元素
                    zhanStr = zhanStr.substring(0,zhanStr.length()-1);
                }
            }

        }

        return true;
    }



    public static void main(String[] args) {
        System.out.println(bracketPair("{[() | ()]()}"));


    }




}
