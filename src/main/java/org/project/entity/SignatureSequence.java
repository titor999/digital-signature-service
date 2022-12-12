package org.project.entity;

import java.security.Signature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignatureSequence {
    private byte sequence;
    private Signature signature;
}
