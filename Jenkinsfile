pipeline {
    agent { dockerfile true }
    stages {
        stage('Docker Build') {
            steps {
                sh 'docker build -t test .'
            }
        }
        stage{
            steps{
                sh 'docker run -p 3567:8454 --name test test'
            }
        }
    }
}
