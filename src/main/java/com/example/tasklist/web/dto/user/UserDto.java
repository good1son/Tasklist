package com.example.tasklist.web.dto.user;

import com.example.tasklist.domain.user.ROLE;
import com.example.tasklist.web.dto.validation.OnCreate;
import com.example.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Set;

@Data
@Schema(description = "User DTO")
public class UserDto {

    @Schema(description = "User id", example = "1")
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "User name", example = "John DOe")
    @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class} )
    private String name;

    @Schema(description = "User email", example = "johndoe@gmail.com")
    @NotNull(message = "Username must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class} )
    private String username;

    @Schema(description = "User crypted password", example = "$2a$10$J3igxsBp2g353YSxySEbM.dp4QnW5nxtxQLjF4H9ocU/OWlqlQzna")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(description = "User password confirmation", example = "$2a$10$J3igxsBp2g353YSxySEbM.dp4QnW5nxtxQLjF4H9ocU/OWlqlQzna")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null", groups = {OnCreate.class})
    private String passwordConfirmation;

}
