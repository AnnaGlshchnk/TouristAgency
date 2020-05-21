package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetailDto {

    @NotNull(message = "The name shouldn't be empty")
    @Size(min = 2, max = 40, message
            = "Name should be between 2 and 40 characters")
    private String name;

    @NotNull(message = "The surname shouldn't be empty")
    @Size(min = 2, max = 40, message
            = "Surname should be between 2 and 40 characters")
    private String surname;

    @NotNull(message = "The passportId shouldn't be empty")
    @Pattern(regexp = "^(?!^0+$)[a-zA-Z0-9]{3,20}$")
    private String passportId;
}
