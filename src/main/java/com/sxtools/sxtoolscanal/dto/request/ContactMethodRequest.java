package com.sxtools.sxtoolscanal.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMethodRequest {

    public String name;
    public String description;
    public boolean active;
}
