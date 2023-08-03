package com.ymwoo.stream.function;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

@Slf4j
public class FunctionTest {

    @Test
    void case1() {
        Function<Integer, Integer> myAdder = new Adder();
        int result = myAdder.apply(5);
        log.info("result : {}", result);
    }

    public static class Adder implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer integer) {
            return integer + 10;
        }
    }
}
