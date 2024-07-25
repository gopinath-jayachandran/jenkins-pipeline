pipeline {
    agent any
    stages {
        stage('Install Maven') {
                steps {
                    sh '''
                    sudo apt-get update
                    sudo apt-get install -y maven
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