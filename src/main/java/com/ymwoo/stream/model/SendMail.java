package com.ymwoo.stream.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class SendMail {

    private String sender;
    private String to;

    public static SendMail valueOf(final String sender,
                                   final String to) {
        return SendMail.builder()
                .sender(sender)
                .to(to)
                .build();
    }
}
