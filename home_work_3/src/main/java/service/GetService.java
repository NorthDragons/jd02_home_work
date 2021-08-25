package by.it_academy.home_work3.service;/* created by Kaminskii Ivan
 */

import by.it_academy.home_work3.service.api.EStorageType;
import by.it_academy.home_work3.service.api.IStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetService {
    private static final GetService instance=new GetService();

    static final String STORAGE_TYPE_HEADER = "storage";


    public String getParam(String key, HttpServletRequest req, HttpServletResponse resp) {
//        выбираем storage соответствующий значению передаваемому в header
        EStorageType storageType = EStorageType.valueOfIgnoreCase(req.getHeader(STORAGE_TYPE_HEADER));
        IStorage storage = storageType.getStorage(req, resp);
        String value = req.getParameter(key);

        if (value != null) {
            storage.save(key, value);
            return value;
        }

        value = storage.get(key);
        if (value == null) {
            throw new IllegalArgumentException(key + "Не ввели обязательные данные");
        }
        return value;
    }


    public static GetService getInstance(){
        return instance;
    }
}
