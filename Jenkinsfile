pipeline {
    agent any
    stages {
        stage('clean') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build') {
            steps {
                sh 'docker build -t test .'
            }
        }
        stage('Stop Previous Container') {
            steps {
                script {
                    def containerName = 'test-container'
                    // Check if the container exists and is running
                    def containerId = sh(script: "docker ps -q --filter 'name=${containerName}'", returnStdout: true).trim()
                    if (containerId) {
                        // Stop and remove the container if it's running
                        sh "docker stop ${containerId}"
                        sh "docker rm ${containerId}"
                    }
                }
            }
        }
        stage('run') {
            steps {
                sh 'docker run -d -p 8000:8000 --name=test-container test'
            }
        }
    }
}
