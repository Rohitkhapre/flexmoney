pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('dockerhub') // Jenkins credentials ID for Docker Hub login
        BACKEND_IMAGE_NAME = 'rohitpawar27/backend'
        FRONTEND_IMAGE_NAME = 'rohitpawar27/frontend'
        DOCKERFILE_BACKEND = './backend/Dockerfile'
        DOCKERFILE_FRONTEND = './frontend/Dockerfile'
    }
    
    stages {
        stage('Checkout Source Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Backend Image') {
            steps {
                script {
                    docker.build(BACKEND_IMAGE_NAME, "-f ${DOCKERFILE_BACKEND} ./backend")
                }
            }
        }
        
        stage('Build Frontend Image') {
            steps {
                script {
                    docker.build(FRONTEND_IMAGE_NAME, "-f ${DOCKERFILE_FRONTEND} ./frontend")
                }
            }
        }
        
        stage('Push Images to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_HUB_CREDENTIALS) {
                        docker.image(BACKEND_IMAGE_NAME).push()
                        docker.image(FRONTEND_IMAGE_NAME).push()
                    }
                }
            }
        }
    }
}
