package zhujie;

@Annotation00(value = "qlj", num = {1,2,3,4,5})
public class Annotation00_Test00 {
    public String user;
    private String VIPNo;

    @Annotation0            // 默认：value="qlj"
    public void doSome(){
        System.out.println("实现自定义注解！");
    }

    @Annotation0("zmq")
    public void doOther(){
        System.out.println("实现自定义注解！");
    }
}
