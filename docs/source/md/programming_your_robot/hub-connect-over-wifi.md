# Hub Connect Over Wi-Fi

This is somewhat of a complex process and will require a lot of steps:

* Make sure ADB is installed on your computer
  * Check that it is installed by typing adb in your terminal and hitting enter, if it reports anything you are good to go, if it says `adb command not found`, continue with setting it up
    * [https://www.xda-developers.com/install-adb-windows-macos-linux/](https://www.xda-developers.com/install-adb-windows-macos-linux/)
* Open Android Studio Settings
* Open up the external tools portion

![screenshot](etools.png)

* Hit the + button to add an external tool

![](menu.png)

* Fill out the description and activities for the tool
  * Name: HUB connect over Wi-Fi direct
  * Program: `$ModuleSdkPath$/platform-tools/adb`
  * Arguments: `connect 192.168.43.1:5555`
  * Working Directory: `$ProjectFileDir$`
* Then hit OK and Apply and then you can close the settings

Now we will add this tool to your toolbar for ease of use:

* Right-click on your toolbar

![](toolbar.png)

* Click customize toolbar
* Click + and "add action..." ![](addAction.png)
* Select the external tool we just made and choose the icon you want

![](etool2.png)

* Hit OK and move it to where you want it to be ordered in your toolbar
* Simply connect to your robot's Wi-Fi and hit the button to connect to it wireless!
