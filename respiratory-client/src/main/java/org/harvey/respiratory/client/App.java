package org.harvey.respiratory.client;

import org.harvey.respiratory.client.handler.SymptomaticPresentationHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.SymptomaticPresentationDetail;
import org.harvey.respiratory.client.pojo.enums.clinic.SymptomaticPresentationType;

import java.util.List;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 18:11
 */
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
