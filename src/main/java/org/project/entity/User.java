package org.project.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private String email;
    private UserSecurityInfo userSecurityInfo;
    private List<SignaturedSequence> signaturedFiles;
}
