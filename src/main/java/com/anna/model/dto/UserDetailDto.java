package com.anna.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetailDto {

    private String name;
    private String surname;
    private String passportId;
}
