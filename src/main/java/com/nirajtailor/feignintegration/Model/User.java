package com.nirajtailor.feignintegration.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    Long id;
    String name;
    String email;
    String mobile;
}
