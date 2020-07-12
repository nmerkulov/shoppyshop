package com.example.shoppyshop.dto;

import java.util.Collection;
import lombok.Data;

@Data
public class UserResponseDto {
  private String username;
  private Collection<String> roles;
}
