# Getting Started

# Installation Setup

## Install JAVA JDK

-   Any JDK version which **above JDK 8** will work, Follow steps from [here] to install(https://www.guru99.com/install-java.html)

## Install Android Studio

  <!-- Helpful to launch Android Emulator -->

-   Android Studio download from [here](https://developer.android.com/studio)

## Install Homebrew(Only for Mac) (Optional)

-   Package Manager for macOS and is used to install software packages
-   Install it from [here](https://brew.sh/)

## Install Node.js and npm

-   Install Node.js from [here](https://nodejs.org/en/)

## Install Appium server(Appium CLI)

**Note:** _Latest Version is recommended_

    ```sh
    # install
    npm install -g appium

    # verify
    appium -v

    # path
    where appium
    ```

## Install Appium GUI and Inspector

-   Install Appium Inspector from [Here](https://github.com/appium/appium-inspector/releases)
    -   _Latest Version is recommended_
-   Install Appium GUI from [Here](https://github.com/appium/appium-desktop/releases). Although its not mandatory, as it is required to start the appium server that we can do from terminal through below command.

    -   Recommended Version `1.22.0`.

    ```sh
    # appium -p port-id
    appium -p 4723
    ```

**Note:** There might some issues while launching/Inspecting iOS Simulator wrt to WDA(WebDriverAgent). The primary reason is the Xcode build failure and this may varies from machine to machine(Completely dependent on machine, not installation or config issue).

## Set Environment Variables

**For MAC:**

-   If there is already `.zshrc` file created in your system, then skip this step, else create it.

    ```sh
    # create
    touch ~/.zshrc
    ```

-   Open `.zshrc` file to include environment variables, open terminal and run below command

    ```sh
    # open file
    nano ~/.zshrc
    ```

-   And now, Add this below lines to the editor.

    ```sh
    # adding environment variables
    export ANDROID_HOME=/Users/user-name/Library/Android/sdk
    export PATH=$PATH:$ANDROID_HOME/platform-tools
    export PATH=$PATH:$ANDROID_HOME/tools
    export PATH=$PATH:$ANDROID_HOME/tools/bin
    export PATH=$PATH:$ANDROID_HOME/emulator
    ```

-   Save it and close the editor/file. Now, Reopen terminal and verify:

    ```sh
    # Verify
    source ~/.zshrc
    echo $ANDROID_HOME
    ```

**Note:** _If you have to add this environment variables to different files like `zprofile` or `.bash_profile`, It will be a similar pattern, but follow any blog or stackoverflow for commands._

**For Windows:**

-   Add below environment variables:
    -   **ANDROID_HOME**: `C:\Users\username\AppData\Local\Android\Sdk` _(under User variables)_
    -   **ANDROID_HOME**: `C:\Users\username\AppData\Local\Android\Sdk` _(under System variables)_
    -   **ANDROID_SDK**: `C:\Users\username\AppData\Local\Android\Sdk` _(under System variables)_
    -   **ANDROID_SDK_ROOT**: `C:\Users\username\AppData\Local\Android\Sdk` _(under System variables)_
    -   **MAVEN_HOME**: `C:\Program Files\apache-maven-3.8.4\` _(under System variables)_
    -   **JAVA_HOME**: `C:\Program Files\Java\jdk1.8.0_202\` _(under System variables)_
    -   And Add **_SDK tools_ and _SDK Platform tools_** path as well under System variables.

## Verify installation using appium-doctor(Optional)

find more about [Appium Doctor](https://github.com/appium/appium-doctor)

    ```sh
    # install
    npm install -g appium-doctor

    # verify
    appium-doctor -h
    ```

## Emulator Setup

#### Android

-   Create a Virtual Device for Android from [here](https://www.geeksforgeeks.org/how-to-install-android-virtual-deviceavd/)

#### iOS

-   For iOS, all Simulators are installed bydefault along with Xcode.

-   To Launch iOS Simulator --> `Launch Xcode` > `Open Developer Tool` > `Simulator`.

-   Launch via Terminal --> Open Terminal and run this --> `open -a simulator` (This will launch previously launched simulator)

-   ```sh
    # List of available iOS Devices/Simulators
    # Device ID will be listed
    xcrun simctl list
    ```

-   ```sh
    # Available Device Type (Example: iPhone XR, iPhone 13 Pro)
    # Device ID will be listed
    xcrun simctl list devicetypes
    ```

-   ```sh
    # Create a new Simulator by providing the device name and type
    # xcrun simctl create device-name device-type
    xcrun simctl create "iPhone 13 Pro Max" "iPhone 13 Pro Max"
    ```

-   ```sh
    # If you know the deviceID(UDID), then you can launch directly by using below command
    open -a Simulator --args -CurrentDeviceUDID <YOUR-DEVICE-ID>
    # UDID of iPhone 13 Pro Max: 17C61FE7-FD0D-4E8E-B958-C42ACADDEC46
    ```

</br>
</br>

# Useful Commands

```sh
# list of available Emulators
emulator -list-avds

# Know the UDID of active devices or List of real devices attached currently
adb devices

# uninstall drivers on device
adb uninstall io.appium.uiautomator2.server
adb uninstall io.appium.uiautomator2.server.test
adb uninstall io.appium.unlock
adb uninstall io.appium.settings
```
