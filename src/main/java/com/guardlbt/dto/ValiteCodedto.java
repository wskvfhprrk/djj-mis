package com.guardlbt.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ValiteCodedto {
    @NotBlank(message = "token不能为空值")
    private String token;
    @NotNull(message = "code不能为空值")
    private String code;
}
