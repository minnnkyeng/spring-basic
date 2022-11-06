package spring.commento.springbasic.chapter05.iterator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WorkerType {
    DEVELOPER("DEVELOPER", "개발자"),
    MANAGER("MANAGER", "매니저"),
    QA("QA", "QA"),
    PLANNER("PLANNER", "기획자");
    private final String code;
    private final String value;

}
