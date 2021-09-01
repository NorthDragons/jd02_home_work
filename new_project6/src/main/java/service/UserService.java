package service;/* created by Kaminskii Ivan
 */

import service.api.IUserService;

public class UserService implements IUserService {
    private static final UserService instance= new UserService();


    @Override
    public void putUser() {

    }

    public static UserService getInstance(){
        return instance;
    }
}
