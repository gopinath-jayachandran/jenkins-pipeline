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
                sh 'docker run -p 8000:8000 test'
            }
        }
    }
}
