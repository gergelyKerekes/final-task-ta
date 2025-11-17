package com.epam.training.gergely_kerekes.model;

/**
 * Factory class for predefined user credentials.
 */
public final class Users {

    private Users() {}

    /**
     * Returns the deafult standard user credentials
     *
     * @return standard user credentials
     */
    public static Credentials standardUser() {
        return new Credentials("standard_user", "secret_sauce");
    }
}
