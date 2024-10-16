ThisThis project automates two primary tasks:
1. **Amazon product search and filtering** using **Selenium-Java**.
2. **API tests** for login and identity verification using **Rest-Assured**.

The project is designed to be easily extensible and maintainable, featuring:
- **Page Object Model (POM)** for Selenium tests.
- **Data-driven testing** using Excel files.
- **API testing** using Rest-Assured.
- Full **Maven** integration for dependency management.
## Prerequisites

Before running the project, ensure you have the following installed:
1. **Java 8 or higher**
2. **Apache Maven** for managing dependencies
3. **Google Chrome** (browser for Selenium automation)
4. **ChromeDriver** (automatically handled by WebDriverManager)
5. **Git** (for cloning the repository)

## Step 1: Clone the Repository

To clone this project to your local machine, run the following command:

```bash
git clone https://github.com/yourusername/senior_automation_task.git

Navigate to the project directory:
cd senior_automation_task

To install all necessary dependencies, run the following Maven command:
mvn clean install

Run All Tests:
mvn test

Run Specific Test:
mvn -Dtest=AmazonTest test

for API tests:
mvn -Dtest=FoodicsLoginAPITest test

The test results are generated by TestNG and can be found in the target/surefire-reports directory. This folder contains:

Test summaries: Lists of passed/failed tests
Detailed logs: Information on errors and exceptions
