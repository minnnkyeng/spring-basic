package spring.commento.springbasic.chapter05.command;

public class CommandMain {
    public static void main(String[] args) {
        Siri siri1 = new Siri(new Genie());
        siri1.talk(CommandType.COMMAND_MUSIC_ON);
        siri1.talk(CommandType.COMMAND_MUSIC_OFF);


        Siri siri2 = new Siri(new YoutubeMusic());
        siri2.talk(CommandType.COMMAND_MUSIC_ON);
        siri2.talk(CommandType.COMMAND_MUSIC_OFF);
    }


}


