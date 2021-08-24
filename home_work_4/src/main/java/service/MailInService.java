package service;/* created by Kaminskii Ivan
 */

import model.User;

import java.util.Objects;

public class MailInService {
    private final static MailInService instance = new MailInService();
   private final MailRegService mailService;

    public MailInService() {
        this.mailService = MailRegService.getInstance();
    }


    public User authentication(String login, String password) {
        User user = this.mailService.get(login);
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
