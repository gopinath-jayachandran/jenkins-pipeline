pipeline {
    agent any
    stages {
        stage('Install Maven') {
                steps {
                    sh '''
                     apt-get update
                     apt-get install -y maven
                    '''
                }
            }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}