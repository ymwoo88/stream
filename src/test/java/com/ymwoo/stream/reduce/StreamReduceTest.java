package com.ymwoo.stream.reduce;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class StreamReduceTest {

    @Test
    @DisplayName("초기값이 없는 경우")
    void case1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y) // stream의 데이터를 모두 더해서 반환
                .get();
        log.info("전체 합 : {}", sum);

        int min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y) // stream의 데이터 중 가장 작은 데이터 반환 -> min과 동일
                .get();
        log.info("최소 값 뽑기 : {}", min);
    }

    @Test
    @DisplayName("초기값이 존재하는 경우")
    void case2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .reduce(10, (x, y) -> x + y); // stream의 데이터를 모두 더해서 반환
        log.info("전체 합 : {}", sum);

        int min = numbers.stream()
                .reduce(10, (x, y) -> x < y ? x : y); // stream의 데이터 중 가장 작은 데이터 반환 -> min과 동일
        log.info("최소 값 뽑기 : {}", min);
    }
}
