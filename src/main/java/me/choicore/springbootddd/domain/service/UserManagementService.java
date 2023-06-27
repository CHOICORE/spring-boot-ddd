package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.model.CreateUser;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.domain.ports.in.usecase.CreateUserUseCase;
import me.choicore.springbootddd.domain.ports.in.usecase.DeleteUserUseCase;
import me.choicore.springbootddd.domain.ports.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.ports.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.ports.out.CreateUserPort;
import me.choicore.springbootddd.domain.ports.out.DeleteUserPort;
import me.choicore.springbootddd.domain.ports.out.ModifyUserPort;
import me.choicore.springbootddd.domain.ports.out.UserProfilePort;

import java.util.Optional;


@RequiredArgsConstructor
public class UserManagementService implements
        CreateUserUseCase
        , GetUserProfileQuery
        , ModifyUserProfileUseCase
        , DeleteUserUseCase {

    private final UserProfilePort userProfilePort;
    private final CreateUserPort createUserPort;
    private final ModifyUserPort modifyUserPort;
    private final DeleteUserPort deleteUserPort;


    @Override
    public CreateUser register(CreateUser domain) {
        if (createUserPort.existsByUsername(domain.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }

        Optional<CreateUser> createdUser = createUserPort.createBy(domain);

        return createdUser.orElseThrow(() -> new IllegalArgumentException("사용자 등록 실패"));
    }

    @Override
    public UserProfile modifyUserProfile(UserProfile user) {
        return modifyUserPort.modifyBy(user);
    }

    @Override
    public void deleteUser(Long userId) {
        deleteUserPort.deleteById(userId);
    }


    @Override
    public UserProfile getUserProfile(Long userId) {
        return userProfilePort.findById(userId);
    }
}
