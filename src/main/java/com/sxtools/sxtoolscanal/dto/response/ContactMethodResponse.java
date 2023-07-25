package com.sxtools.sxtoolscanal.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMethodResponse {

    public int contactMethodId;
    public String name;
    public String description;
    public boolean active;
    public String createDate;
    public String createUser;
    public String updateDate;
    public String updateUser;
}
