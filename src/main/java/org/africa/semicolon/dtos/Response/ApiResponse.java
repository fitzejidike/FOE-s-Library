package org.africa.semicolon.dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private Boolean IsSuccessful;
    private Object data;
}
