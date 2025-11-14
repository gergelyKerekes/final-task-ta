package com.epam.training.gergely_kerekes.model;

public final class Users {

    private Users() {}

    public static Credentials standardUser() {
        return new Credentials("standard_user", "secret_sauce");
    }
}
