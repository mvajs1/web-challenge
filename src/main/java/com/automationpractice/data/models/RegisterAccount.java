package com.automationpractice.data.models;

import java.time.LocalDate;

public class RegisterAccount {
    private String title;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDate dateOfBirth;
    private Boolean signUpForNewsletter;
    private Boolean receiveOffers;
    private String addressFirstName;
    private String addressLastName;
    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getSignUpForNewsletter() {
        return signUpForNewsletter;
    }

    public Boolean getReceiveOffers() {
        return receiveOffers;
    }

    public String getAddressFirstName() {
        return addressFirstName;
    }

    public String getAddressLastName() {
        return addressLastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public RegisterAccount(String title, String firstName, String lastName, String password, String email,
            LocalDate dateOfBirth, Boolean signUpForNewsletter, Boolean receiveOffers, String addressFirstName,
            String addressLastName, String companyName, String addressLine1, String addressLine2, String city,
            String state, String postalCode, String country, String additionalInformation, String homePhone,
            String mobilePhone, String addressAlias) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.signUpForNewsletter = signUpForNewsletter;
        this.receiveOffers = receiveOffers;
        this.addressFirstName = addressFirstName;
        this.addressLastName = addressLastName;
        this.companyName = companyName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.additionalInformation = additionalInformation;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.addressAlias = addressAlias;
    }

    public static class RegisterAccountBuilder {
        private String title;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private LocalDate dateOfBirth;
        private Boolean signUpForNewsletter;
        private Boolean receiveOffers;
        private String addressFirstName;
        private String addressLastName;
        private String companyName;
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String state;
        private String postalCode;
        private String country;
        private String additionalInformation;
        private String homePhone;
        private String mobilePhone;
        private String addressAlias;

        public RegisterAccountBuilder title(String title) {
            this.title = title;
            return this;
        }

        public RegisterAccountBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public RegisterAccountBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public RegisterAccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterAccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterAccountBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public RegisterAccountBuilder signUpForNewsletter(Boolean signUpForNewsletter) {
            this.signUpForNewsletter = signUpForNewsletter;
            return this;
        }

        public RegisterAccountBuilder receiveOffers(Boolean receiveOffers) {
            this.receiveOffers = receiveOffers;
            return this;
        }

        public RegisterAccountBuilder addressFirstName(String addressFirstName) {
            this.addressFirstName = addressFirstName;
            return this;
        }

        public RegisterAccountBuilder addressLastName(String addressLastName) {
            this.addressLastName = addressLastName;
            return this;
        }

        public RegisterAccountBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public RegisterAccountBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public RegisterAccountBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public RegisterAccountBuilder city(String city) {
            this.city = city;
            return this;
        }

        public RegisterAccountBuilder state(String state) {
            this.state = state;
            return this;
        }

        public RegisterAccountBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public RegisterAccountBuilder country(String country) {
            this.country = country;
            return this;
        }

        public RegisterAccountBuilder additionalInformation(String additionalInformation) {
            this.additionalInformation = additionalInformation;
            return this;
        }

        public RegisterAccountBuilder homePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public RegisterAccountBuilder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public RegisterAccountBuilder addressAlias(String addressAlias) {
            this.addressAlias = addressAlias;
            return this;
        }

        public RegisterAccount build() {
            return new RegisterAccount(title, firstName, lastName, password, email,
                    dateOfBirth, signUpForNewsletter, receiveOffers, addressFirstName,
                    addressLastName, companyName, addressLine1, addressLine2, city,
                    state, postalCode, country, additionalInformation, homePhone,
                    mobilePhone, addressAlias);
        }
    }
}
