package com.ms.user.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String name,
                            @NotBlank @Email String email) {
}
