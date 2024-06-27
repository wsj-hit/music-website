pipeline {
    agent any
    stages {
           stage('Stage for develop branch') {
                when {
                           branch 'develop'
                }
                       steps {
                           echo 'This is the develop branch'
                       }
           }
           stage('Stage for master branch') {
                when {
                    branch 'master'
                }
                steps {
                    echo 'This is the master branch'
                }
           }
    }
}
