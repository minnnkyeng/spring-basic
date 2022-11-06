package spring.commento.springbasic.chapter05.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Siri {
    private Music music;
    public void talk(CommandType commandType) {
        switch (commandType) {
            case COMMAND_MUSIC_ON:
                music.musicOn();
                break;
            case COMMAND_MUSIC_OFF:
                music.musicOff();
                break;
            default:
                log.info("\n 시리는 모르는 내용입니다");
        }
    }
}
