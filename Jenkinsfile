pipeline {
    agent any

    environment {
        SERVER_IPS = "13.127.182.78"  // Add EC2 instance IPs here
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Deploy to Servers') {
            steps {
                script {
                    withCredentials([sshUserPrivateKey(credentialsId: 'EC2', keyFileVariable: 'SSH_KEY')]) {
                        SERVER_IPS.each { ip ->
                            sshCommand remote: "user@$ip", command: "cd /home/ubuntu/flexmoney && git pull && docker-compose pull && docker-compose up -d", key: "${SSH_KEY}"
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
