## What is UIAutomator2 or XCUITest drivers

It allows to create User interface tests that invokes user interaction across multiple apps, which let's us to verify correct behaviour of our app when user flows into others apps or to the system UI.

 

### SendKeys

  - ```sh
    # Using Actions class
    Actions a = new Actions(getDriver());
    getDriver.findElementByClassName("Xpath");
    a.sendKeys("Test");
    ```
  - ```sh
    # Using Keyboard
    getDriver().getKeyboard().sendKeys(username);
    ```
  - ```sh
    # Using Default SendKeys
    getDriver().findElement(inputField).sendKeys("");
    ```