package me.choicore.springbootddd.application.configuration;

import me.choicore.springbootddd.domain.authentication.out.persistence.CredentialsDrivenPort;
import me.choicore.springbootddd.domain.authentication.service.AuthenticationService;
import me.choicore.springbootddd.domain.user.in.usecase.ModifyUserProfileUseCase;
import me.choicore.springbootddd.domain.user.in.usecase.QueryUserProfileUseCase;
import me.choicore.springbootddd.domain.user.out.persistence.ModifyUserDrivenPort;
import me.choicore.springbootddd.domain.user.out.persistence.QueryUserDrivenPort;
import me.choicore.springbootddd.domain.user.service.ModifyUserProfileService;
import me.choicore.springbootddd.domain.user.service.QueryUserProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrivingPortConfiguration {

    @Bean
    public QueryUserProfileUseCase queryUserProfileUseCase(QueryUserDrivenPort queryUserDrivenPort) {
        return new QueryUserProfileService(queryUserDrivenPort);
    }

    @Bean
    public ModifyUserProfileUseCase modifyUserProfileUseCase(ModifyUserDrivenPort modifyUserDrivenPort) {
        return new ModifyUserProfileService(modifyUserDrivenPort);
    }

    @Bean
    public AuthenticationService authenticationService(CredentialsDrivenPort credentialsDrivenPort) {
        return new AuthenticationService(credentialsDrivenPort);
    }

}
