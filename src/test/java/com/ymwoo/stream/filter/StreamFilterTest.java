package com.ymwoo.stream.filter;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class StreamFilterTest {

    @Test
    @DisplayName("user name이 amil 인경우 필터링")
    void case1() {
        List<User> examUserList = User.getExamUserList();
        List<User> filteredUser = examUserList
                .stream()
                .filter(user -> "amil".equals(user.getName()))
                .toList();
        // 결과 출력
        filteredUser
                .forEach(user -> log.info(">>> Filtered User Info = {}", user));
    }

    @Test
    @DisplayName("30대 이하이면서 일하는 중인경우 필터링")
    void case2() {
        List<User> examUserList = User.getExamUserList();
        List<User> filteredUser = examUserList
                .stream()
                .filter(user -> 30 > user.getAge())
                .filter(User::getIsWorking)
                .toList();
        // 결과 출력
        filteredUser
                .forEach(user -> log.info(">>> Filtered User Info = {}", user));
    }
}
