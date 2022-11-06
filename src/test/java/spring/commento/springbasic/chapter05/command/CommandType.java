package spring.commento.springbasic.chapter05.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommandType {
    COMMAND_MUSIC_ON("COMMAND_MUSIC_ON", "음악 켜줘"),
    COMMAND_MUSIC_OFF("COMMAND_MUSIC_ON", "음악 꺼줘"),;
    private final String code;
    private final String value;


}
