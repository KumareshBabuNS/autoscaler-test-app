# autoscaler-test-app
Sample application to demonstrate autoscaling service

# How to use this application

- Clone the repo https://github.com/pivotalservices/autoscaler-test-app
- Perform a Maven build `mvn package`
- Push this application to your cloud foundry instance `cf push autoscaler-test-app -p target/autoscaler-test-app-0.0.1-SNAPSHOT.jar`
- Create the app-autoscaler service in your space `cf cs app-autoscaler gold app-autoscaler-service`
- Bind the `app-autoscaler-service` service to the application `cf bs autoscaler-test-app  app-autoscaler-service`
- Restage your application `cf restage autoscaler-test-app`
- On your developer console, specify the rules for the app-autoscaler service. So select the service and then click manage
- Turn on autoscaling service, and specify the rules

For a simple test, set the min to 1 and CPU to 5%, and max to 3 and CPU can be anything.

Now access the application and specify the number of threads: for ex

- http://autoscaler-test-app.cfapps.pivotal.io/scale/300

If you go with a higher number, chances are you might run into OOM issues, so restart the application, and access the application concurrenctly from multiple tabs in your browser

You should find the application scale up automatically as the CPU usage is increasing. Once the CPU is back to normal, the application instances would scale down.

Autoscaler works!!

Enjoy!!
