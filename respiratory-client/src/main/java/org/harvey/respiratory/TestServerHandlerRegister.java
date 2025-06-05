package org.harvey.respiratory;

import org.harvey.respiratory.handler.*;
import org.harvey.respiratory.handler.test.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 19:41
 */
public class TestServerHandlerRegister implements ServerHandlerRegister {
    private final Map<String, ServerHandler> map = new HashMap<>();

    public TestServerHandlerRegister() {
        TestHandlerBind bind = new TestHandlerBind(new RandomUtil());
        register(DiseaseHandler.class, new TestDiseaseHandler(bind));
        register(DoctorInterviewHandler.class, new TestDoctorInterviewHandler(bind));
        register(DrugHandler.class, new TestDrugHandler(bind));
        register(ExpenseRecordHandler.class, new TestExpenseRecordHandler(bind));
        register(FamilyHistoryHandler.class, new TestFamilyHistoryHandler(bind));
        register(HealthcarePayHandler.class, new TestHealthcarePayHandler(bind));
        register(MedicalProviderDepartmentHandler.class, new TestMedicalProviderDepartmentHandler(bind));
        register(MedicalProviderFormHandler.class, new TestMedicalProviderFormHandler(bind));
        register(MedicalProviderHandler.class, new TestMedicalProviderHandler(bind));
        register(MedicalProviderJobHandler.class, new TestMedicalProviderJobHandler(bind));
        register(PatientHandler.class, new TestPatientHandler(bind));
        register(SpecificUsingDrugHandler.class, new TestSpecificUsingDrugHandler(bind));
        register(SymptomaticPresentationHandler.class, new TestSymptomaticPresentationHandler(bind));
        register(UserSecurityHandler.class, new TestUserSecurityHandler(bind));
        register(VisitDoctorHandler.class, new TestVisitDoctorHandler(bind));
    }

    private <T extends ServerHandler, H extends T> void register(Class<T> type, H handler) {
        map.put(type.getName(), handler);
    }

    @Override
    public <T extends ServerHandler> T get(Class<T> type) {
        return (T) map.get(type.getName());
    }
}
