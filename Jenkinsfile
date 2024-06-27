pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
            }
        }
        stage('Build Deploy Code') {
            when {
                branch 'develop'
            }
            steps {
                echp "develop"
            }
            when {
                branch 'master'
            }
            steps {
              echo "master"
           }
        }
    }
}