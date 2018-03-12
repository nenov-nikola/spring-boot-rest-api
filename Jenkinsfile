#!/usr/bin/env groovy

pipeline {
    agent { dockerfile true }
    agent {
        docker {
            image 'node'
            args '-u root'
        }
    }

    stages {
        stage('One') {
            steps {
                echo 'Building...'
                sh 'docker build -t abcd .'
            }
        }
        stage('Two') {
            steps {
                echo 'Building...'
                sh 'docker run -p 3567:8454 --name abcd abcd'
            }
        }
        
    }
}
