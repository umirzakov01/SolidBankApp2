package com.example.solidbank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public MyCLI myCLI(){
        return new MyCLI();
    }
    @Bean
    public AccountDAO accountDAO(){
        return new MemoryAccountDAO();
    }
    @Bean
    public AccountCreationService accountCreation(){
        return new AccountCreationServiceImpl(accountDAO());
    }

    @Bean
    public AccountListingService accountListing(){
        return new AccountListingServiceImpl(accountDAO());
    }

   @Bean
    public BankCore bankCore(){
        return new BankCore(accountCreation());
   }
   @Bean
    public AccountBasicCLI accountBasicCLI(){
        return new AccountBasicCLI((CreateAccountOperationUI) myCLI(),bankCore(),accountListing());
   }

}
