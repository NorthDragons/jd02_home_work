package by.it_academy.home_work3.service.api;

import by.it_academy.home_work3.service.CookieService;
import by.it_academy.home_work3.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.BiFunction;

public enum EStorageType {
    SESSION(
            SessionService::new
    ),
    COOKIE(
            CookieService::new
    ),
    ;

    private final BiFunction<HttpServletRequest, HttpServletResponse, IStorage> storage;

    EStorageType(BiFunction<HttpServletRequest, HttpServletResponse, IStorage> storage) {
        this.storage = storage;
    }


    public static EStorageType valueOfIgnoreCase(String name) {
        for (EStorageType value : values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Неизвестный тип хранилища");
    }


    public IStorage getStorage(HttpServletRequest req, HttpServletResponse resp) {
        return this.storage.apply(req, resp);
    }

}

