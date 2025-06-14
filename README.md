


```java
public class App {
    // 获取Register, Register是获取Handler的, Handler可以用来传输数据, 也可以用来测试
    // 选择了 ServerHandlerRegisterFactory.TEST 就是在测试了假数据了
    public static final ServerHandlerRegister REGISTER = ServerHandlerRegisterFactory.TEST;

    public static void main(String[] args) {
        // 从REGISTER中, 获取SymptomaticPresentationHandler, 症状处理器
        // 使用SymptomaticPresentationHandler.class选择需要的有关处理器
        SymptomaticPresentationHandler symptomaticPresentationHandler = REGISTER.get(
                SymptomaticPresentationHandler.class);
        // symptomaticPresentationHandler调用有关方法
        List<SymptomaticPresentationDetail> symptomaticPresentationDetails = symptomaticPresentationHandler.queryDetailsByType(
                SymptomaticPresentationType.ASTHMA);
        System.out.println(symptomaticPresentationDetails);
    }
}

```


