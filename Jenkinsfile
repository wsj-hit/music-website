pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
               echo 'Hello world!'
            }
            when {
               branch 'develop'
            }
            steps {
               echo "develop"
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