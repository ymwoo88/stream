package com.ymwoo.stream.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Boolean isWorking;
    private List<String> hobbies;


    public static User getUserAmil() {
        return User.builder()
                .id(1L)
                .name("amil")
                .email("amil@ymwoo.com")
                .age(28)
                .isWorking(true)
                .hobbies(List.of("골프", "영화감상"))
                .build();
    }

    public static User getUserBenny() {
        return User.builder()
                .id(2L)
                .name("benny")
                .email("benny@ymwoo.com")
                .age(26)
                .isWorking(true)
                .hobbies(List.of("골프", "낚시"))
                .build();
    }

    public static User getUserCho() {
        return User.builder()
                .id(3L)
                .name("cho")
                .email("cho@ymwoo.com")
                .age(33)
                .isWorking(false)
                .hobbies(List.of("등산", "캥핌"))
                .build();
    }

    public static List<User> getExamUserList() {
        return Arrays.asList(getUserAmil(), getUserCho(), getUserBenny());
    }
}
