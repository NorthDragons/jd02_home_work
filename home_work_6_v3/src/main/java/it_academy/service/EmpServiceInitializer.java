package it_academy.service;/* created by Kaminskii Ivan
 */

import it_academy.service.api.IEmpService;
import it_academy.service.hibernate.EmployeeServiceH;
import it_academy.service.sql.EmployeeService;

public class EmpServiceInitializer {
    private static EInitializer serviceMode;

    public static EInitializer getServiceMode() {
        return serviceMode;
    }

    public static void setServiceMode(EInitializer serviceMode) {
        EmpServiceInitializer.serviceMode = serviceMode;
    }

    public static IEmpService getInstance() {
        if (serviceMode == null) {
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (serviceMode) {
            case SQL:
                return EmployeeService.getInstance();
            case HIBERNATE:
                return null;
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
