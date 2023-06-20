package com.ymwoo.stream.collector.tomap;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamToMapTest {

    @Test
    @DisplayName("Collectors toMap 상황별 사용해보기")
    void case3() {
        // keyMapper는 값을 그대로 키로, valueMapper는 Number is x 값으로 저장
        Map<Integer, String> numberMap1 = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(x -> x, x -> "Number is " + x));
        log.info("numberMap1 : {}", numberMap1);

        // x -> x 같이 간단한 경우 Function에서 identity 메서드로 이미 제공하고 있어서 이를 이용해도 됩니다.
        Map<String, Integer> numberMap2 = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(x -> "Number is " + x, Function.identity()));
        log.info("numberMap2 : {}", numberMap2);

        // numberMap2 예제에서 reverse 버전으로 작성봄 (원리를 알아야 거꾸로도 하니까 그냥 해봄)
        Map<Integer, String> numberMap2Reverse = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(Function.identity(), x -> "Number is " + x));
        log.info("numberMap2Reverse : {}", numberMap2Reverse);

        // 키는 userId로, value는 User 엔티티 자체를 사용
        List<User> users = User.getExamUserList();
        Map<Long, User> userIdToUserMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        log.info("userIdToUserMap : {}", userIdToUserMap);
    }
}
