pipeline {
    agent any

    environment {
        DOCKER_REGISTRY_URL = "https://hub.docker.com/u/rohitpawar27"
        SERVER_IPS = "13.127.182.78"  // Add EC2 instance IPs here
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Push Docker Images') {
            steps {
                 withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    script {
                        // Docker login
                        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin $DOCKER_REGISTRY_URL"

                    // Build and push Docker images
                    docker.build("backend-app", "./backend")
                    docker.build("frontend-app", "./frontend")
                    docker.withRegistry("$DOCKER_REGISTRY_URL", "dockerhub") {
                        docker.image("backend-app").push("latest")
                        docker.image("frontend-app").push("latest")
                    }
                }
            }
        }

        stage('Deploy to Servers') {
            steps {
                script {
                    sshagent(credentials: ['EC2']) {
                        SERVER_IPS.each { ip ->
                            sshCommand remote: "user@$ip", command: "cd /home/ubuntu/flexmoney && docker-compose pull && docker-compose up -d"
                        }
                    }
                }
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}

