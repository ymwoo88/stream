package com.ymwoo.stream.flatmap;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StreamFlatMapTest {

    @Test
    @DisplayName("유저목록에서 취미목록을 추출")
    void case1() {
        List<User> examUserList = User.getExamUserList();

        // 좋지 않은 예시
        List<List<String>> badHobbies = examUserList
                .stream()
                .map(User::getHobbies)
                .toList();
        List<String> badHobbiesSimpleList = new ArrayList<>();
        for (List<String> secondStream : badHobbies) { // List<List<>> 이중 List를 벗기기위해 2번의 for문이 필요하다
            for (String hobby : secondStream) {
                badHobbiesSimpleList.add(hobby);
            }
        }
        badHobbiesSimpleList.forEach(s -> log.info("[bad] Hobbies info : {}", s));

        // 좋은 예시
        List<String> goodHobbies = examUserList
                .stream()
                .map(User::getHobbies)
                .flatMap(secondStream -> secondStream.stream()) // 상위 첫 stream 흐름에서 두번 째 secondStream을 열었다 Stream<Stream<>> 이런 형태이다
                // 위 상황이 Stream<Stream<>> 이런 형태이다 여기서 flatMap으로 Stream<>형태로 짜부시켜 준것이다.
                .toList();
        goodHobbies.forEach(s -> log.info("[good] Hobbies info : {}", s));
    }
}
