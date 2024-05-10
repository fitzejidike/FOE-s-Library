package org.africa.semicolon.dtos.Requests;

import lombok.Data;

@Data
public class GetBookInfoRequest {
    public String title;
    public String author;
    public String introduction;


}
