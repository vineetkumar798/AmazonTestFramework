pipeline {
    agent any
 
    stages {
        stage('Checkout') {
            steps {
                // Checkout source code from Git repository
                checkout([$class: 'GitSCM', 
                          branches: [[name: '*/master']], 
                          userRemoteConfigs: [[url: 'https://github.com/vineetkumar798/AmazonTestFramework.git']]])
            }
        }
 
        stage('Build and Test') {
            steps {
                
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                
                echo 'Deploying application to local server...'
              
            }
        }

        stage('Cleanup') {
            steps {
                // Clean up temporary files
                echo 'Cleaning up...'
                sh 'rm -rf target'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the logs for errors.'
        }
    }
}
