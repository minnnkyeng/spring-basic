package spring.commento.springbasic.chapter05.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YoutubeMusic implements Music {
    @Override
    public void musicOn() {
        log.info("\n 유튜브 뮤직에서 음악 재생 ");
    }

    @Override
    public void musicOff() {
        log.info("\n 유튜브 뮤직에서 음악 정지 ");

    }
}
