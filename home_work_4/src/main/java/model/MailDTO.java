package model;/* created by Kaminskii Ivan
 */

import java.util.Map;

public class MailDTO {


    private Map<String, String> messages;

    public MailDTO(Map<String, String> messages) {
        this.messages = messages;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }
}
