package com.codecool.mavens.util;

import com.codecool.mavens.repository.UserRepositoryMem;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean
    public UserRepositoryMem userRepositoryMem(){
        return new UserRepositoryMem();
    }
}
