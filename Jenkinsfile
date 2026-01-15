pipeline {
    agent any
    stages {

       stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/MKSingh24/SeleniumFrameWorkhybrid.git'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn clean test --DsuiteXmlFile=testng.xml'
            }
        }

     }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}