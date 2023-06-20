package com.ymwoo.stream.foreach;

import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class StreamForeachTest {

    @Test
    @DisplayName("foreach 단순 돌리기")
    void case1() {
        List<User> examUserList = User.getExamUserList();

        examUserList.forEach(user -> log.info("user : {}", user));
    }
}
