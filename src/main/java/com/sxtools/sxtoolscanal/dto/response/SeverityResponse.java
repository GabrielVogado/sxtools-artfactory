package com.sxtools.sxtoolscanal.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeverityResponse {

    public Integer severityId;
    public String name;
    public String description;
    public Boolean active;
    public Integer hour;
    public Integer tenantId;
    public Integer groupId;
    public String createDate;
    public String createUser;
    public String updateDate;
    public String updateUser;
}
