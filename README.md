# Dropwizard Braintree Application

A simple HTTP server using Dropwizard to play with Braintree's API. Braintree Payments is a simple, robust way to accept payments or enable commerce in your website.

### Configuration

Update `configuration.yml` file with your *sandbox* or *production* API keys from the Braintree's Control Panel.

```yml
braintree:
  environment: sandbox
  merchantId: # add merchant Id
  publicKey: # add public key
  privateKey: # add secret key
```

### Starting Application

Build everything via Maven.

```bash
mvn clean install
```

Finally, we can start the application using:

```bash
java -jar target/dropwizard-braintree-1.0-SNAPSHOT.jar server configuration.yml
```

Once the application starts up, you should be able to open a browser and hit the url, `http://localhost:9500`

### Improvements
1. Introduce Google Guice for Dependency Injection
2. Implement Logging
