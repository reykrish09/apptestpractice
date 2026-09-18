pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('Set Image Tag') {
            steps {
                script {
                    env.GIT_SHORT_SHA = sh(
                        script: 'git rev-parse --short HEAD',
                        returnStdout: true
                    ).trim()
                }
                echo "Image tag: ${env.GIT_SHORT_SHA}"
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Verify') {
            steps {
                sh 'ls -l target'
            }
        }

        stage('Docker Build') {
            steps {
                sh '''
                docker build \
                  -t us-east1-docker.pkg.dev/project-016ea2d9-4ffd-47c6-9ce/reyankrish-repo/reyankrish-app:${GIT_SHORT_SHA} .
                '''
            }
        }

        stage('Docker Push') {
            steps {
                sh '''
                docker push \
                  us-east1-docker.pkg.dev/project-016ea2d9-4ffd-47c6-9ce/reyankrish-repo/reyankrish-app:${GIT_SHORT_SHA}
                '''
            }
        }

        stage('Deploy to GKE') {
            steps {
                sh '''
                kubectl set image deployment/reyankrish-app \
                  reyankrish-app=us-east1-docker.pkg.dev/project-016ea2d9-4ffd-47c6-9ce/reyankrish-repo/reyankrish-app:${GIT_SHORT_SHA} \
                  -n demo

                kubectl rollout status deployment/reyankrish-app \
                  -n demo \
                  --timeout=180s
                '''
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully'
        }

        failure {
            echo 'Build failed'
        }
    }
}