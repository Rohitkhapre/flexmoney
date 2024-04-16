pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
                git changelog: false, poll: false, url: 'https://github.com/Rohitkhapre/flexmoney.git'
            }
        }
        
        stage('Frontend Docker build & push') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'dockerhub') {
                        sh "docker build -t rohitpawar27/frontend:latest -f frontend/Dockerfile frontend"
                        sh "docker push rohitpawar27/frontend:latest"
                    }
                }
            }
        }
        
        stage('Backend Docker build & push') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'dockerhub') {
                        sh "docker build -t rohitpawar27/backend:latest -f backend/Dockerfile2 backend"
                        sh "docker push rohitpawar27/backend:latest"
                    }
                }
            }
        }
    }
    
    post {
        success {
            echo "Pipeline finished successfully!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}

