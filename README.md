This is a demo app which shows how to access Smartrecruiters jobs from 3rd party app using OAuth2 authentication scheme.

To run the app the easiest thing is to first install all the
artifacts using `mvn install` and then run `mvn tomcat7:run`.  You can also use the
command line to build war files with `mvn package` and drop them in
your favourite server, or you can run them directly from an IDE.

Visit `http://localhost:8080/oauth2-java-demo` in a browser and go to the
`jobs` tab.  The result should be:

* You are prompted to authenticate in the app (the login screen tells
  you the users available and their passwords)
  
* The correct authorization is not yet in place for `smartrecruiters` to access
  your jobs in `smartrecruiters` on your behalf, so app redirects your
  browser to the `smartrecruiters` UI to get the authorization.

* You are prompted to authenticate with `smartrecruiters`.

* Then `smartrecruiters` will ask you if you authorize app to access your
  jobs.
  
* If you say "yes" then your browser will be redirected back to app
  and this time the correct authorization is present, so you will be
  able to see your jobs.
