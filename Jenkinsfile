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
                sh '/usr/local/bin/docker build -t mohammedaddoumi/product-management-app .'
                sh '/usr/local/bin/docker login -u mohammedaddoumi -p simoQB24188'
                sh '/usr/local/bin/docker push mohammedaddoumi/product-management-app'
            }
        }
        stage('Kubernetes Deployment') {
            steps {
                sh '/usr/local/bin/kubectl apply -f kubernetes/deployment.yaml'
            }
        }

        stage('Kubernetes Service') {
            steps {
                sh '/usr/local/bin/kubectl apply -f kubernetes/service.yaml'
            }
        }
    }
}
