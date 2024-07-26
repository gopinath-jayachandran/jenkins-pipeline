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
        stage('Wait for Application') {
             steps {
                         script {
                             def maxRetries = 10
                             def retryInterval = 10
                             def retries = 0
                             while (retries < maxRetries) {
                                 def status = sh(script: "curl -s -o /dev/null -w '%{http_code}' http://localhost:8000", returnStdout: true).trim()
                                 if (status == '200') {
                                     echo "Application is up and running!"
                                     break
                                 }
                                 retries++
                                 sleep retryInterval
                             }
                             if (retries == maxRetries) {
                                 error "Application did not start within the expected time."
                             }
                         }
                     }
        }
    }
}
