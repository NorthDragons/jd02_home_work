package by.it_academy.home_work3.service.api;/* created by Kaminskii Ivan
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseStorage implements IStorage {

    protected HttpServletRequest req;

    protected HttpServletResponse resp;

    public BaseStorage(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

}
