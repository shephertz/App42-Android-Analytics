App42-Android-Analytics
=======================

# About Sample App

Sample App demonstrate how one  can capture user activity in your Android app using App42  analytics feature which includes page/activity view and total time spend on particular activity. Here are the steps to build and run this application.


# Build And Run

1. Register with App42 platform.
2. Go to the dashboard and click on the Create App button.
3. Fill all the mandatory fields and get your APIKey and SecretKey.
4. Download App42 Android sample app and unzip it on your machine .
4. Open this Sample App in your eclipse IDE.
5. Open the Constants.java in src of the package(app42Sample) and put your APIKey and SecretKey (which were received in step#2 & #3).
6. Build and Run Sample App.
7. This will open up login cum registration screen. Your app user needs to either login or register if using first time.
Once user is logged in he will be landed to MainActivity page, click on Next button on this page and user will be navigated to SecondActivity. Similarly from SecondActivity user will be navigated to ThirdActivity screen.
8. Go to AppHQ Console , click on User Activity Tab on dashboard and you should be able to see complete trace of user activity. This will show you how much time (in second) was spend by your app user on each activity in the tabular view as well as which activity is being viewed more in the pie chart.
