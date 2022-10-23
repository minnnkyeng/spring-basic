package spring.commento.springbasic.chapter03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
    private String name;
    private String companyName;
}
