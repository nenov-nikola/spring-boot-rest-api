pipeline {
    agent { dockerfile true }
    stages{
        stage('Build'){
            steps {
                sh 'clean install'
                sh 'node --version'
                sh 'svn --version'
            }
        }
    }
}
