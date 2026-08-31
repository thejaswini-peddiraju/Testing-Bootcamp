package utils;

// ====================== CONFIGURATION ======================
// Test Cases 2 (Login - correct credentials), 4 (Logout), and 5 (Register
// with an existing email) all need ONE real account that stays registered
// between runs (unlike the account Test Case 1 creates and deletes itself).
//
// ONE-TIME MANUAL SETUP:
//   1. Open http://automationexercise.com in your browser.
//   2. Sign up for a new account with a real name/email/password.
//   3. Do NOT delete it - leave it registered.
//   4. Put that same name, email and password below.
// =============================================================
public class TestConfig {

    public static final String REGISTERED_NAME = "CBIT QA";
    public static final String REGISTERED_EMAIL = "REPLACE_WITH_YOUR_REGISTERED_EMAIL@example.com";
    public static final String REGISTERED_PASSWORD = "REPLACE_WITH_YOUR_PASSWORD";

    // Used only for Test Case 3 (login with WRONG credentials).
    // Any values that don't belong to a real account work fine - no setup needed.
    public static final String INVALID_EMAIL = "wrong_user_12345@example.com";
    public static final String INVALID_PASSWORD = "WrongPassword123";
}
