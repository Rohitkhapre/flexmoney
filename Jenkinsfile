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
                    sshagent(credentials: ['EC2']) {
                        SERVER_IPS.each { ip ->
                            sshCommand remote: "user@$ip", command: "cd /home/ubuntu/flexmoney && git pull && docker-compose up -d"
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
