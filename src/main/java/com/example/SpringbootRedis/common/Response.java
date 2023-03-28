package com.example.SpringbootRedis.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private Object data;
    private String message;
    private Integer status;
}
