# Solution Steps

1. Create the UserRegistrationRequest model, applying JSR-380 validation annotations and custom messages for all input fields.

2. Implement UserRegistrationResponse DTO to structure successful registration responses.

3. Define the User JPA entity with a unique constraint on email and appropriate column lengths.

4. Create UserRepository extending JpaRepository with methods for checking/existence by email.

5. Write DuplicateEmailException as a custom runtime exception for service-layer duplicate detection.

6. Implement the UserService to handle registration logic: check for duplicates, hash the password, persist the user, and trigger background setup asynchronously.

7. Develop BackgroundUserSetupService, mark runBackgroundSetup as @Async, simulating non-blocking background work with logging.

8. Develop the UserRegistrationController, wiring up the POST /api/users/register endpoint. Inject UserService, validate requests with @Valid, and return UserRegistrationResponse on success.

9. Create ApiError and ApiError.FieldErrorDetail classes to represent a clear JSON error structure.

10. Develop GlobalExceptionHandler as @ControllerAdvice to handle validation errors, duplicate email exception, and other unhandled exceptions, returning proper HTTP status codes and JSON error responses.

11. Enable async in the main RegistrationApplication class using @EnableAsync.

12. Configure H2 in-memory database and logging in application.properties for development/inspection.

13. Test: POST valid/invalid payloads to /api/users/register. Confirm clear validation errors, no duplicates, successful registrations, and responsive API even when background setup is triggered.

