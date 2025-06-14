```java
public class App {
    public static final ServerHandlerRegister REGISTER = ServerHandlerRegisterFactory.TEST;

    public static void main(String[] args) {
        SymptomaticPresentationHandler symptomaticPresentationHandler = REGISTER.get(
                SymptomaticPresentationHandler.class);
        List<SymptomaticPresentationDetail> symptomaticPresentationDetails = symptomaticPresentationHandler.queryDetailsByType(
                SymptomaticPresentationType.ASTHMA);
        System.out.println(symptomaticPresentationDetails);
    }
}

```
