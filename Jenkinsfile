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
        stage('run') {
            steps {
                sh 'docker run -d -p 8000:8000 --name=test-container test'
            }
        }
    }
    post {
        always {
            script {
                def containerName = 'test-container'
                def containerId = sh(script: "docker ps -q --filter 'name=${containerName}'", returnStdout: true).trim()
                if (containerId) {
                    sh "docker stop ${containerId}"
                    sh "docker rm ${containerId}"
                }
            }
        }
    }
}
