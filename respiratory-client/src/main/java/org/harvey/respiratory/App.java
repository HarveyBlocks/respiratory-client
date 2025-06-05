package org.harvey.respiratory;

import org.harvey.respiratory.handler.SymptomaticPresentationHandler;
import org.harvey.respiratory.pojo.entity.clinic.SymptomaticPresentationDetail;
import org.harvey.respiratory.pojo.enums.clinic.SymptomaticPresentationType;

import java.util.List;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 18:11
 */
public class App {
    public static final ServerHandlerRegister REGISTER = new TestServerHandlerRegister();

    public static void main(String[] args) {
        SymptomaticPresentationHandler symptomaticPresentationHandler = REGISTER.get(
                SymptomaticPresentationHandler.class);
        List<SymptomaticPresentationDetail> symptomaticPresentationDetails = symptomaticPresentationHandler.queryDetailsByType(
                SymptomaticPresentationType.ASTHMA);
        System.out.println(symptomaticPresentationDetails);
    }
}
