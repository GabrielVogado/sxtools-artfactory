package com.sxtools.sxtoolscanal.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChannelRequest {

    public String name;
    public String description;
    public boolean active;
    public int tenantId;
    public int groupId;
}
