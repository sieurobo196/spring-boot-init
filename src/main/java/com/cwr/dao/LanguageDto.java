package com.cwr.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDto {
    private String name;
    private String description;
    private String url;
}
