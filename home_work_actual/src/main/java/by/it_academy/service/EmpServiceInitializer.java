package by.it_academy.service;/* created by Kaminskii Ivan
 */

import by.it_academy.service.api.IEmployerService;
import by.it_academy.service.hibernate.EmployeeServiceH;
import by.it_academy.service.sql.EmployeeService;

public class EmpServiceInitializer {
    private static EInitializer serviceMode;

    public static EInitializer getServiceMode() {
        return serviceMode;
    }

    public static void setServiceMode(EInitializer serviceMode) {
        EmpServiceInitializer.serviceMode = serviceMode;
    }

    public static IEmployerService getInstance() {
        if (serviceMode == null) {
            serviceMode= EInitializer.valueOf("HIBERNATE");
//            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (serviceMode) {
            case SQL:
                return EmployeeService.getInstance();
            case HIBERNATE:
                return EmployeeServiceH.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
