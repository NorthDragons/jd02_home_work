package it_academy.service;/* created by Kaminskii Ivan
 */

import it_academy.service.api.IPosService;
import it_academy.service.hibernate.PositionServiceH;
import it_academy.service.sql.PositionService;

public class PosServiceInitializer {
    private static EInitializer serviceMode;

    public static EInitializer getServiceMode() {
        return serviceMode;
    }

    public static void setServiceMode(EInitializer serviceMode) {
        PosServiceInitializer.serviceMode = serviceMode;
    }

    public static IPosService getInstance() {
        if (serviceMode == null) {
            throw new IllegalArgumentException("не передан тип хранения");
        }
        switch (serviceMode) {
            case SQL:
                return PositionService.getInstance();
            case HIBERNATE:
//                return PositionServiceH.getInstance();
            default:
                throw new IllegalArgumentException("Тип хранения введён не правильно");
        }
    }
}
