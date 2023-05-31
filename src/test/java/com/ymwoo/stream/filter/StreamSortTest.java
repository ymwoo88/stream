package com.ymwoo.stream.filter;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

@Slf4j
public class StreamSortTest {

    @Test
    @DisplayName("나이순으로 오름차순")
    void case1() {
        List<User> examUserList = User.getExamUserList();
        List<User> sortedUser = examUserList
                .stream()
                // user는 그냥 sort할수 없으므로 comparator을 제공해야 합니다.
                // 이는 람다식으로 간단하게 제공할 수 있습니다.
                // 아래 코드는 오름차순 방식이고 내림차순을 원한다면 u1과 u2의 순서를 바꾸면 됩니다.
                .sorted(Comparator.comparing(User::getAge))
                .toList();
        // 결과 출력
        sortedUser
                .forEach(user -> log.info(">>> sortedUser User Info = {}", user));
    }

    @Test
    @DisplayName("이름순으로 내림차순")
    void case2() {
        List<User> examUserList = User.getExamUserList();
        List<User> sortedUser = examUserList
                .stream()
                // user는 그냥 sort할수 없으므로 comparator을 제공해야 합니다.
                // 이는 람다식으로 간단하게 제공할 수 있습니다.
                // 아래 코드는 오름차순 방식이고 내림차순을 원한다면 u1과 u2의 순서를 바꾸면 됩니다.
                .sorted((u1, u2) -> u2.getName().compareTo(u1.getName()))
                .toList();
        // 결과 출력
        sortedUser
                .forEach(user -> log.info(">>> sortedUser User Info = {}", user));
    }
}
