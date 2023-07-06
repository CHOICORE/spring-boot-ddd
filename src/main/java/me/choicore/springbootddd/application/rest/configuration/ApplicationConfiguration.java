package me.choicore.springbootddd.application.rest.configuration;


import me.choicore.springbootddd.domain.service.AuthenticationService;
import me.choicore.springbootddd.domain.service.ModifyUserProfileService;
import me.choicore.springbootddd.domain.service.QueryUserProfileService;
import me.choicore.springbootddd.domain.service.UserManagementService;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserInMemoryDb;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserManagementInMemoryAdapterDrivenDriven;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.mapper.PersistenceInMemoryUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserManagementService userManagementService() {
        return new UserManagementService(
                userManagementInMemoryAdapter(), userManagementInMemoryAdapter()
        );
    }


    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationService(
                null, null
        );
    }


    @Bean
    public ModifyUserProfileService modifyUserProfileService() {
        return new ModifyUserProfileService(
                userManagementInMemoryAdapter()
        );
    }

    @Bean
    public QueryUserProfileService queryuserprofileservice() {
        return new QueryUserProfileService(
                userManagementInMemoryAdapter()
        );
    }

    private UserManagementInMemoryAdapterDrivenDriven userManagementInMemoryAdapter() {
        return new UserManagementInMemoryAdapterDrivenDriven(
                new UserInMemoryDb(), new PersistenceInMemoryUserMapper()
        );
    }

}
