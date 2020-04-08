package com.avl.sonar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseResponse {

  private Object data;

  public static BaseResponse create(Object data){
    return new BaseResponse(data);
  }
}
