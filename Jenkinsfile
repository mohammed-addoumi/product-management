pipeline {
    agent any
    stages {
        stage('compile') {
            steps {
                sh '/usr/local/Cellar/maven/3.8.4/libexec/bin/mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh '/usr/local/Cellar/maven/3.8.4/libexec/bin/mvn test'
            }
        }
        stage('package') {
            steps {
                sh '/usr/local/Cellar/maven/3.8.4/libexec/bin/mvn package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh '/usr/local/bin/docker build -t addoumi.mohammed@gmail.com/product-management-app .'
                sh '/usr/local/bin/docker login -u addoumi.mohammed@gmail.com -p simoQB24188'
                sh '/usr/local/bin/docker push addoumi.mohammed@gmail.com/product-management-app'
            }
        }
    }
}
