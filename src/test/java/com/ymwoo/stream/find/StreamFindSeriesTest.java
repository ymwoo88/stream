package com.ymwoo.stream.find;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

@Slf4j
public class StreamFindSeriesTest {

    @Test
    @DisplayName("Stream findAny, findFirst 테스트")
    void case1() {
        List<User> examUserList = User.getExamUserList();

        Optional<User> first = examUserList.stream()
                .filter(User::getIsWorking)
                .findFirst(); // return 이 Optional

        List<User> isWorkingUserList = examUserList.stream()
                .filter(User::getIsWorking).toList();
        // 2개 이상 검증
        Assertions.assertEquals(2, isWorkingUserList.size());
        // 2개 중에 any 뭐가 나올까..?
        Optional<User> any = isWorkingUserList.stream()
                .filter(User::getIsWorking)
                .findAny(); // return 이 Optional

        // 확인
        log.info("findFirst = {}", first.get());
        // any 결과를 보니까 first와 다를게 없어보이네.. 무조건 앞에께 튀나오네
        log.info("findAny = {}", any.get());
    }
}
