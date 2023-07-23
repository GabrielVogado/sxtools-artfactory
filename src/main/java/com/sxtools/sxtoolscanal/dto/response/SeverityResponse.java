package com.sxtools.sxtoolscanal.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeverityResponse {

    public int severityId;
    public String name;
    public String description;
    public boolean active;
    public int hour;
    public int tenantId;
    public int groupId;
    public String createDate;
    public String createUser;
    public String updateDate;
    public String updateUser;
}
