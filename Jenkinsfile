pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Anilroutaitipur/selenium-grid-docker-project.git', branch: 'main'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                sh 'docker-compose -f Docker/docker-compose.yml up -d'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Stop Selenium Grid') {
            steps {
                sh 'docker-compose -f Docker/docker-compose.yml down'
            }
        }
    }
}
