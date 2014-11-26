#Continuous delivery on PaaS

Simple JAX-RS example to be used during Codemotion continuous delivery on PaaS roundtable.

## Usage

Run unit tests
```
mvn test
```

Create war package
```
mvn clean install
```

Run acceptance tests
```
mvn -Dtest=**/*AcceptanceTest.java -DbaseUrl={deployed application base url} test
```

## Development environment setup

1. Make sure you have Java 1.7.
2. Install [gcloud](https://cloud.google.com/sdk/gcloud/).
3. Install components to run Java apps with `gcloud components update pkg-java app`
4. Build the app with `mvn package`, this will also run unit tests.
5. If you run the app locally with `gcloud preview app run target/cd-on-paas`,
   you should be seeing a 'hello world' on http://localhost:8080/hello.

## Setup Continuous Deployment on Travis-CI

1. Create a new project on [Google Developers Console](https://console.developers.google.com)
   if you don't have one and remember your Project ID.
2. Create a new [Service Account](https://developers.google.com/accounts/docs/OAuth2ServiceAccount#creatinganaccount)
   which you'll use to deploy from Travis-CI. The result is having two things:
     * Email address of the service account (usually ends with `@developer.gserviceaccount.com`).
     * P12 key file (usually starts downloading automatically as soon as you create it).
3. [Login with Travis-CI](https://github.com/travis-ci/travis.rb#login)
   and [encrypt the p12 key file](http://docs.travis-ci.com/user/encrypting-files/)
   with `travis encrypt-file path/to/my-key-file.p12`. Copy the decryption command.
4. Replace `PROJECT_ID=plasma-cascade-621` with your Project ID in [.travis.yml](.travis.yml).
   Also replace completely the line that starts with `- openssl ...` with the decryption command obtained
   in the previous step, while leaving `$PROJECT_ID` as is. The command assumes that your p12 file
   is named after the Project ID.
5. Replace `plasma-cascade-621` part of `<application>plasma-cascade-621</application>` with your Project ID
   in [appengine-web.xml](src/main/webapp/WEB-INF/appengine-web.xml).

That's it. You should be good to go: navigate to https://travis-ci.org/profile, select your GitHub project
and enable build.

As soon as you push a new commit to GitHub, Travis will start the build process and everything goes well,
a new version of your app will be deployed to `https://prod-dot-<project-id>.appspot.com`.

If you also set `prod` version as the default, the newly deployed version will always be available
at the `https://<project-id>.appspot.com` or your custom domain.

