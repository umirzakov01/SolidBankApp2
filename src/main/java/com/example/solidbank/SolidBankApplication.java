package com.example.solidbank;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SolidBankApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AccountBasicCLI accountBasicCLI= context.getBean(AccountBasicCLI.class);
        printManual();
        Scanner scanner = new Scanner(System.in);
        String clientID="1";
        while (true) {
            System.out.println("> ");
            String number = scanner.nextLine();
            switch(number){
                case "1"-> accountBasicCLI.getAccounts(clientID);
                case "2" -> accountBasicCLI.createAccountRequest(clientID);
                case "3" -> System.out.println("Not yet");
                case "4" -> System.out.println("Not yet");
                case "5" -> System.out.println("Not yet");
                case "6" -> printManual();
                case "7" -> exit();


            }

        }
    }


        private static void printManual() {

            try {

                File readfile = new File("src/main/resources/manual.txt");
                Scanner scanner = new Scanner(readfile);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());

                }
                scanner.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        private static void exit(){
        System.out.println("System is closed");
        System.exit(0);
        }


    }
// comment