package spring.commento.springbasic.chapter05.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PositiveProcessor extends Processor {
    public PositiveProcessor(String name) {
        super(name);
    }

    @Override
    public void process(Number request) {
        if (request.getNumber() > 0) {
            log.info("\n 양수 name : {}",request.getNumber());
        } else {
            super.process(request);
        }
    }
}
