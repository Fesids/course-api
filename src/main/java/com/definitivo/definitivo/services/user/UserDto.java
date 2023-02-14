package com.definitivo.definitivo.services.user;

import com.definitivo.definitivo.Enum.EnumRole;
import com.definitivo.definitivo.models.User;
import com.definitivo.definitivo.utils.GeralUtillities;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record UserDto(

        @NotNull @NotEmpty @Email String email,
        @NotNull @NotEmpty @Length(min = 5, max = 15) String username,
        @NotNull @NotEmpty @Length(min = 6, max = 25) String password
) {

    public User addCostumer(UserDto userDto){
        return new User(null, this.email, this.username, GeralUtillities.encode(password),
                LocalDateTime.now(),
                LocalDateTime.now(), EnumRole.COSTUMER);


    }

    public User addAdmin(UserDto userDto){
        return new User(null, null, this.username, GeralUtillities.encode(this.password),
                LocalDateTime.now(),
                LocalDateTime.now(), EnumRole.ADMIN);


    }

    public User addStaff(UserDto userDto){
        return new User(null, this.email, this.username, GeralUtillities.encode(this.password),
                LocalDateTime.now(),
                LocalDateTime.now(), EnumRole.STAFF);


    }
}
