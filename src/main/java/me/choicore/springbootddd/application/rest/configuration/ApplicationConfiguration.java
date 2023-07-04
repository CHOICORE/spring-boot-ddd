package me.choicore.springbootddd.application.rest.configuration;


import me.choicore.springbootddd.domain.user.service.ModifyUserProfileService;
import me.choicore.springbootddd.domain.user.service.QueryUserProfileService;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserInMemoryDb;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.UserManagementInMemoryAdapter;
import me.choicore.springbootddd.infrastructure.persistence.inmemory.user.mapper.PersistenceInMemoryUserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModifyUserProfileService modifyUserProfileService() {
        return new ModifyUserProfileService(new UserManagementInMemoryAdapter(new UserInMemoryDb(), new PersistenceInMemoryUserMapper()));
    }

    @Bean
    public QueryUserProfileService queryUserProfileService() {
        return new QueryUserProfileService(new UserManagementInMemoryAdapter(new UserInMemoryDb(), new PersistenceInMemoryUserMapper()));
    }

}
