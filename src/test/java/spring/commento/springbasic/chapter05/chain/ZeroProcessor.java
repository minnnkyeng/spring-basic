package spring.commento.springbasic.chapter05.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZeroProcessor extends Processor {
    public ZeroProcessor(String name) {
        super(name);
    }

    @Override
    public void process(Number request) {
        if (request.getNumber() == 0) {
            log.info("\n 제로 name : {}",request.getNumber());
        } else {
            super.process(request);
        }
    }
}
