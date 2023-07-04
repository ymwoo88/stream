package com.ymwoo.stream.collector.groupingby;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class StreamGroupingByTest {

    @Test
    @DisplayName("연산용 그룹핑 케이스")
    void case1() {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
        Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
                // 10으로 나눈 나머지가 같은 것들끼리 List로 만들고, 키는 나머지값, value는 나머지 값이 일치하는 데이터로 만든 리스트
                .collect(Collectors.groupingBy(number -> number % 10));
        log.info("result = {}", unitDigitMap);

        Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
                // value값을 리스트가 아닌 Set 컬렉션으로 만들기
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        log.info("result = {}", unitDigitSet);

        Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10,
                        // value값을 데이터 그대로 넣지 않고 mapping으로 가공한 뒤 해당 데이터를 리스트로 만들어 value로 저장
                        Collectors.mapping(number -> "unit digit is " + number, Collectors.toList())));
        log.info("result = {}", unitDigitStrMap.get(3));
    }

    @Test
    @DisplayName("객체 그룹핑 케이스")
    void case2() {
        List<User> examUserList = User.getExamUserList();

        Map<Boolean, List<User>> isWorkGroup = examUserList.stream()
                .collect(Collectors.groupingBy(User::getIsWorking));

        // isWorking 이 true, false 키 기준으로 사용자가 그룹핑 결과가 되어있다.
        isWorkGroup.keySet()
                .forEach(key -> log.info("key = [{}], value = {}" , key, isWorkGroup.get(key)));
    }
}
