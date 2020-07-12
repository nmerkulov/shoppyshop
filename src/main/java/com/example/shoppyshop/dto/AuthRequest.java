package com.example.shoppyshop.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequest {
  @NotNull private String username;

  @NotNull
  @NotEmpty(message = "please provide password")
  private String password;
}
