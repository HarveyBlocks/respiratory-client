package org.harvey.respiratory.client;

import org.harvey.respiratory.client.handler.*;
import org.harvey.respiratory.client.handler.transmit.*;
import org.harvey.respiratory.transmit.correspondence.HttpClientManager;
import org.harvey.respiratory.transmit.correspondence.HttpRequestBuilder;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 03:22
 */
public class TransmitServerHandlerRegister implements ServerHandlerRegister {
    private final Map<String, ServerHandler> map = new HashMap<>();

    protected TransmitServerHandlerRegister() {
        TransmitHandlerBind bind = new TransmitHandlerBind(new SimpleDateFormat("yyyy-MM-dd"), new HttpRequestBuilder(),
                new HttpClientManager()
        );
        register(DiseaseHandler.class, new TransmitDiseaseHandler(bind));
        register(DoctorInterviewHandler.class, new TransmitDoctorInterviewHandler(bind));
        register(DrugHandler.class, new TransmitDrugHandler(bind));
        register(ExpenseRecordHandler.class, new TransmitExpenseRecordHandler(bind));
        register(FamilyHistoryHandler.class, new TransmitFamilyHistoryHandler(bind));
        register(HealthcarePayHandler.class, new TransmitHealthcarePayHandler(bind));
        register(MedicalProviderDepartmentHandler.class, new TransmitMedicalProviderDepartmentHandler(bind));
        register(MedicalProviderFormHandler.class, new TransmitMedicalProviderFormHandler(bind));
        register(MedicalProviderHandler.class, new TransmitMedicalProviderHandler(bind));
        register(MedicalProviderJobHandler.class, new TransmitMedicalProviderJobHandler(bind));
        register(PatientHandler.class, new TransmitPatientHandler(bind));
        register(SpecificUsingDrugHandler.class, new TransmitSpecificUsingDrugHandler(bind));
        register(SymptomaticPresentationHandler.class, new TransmitSymptomaticPresentationHandler(bind));
        register(UserSecurityHandler.class, new TransmitUserSecurityHandler(bind));
        register(VisitDoctorHandler.class, new TransmitVisitDoctorHandler(bind));
    }

    private <T extends ServerHandler, H extends T> void register(Class<T> type, H handler) {
        map.put(type.getName(), handler);
    }

    @Override
    public <T extends ServerHandler> T get(Class<T> type) {
        return (T) map.get(type.getName());
    }
}
