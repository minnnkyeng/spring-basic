package spring.commento.springbasic.chapter03.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.commento.springbasic.chapter03.repository.UserRepositoryJpa;

@Transactional(readOnly = true)
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryJpa userRepositoryJpa;
}
