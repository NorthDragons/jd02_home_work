package model;/* created by Kaminskii Ivan
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class Message implements Serializable {
    private String from;
    private String text;
    private LocalDateTime when;

    public Message(String from, String text) {
        this.from = from;
        this.text = text;
        this.when= LocalDateTime.now();
    }

    @Override
    public String toString() {
        return  "Отправитель: " + from + "\n</br>" +
                "Сообщение: " + text + "\n</br>" +
                when+"\n</br></br>";
    }
}
