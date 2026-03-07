pipeline {
    agent any

    environment {
        DOCKER_HUB_USER = "YOUR_DOCKER_ID"
        APP_NAME = "used-car-app"
        IMAGE_TAG = "v${env.BUILD_NUMBER}" // Automatically versions each build
    }

    stages {
        stage('Compile & Test') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // This assumes you have SonarQube configured in Jenkins
                sh 'mvn sonar:sonar'
            }
        }

        stage('Build & Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'docker-hub-credentials') {
                        def customImage = docker.build("${DOCKER_HUB_USER}/${APP_NAME}:${IMAGE_TAG}")
                        customImage.push()
                        customImage.push("latest")
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                // Updates your cluster with the new image
                sh "kubectl apply -f k8s-deployment.yaml"
                sh "kubectl apply -f ingress.yaml"
            }
        }
    }
}
