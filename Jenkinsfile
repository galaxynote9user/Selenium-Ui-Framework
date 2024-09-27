pipeline {
    agent any
    tools {
        maven 'Maven 3.9.9'   // Make sure to configure this in Jenkins
        jdk 'JDK 18'        
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/galaxynote9user/Selenium-Ui-Framework.git'
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
    post {
        always {
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'Report',
                reportFiles: 'ExtenthtmlReport.html',
                reportName: 'Extent Report'
            ])
        }
    }
}
