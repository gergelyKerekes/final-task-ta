package com.epam.training.gergely_kerekes.model;

/**
 * Simple value object holding login credentials.
 */
public class Credentials {

    private final String username;
    private final String password;

    /**
     * Creates a new credential holder
     *
     * @param username username value
     * @param password password value
     */
    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username
     *
     * @return username String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password
     *
     * @return password String
     */
    public String getPassword() {
        return password;
    }
}
