Recurly Java Integration Library - Sample Application
=====================================================

Recurly JS Client Library
-------------------------

Recurly.js is a Javascript library which allows you to easily embed and customize PCI compliant forms within
your website. HMAC digital signatures are used to verify information sent to Recurly via your user's browser.
The signature validates that parameters you have specified in your HTML have not been tampered with before
being received by Recurly. The [Recurly JS Client Library](https://github.com/tfoxcroft/recurly_integration)
consists of helper methods to create and verify signatures.


The Sample Application
-----------------------

The sample application is a simple Spring Roo application which follows the Maven project structure.


Running The Sample Application
------------------------------

Assuming you have maven installed, start the sample application by running the following from the root directy of the
project:

    mvn tomcat:run

Open a browser and go to
[http://localhost:8080/recurly-integration-sample-app](http://localhost:8080/recurly-integration-sample-app)