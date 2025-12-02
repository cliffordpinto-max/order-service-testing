pipeline {
    agent any

    environment {
        REGISTRY = "docker.io"
        IMAGE_NAME = "cliffordpinto/order-service"
        IMAGE_TAG = "${env.BUILD_NUMBER}"
        REGISTRY_CREDENTIALS = "dockerhub-creds"
        JAVA_HOME = "${tool 'jdk21'}"
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn -B clean install'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Static Analysis (SonarQube)') {
            when { expression { return false } } // disable for now unless you use Sonar
            steps {
                withSonarQubeEnv('sonar-server') {
                    sh """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=my-microservice \
                        -Dsonar.host.url=\${SONAR_HOST_URL} \
                        -Dsonar.login=\${SONAR_AUTH_TOKEN}
                    """
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t $REGISTRY/$IMAGE_NAME:$IMAGE_TAG .
                    docker tag $REGISTRY/$IMAGE_NAME:$IMAGE_TAG $REGISTRY/$IMAGE_NAME:latest
                """
            }
        }

        stage('Push to Registry') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${REGISTRY_CREDENTIALS}", usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh """
                        echo "$PASS" | docker login -u "$USER" --password-stdin $REGISTRY
                        docker push $REGISTRY/$IMAGE_NAME:$IMAGE_TAG
                        docker push $REGISTRY/$IMAGE_NAME:latest
                    """
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "Build successful. Docker image pushed as $REGISTRY/$IMAGE_NAME:$IMAGE_TAG"
        }
        failure {
            echo "Build failed!"
        }
    }
}
