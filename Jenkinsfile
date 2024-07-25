pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'maven -B -DskipTests clean package'
            }
        }
    }
}
