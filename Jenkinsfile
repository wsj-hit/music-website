pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    if (env.BRANCH_NAME == 'develop') {
                        echo 'develop'
                    } else if (env.BRANCH_NAME == 'master') {
                        echo 'master'
                    } else {
                        echo 'Hello world!'
                    }
                }
            }
        }
    }
}
