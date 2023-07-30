package com.sxtools.sxtoolscanal.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CanalResponse {

    public Integer channelId;
    public String name;
    public String description;
    public Boolean active;
    public Integer tenantId;
    public Integer groupId;
    public String createDate;
    public String createUser;
    public String updateDate;
    public String updateUser;
}
