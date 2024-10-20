package com.jojoldu.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GURES", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
