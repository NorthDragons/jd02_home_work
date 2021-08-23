package service;/* created by Kaminskii Ivan
 */

import model.UserDto;

import java.util.Objects;

public class MailInService {
    private final static MailInService instance = new MailInService();
   private final MailService mailService;

    public MailInService() {
        this.mailService = MailService.getInstance();
    }


    public UserDto authentication(String login, String password) {
        UserDto user = this.mailService.get(login);
        if(user == null){
            return null;
        }

        if(!Objects.equals(user.getPassword(), password)){
            return null;
        }

        return user;
    }
    public static MailInService getInstance(){
        return instance;
    }
}
