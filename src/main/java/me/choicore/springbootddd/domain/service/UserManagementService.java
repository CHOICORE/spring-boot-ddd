package me.choicore.springbootddd.domain.service;

import lombok.RequiredArgsConstructor;
import me.choicore.springbootddd.domain.model.CreateUserProfile;
import me.choicore.springbootddd.domain.model.ModifyUserProfile;
import me.choicore.springbootddd.domain.model.QueryUserProfile;
import me.choicore.springbootddd.domain.model.UserProfile;
import me.choicore.springbootddd.domain.ports.in.usecase.CreateUserUseCase;
import me.choicore.springbootddd.domain.ports.in.usecase.DeleteUserUseCase;
import me.choicore.springbootddd.domain.ports.in.usecase.GetUserProfileQuery;
import me.choicore.springbootddd.domain.ports.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.ports.out.CreateUserPort;
import me.choicore.springbootddd.domain.ports.out.DeleteUserPort;
import me.choicore.springbootddd.domain.ports.out.ModifyUserPort;
import me.choicore.springbootddd.domain.ports.out.UserProfilePort;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p> User management service implementation.
 *
 * <p> This class implements the following use cases:
 * <ul>
 *     <li> {@link CreateUserUseCase}
 *     <li> {@link GetUserProfileQuery}
 *     <li> {@link ModifyUserProfileUseCase}
 *     <li> {@link DeleteUserUseCase}
 * </ul>
 */
@Service
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
    public UserProfile createBy(CreateUserProfile domain) {
        return createUserPort.createBy(domain);
    }

    @Override
    public UserProfile modifyUserProfile(ModifyUserProfile user) {
        return modifyUserPort.modifyBy(user);
    }

    @Override
    public void deleteById(Long userId) {
        deleteUserPort.deleteById(userId);
    }

    @Override
    public UserProfile getUserProfile(Long userId) {
        return userProfilePort.findById(userId);
    }

    @Override
    public List<UserProfile> getUserProfiles(QueryUserProfile queryUserProfile) {
        return userProfilePort.findBy(queryUserProfile);
    }
}
