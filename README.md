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

## Development environment

Vagrant box provides:
- OpenJDK 1.7
- Maven 3
- Tomcat 7

### Requirements

1. [VirtualBox](https://www.virtualbox.org/)
2. [Vagrant](https://www.vagrantup.com/)
3. [Chef Development Kit](https://downloads.getchef.com/chef-dk/)

### Using vagrant box

Install vagrant plugins
```
vagrant plugin install vagrant-omnibus
vagrant plugin install vagrant-berkshelf
```
Start vagrant box
```
vagrant up
vagrant ssh
cd /vagrant
```
