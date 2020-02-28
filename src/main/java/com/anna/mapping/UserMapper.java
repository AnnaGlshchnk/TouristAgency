package com.anna.mapping;

import com.anna.model.dto.UserDetail;
import com.anna.model.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserMapper {

    public Set<UserDetail> mapUserEntityToUsersDetail(List<User> users) {

        Set<UserDetail> userDetailSet = new HashSet<>();
        users.forEach(user -> {
            UserDetail userDetail = new UserDetail();
            ;
            userDetail.setName(user.getName());
            userDetail.setSurname(user.getSurname());
            userDetail.setPassportId(user.getPassportId());
            userDetailSet.add(userDetail);
        });

        return userDetailSet;
    }

    public UserDetail mapUserEntityToUserDetail(Optional<User> user) {

        UserDetail userDetail = null;
        if (user.isPresent()) {
            userDetail = new UserDetail();

            userDetail.setName(user.get().getName());
            userDetail.setSurname(user.get().getSurname());
            userDetail.setPassportId(user.get().getPassportId());
        }
        return userDetail;
    }
}
