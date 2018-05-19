pipeline {
    agent { dockerfile true }
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean install'
                sh 'node --version'
                sh 'svn --version'
            }
        }
    }
}
