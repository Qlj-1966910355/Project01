package meiju;

public enum Enum02 {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;

    Enum02() {
    }
}

class EnumTest02{
    public static void main(String[] args) {
        Enum02 six = Enum02.SIX;
        // 注意：Enum中重写了toString()方法，所以switch中可以直接使用当前Enum对象
        switch (six) {
            case ONE:
                System.out.println("星期一");
                break;
            case TWO:
                System.out.println("星期二");
                break;
            case THREE:
                System.out.println("星期三");
                break;
            case FOUR:
                System.out.println("星期四");
                break;
            case FIVE:
                System.out.println("星期五");
                break;
            case SIX:
                System.out.println("星期六");
                break;
            case SEVEN:
                System.out.println("星期日");
                break;
        }



    }
}
