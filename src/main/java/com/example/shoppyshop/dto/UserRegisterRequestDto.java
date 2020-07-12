package com.example.shoppyshop.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegisterRequestDto {
  @NotNull @NotEmpty private String username;

  @NotNull @NotEmpty private String password;
}
