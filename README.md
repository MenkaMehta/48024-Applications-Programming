# 48024 Applications Programming 
## UTS AUTUMN 2016 ##

ICT Design – Intelligent Restaurant System

 
This document will introduce how to set up the development environment for this robot on Android Studio. NB: Development can be done on Eclipse as well.

HARDWARE PROFILE
Recommended:
•	CPU: 3.40GHz dual-core or higher
•	Resolution: 1920x1080
•	RAM:8G
•	Ubuntu:14.04 LTS or higher
•	Windows: Win7 or Win10

ENVIRONMENT SETUP
JDK: The JDK version should be 1.6 at least
SDK: Download SDK version 4.4 for Windows/Linux 

SETUP SDK
	Download and Install Android Studio IDE latest version 3.1.3

	Go to File->Settings->System-Settings and set up Avatarmind SDK Path
NB: Avatarmind Robot Operating System is in-depth customization on Android 4.4 Platform. Please do not update SDK. If updated, it may cause unpredictable errors.

	Optional: You can set up a custom virtual machine on Android Studio. There are many resources available explaining on how to set up a virtual device on this IDE.

TEST-PROJECT 
Now let us create a new project and set up further development environment on Android Studio. We use the normal procedures to create new project on Android Studio, but the following should be taken into consideration in order to avoid problems later on.
	Device selection should be “Phone and Tablet” with minimum SDK: API 19: Android 4.4 (KitKat)
	Do not select Backwards Compatibility (AppCompat) option
	Compile SDK version should be Android 4.4 (Kitkat) and Build tools version: 27.0.3
	Gradle version: 4.4 and Android Plugin version: 3.1.3
	Build the program: Build->Make Project
	If your code compiles with no errors, then you are good to start writing a program to be tested on the Robot
INSTALL APPLICATION ON THE ROBOT
In order to install application developed on the robot, the following should be done.
	Connect Robot and your PC/Laptop via USB Cable
	Build and compile your program to make sure there are no errors
	Run the program: Run-> Run ‘app’, on Android Studio
	Select connected device as shown in the screenshot below and click OK

 

Written by Menka Mehta


