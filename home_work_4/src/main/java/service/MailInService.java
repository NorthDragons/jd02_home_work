package service;/* created by Kaminskii Ivan
 */

import model.UserDto;

import java.util.Objects;

public class MilInService {
   private final MailService mailService;

    public MilInService(MailService mailService) {
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
}
