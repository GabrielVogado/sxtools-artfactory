package com.sxtools.sxtoolscanal.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeverityRequest {

    public String name;
    public String description;
    public boolean active;
    public int hour;
    public int tenantId;
    public int groupId;
}
