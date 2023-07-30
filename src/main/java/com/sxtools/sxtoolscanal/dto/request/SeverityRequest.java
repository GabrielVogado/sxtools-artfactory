package com.sxtools.sxtoolscanal.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeverityRequest {

    public String name;
    public String description;
    public Boolean active;
    public Integer hour;
    public Integer tenantId;
    public Integer groupId;
}
