# Serenity BDD Automation Framework (Web & API)

## 🧩 Overview
This project represents an **automated testing framework** built with **Java** and **Serenity BDD**, designed to integrate **Web UI** and **API** tests in a single, maintainable solution.

The framework uses **Page Object Model (POM)** enhanced with **Page Factory**, ensuring clean structure, modularity, and scalability.  
It provides detailed **Serenity HTML reports** that combine UI screenshots and API request/response data.

---

## 🧠 Technology Stack

| Component | Technology |
|------------|-------------|
| Language | Java 11+ |
| Test Framework | Serenity BDD |
| Test Runner | JUnit 4 |
| Web Automation | Selenium WebDriver + Page Factory |
| API Testing | Serenity Rest (RestAssured) |
| Build Tool | Maven |
| Architecture | Page Object Model (POM) |
| Reporting | Serenity HTML Reports |

---
## Project Structure


- src
    - test
        - java
            - org.example.api.tests           # API test classes
            - org.example.features.tests      # Web test classes
            - org.example.pages               # Page Objects (Page Factory)
            - org.example.steps               # Step definitions
            - org.example.utils               # common resources
        - resources
            - api-samples                     # API json samples


---

## ⚙️ Setup & Installation

1. **Clone the project**
   ```bash
   git clone https://github.com/<user>/java-web-automation-project-serenity.git
   cd java-web-automation-project-serenity
 ---

## 🚀 Running Tests
🔹 Run Web Tests
- mvn clean verify -Pweb-tests

🔹 Run API Tests
- mvn clean verify -Papi-tests

🔹 Run All Tests (Web + API)
- mvn clean verify -Pall-tests

📊 Test Reports

After execution, Serenity generates detailed HTML reports:
- target/site/serenity/index.html

Reports include:
- Execution steps
- Screenshots for UI tests
- Request & response logs for API tests
- Result dashboards and success metrics

---

🧱 Page Object Model + Page Factory

Page Factory simplifies element initialization and promotes cleaner code:

```
public class LoginPage extends PageObject {
    @FindBy(id = "username")
    private WebElementFacade username;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    public void loginAs(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        clickOn(loginButton);
    }
}
```

🧪 Example Tests

API Test Example (Simplified)
```
@SerenityTest
public class GetProductsList extends BaseApiTest {

    @Test
    public void shouldReturnProductList() {
        Response response = SerenityRest.get("/products");
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getList("products")).isNotEmpty();
    }
}
```

Web UI Test Example

```
@SerenityTest
public class LoginTest extends BaseWebTest {

    @Test
    public void userCanLoginSuccessfully() {
        loginPage.open();
        loginPage.loginAs("admin", "password");
        Assert.assertTrue(dashboardPage.getWelcomeMessage()).contains("Welcome");
    }
}
```

---

### License & Author
Include license and author info:

```markdown
## License
MIT License

## Author
**Name:** Aura Scripcariu
**Role:** QA Automation Engineer  
**Contact:** TBD



