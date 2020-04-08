package com.avl.sonar.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NoticeDto {

  private UUID id;
  private String message;
  private String sendFrom;
  private String sendTo;
}
