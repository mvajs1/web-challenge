package com.automationpractice.data;

import com.automationpractice.data.models.RegisterAccount;
import com.github.javafaker.Faker;
import java.time.ZoneId;

public class DataProvider {

    private final Faker faker;

    public DataProvider() {
        faker = new Faker();
    }

    public RegisterAccount getRandomRegisterAccountData() {
        return new RegisterAccount.RegisterAccountBuilder()
                .title(String.valueOf(faker.number().numberBetween(1, 2)))
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().safeEmailAddress())
                .password(faker.internet().password(5, 10))
                .dateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .signUpForNewsletter(faker.bool().bool())
                .receiveOffers(faker.bool().bool())
                .addressFirstName(faker.name().firstName())
                .addressLastName(faker.name().lastName())
                .companyName(faker.company().name())
                .addressLine1(faker.address().streetAddress())
                .addressLine2(faker.address().streetAddress())
                .city(faker.address().cityName())
                .state(String.valueOf(faker.number().numberBetween(1, 50)))
                .postalCode(faker.number().digits(5))
                .country(String.valueOf(21))
                .additionalInformation(faker.lorem().sentence())
                .homePhone(faker.number().digits(8))
                .mobilePhone(faker.number().digits(8))
                .addressAlias(faker.name().username())
                .build();
    }
}
