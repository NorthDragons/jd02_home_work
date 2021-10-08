package it_academy.service;/* created by Kaminskii Ivan
 */

import it_academy.service.api.IDepService;
import it_academy.service.hibernate.DepartmentServiceH;
import it_academy.service.sql.DepartmentService;

public class DepServiceInitializer {
    private static DepServiceInitializer instance;
    private static EInitializer serviceMode;

    public static EInitializer getServiceMode() {
        return serviceMode;
    }

    public static void setServiceMode(EInitializer serviceMode) {
        DepServiceInitializer.serviceMode = serviceMode;
    }

    public static IDepService getInstance() {
        if (serviceMode == null) {
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (serviceMode) {
            case SQL:
                return DepartmentService.getInstance();
            case HIBERNATE:
//                return DepartmentServiceH.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
