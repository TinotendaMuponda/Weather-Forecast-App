package com.tinoprojects.weatherforecastapp.utility;

public class SecurityConstants {

    //    public static final long EXPIRATION_TIME = 432_000_000; // 5 days in milliseconds
    public static final long EXPIRATION_TIME = 216_000_00; // 6 hours in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String GET_ARRAYS_LLC = "Get Arrays, LLC";
    public static final String GET_ARRAYS_ADMINISTRATION = "User Management Portal";
    public static final String AUTHORITIES = "Authorities";
    public static final String UNAUTHORIZED_MESSAGE = "Login failed, Invalid credentials";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access the resource";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this resource";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = {"/user/login", "/user/resetpassword/**", "/user/image/**"};
    public static final String ANONYMOUS = "Anonymous user";
}