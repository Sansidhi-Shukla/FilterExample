﻿# FilterExample

 the file structure will be :-

filter-example/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── filterexample/
│   │   │               ├── FilterExampleApplication.java    # Main application class
│   │   │               ├── config/
│   │   │               │   └── FilterConfig.java            # Filter configuration with multiple filters
│   │   │               ├── filters/
│   │   │               │   ├── LoggingFilter.java           # Custom logging filter
│   │   │               │   └── AuthorizationFilter.java     # Custom authorization filter
│   │   │               ├── controllers/
│   │   │               │   └── StudentController.java       # Controller for student endpoints
│   │   └── resources/
│   │       └── application.properties                       # Application configuration (optional)
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── filterexample/
│                       └── FilterExampleApplicationTests.java  # Unit tests (optional)
└── pom.xml                                                 # Maven dependencies and project configuration



How It Works
Request Flow:

A request to /students/info passes through the LoggingFilter first, then the AuthorizationFilter, and finally reaches the StudentController.
Execution Order:

The LoggingFilter is executed first because it has a lower order (1).
The AuthorizationFilter is executed second because its order is higher (2).
Authorization Check:

If the request contains the header Role: STUDENT, it is allowed to proceed.
Otherwise, the AuthorizationFilter blocks the request with a "Unauthorized" response.
