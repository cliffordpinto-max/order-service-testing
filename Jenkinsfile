pipeline {
  agent { label 'java21' }

  environment {
    MAVEN_OPTS = '-Xmx1024m'
    REGISTRY = 'myregistry.local'
    IMAGE_NAME = "${REGISTRY}/${env.JOB_NAME.toLowerCase()}"
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '20'))
    timestamps()
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Unit Tests & Build') {
      steps {
        sh 'mvn -B -s settings.xml clean verify'   // supply settings.xml if you need private repos
      }
      post {
        always {
          junit '**/target/surefire-reports/*.xml'
          archiveArtifacts allowEmptyArchive: true, artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true
        }
      }
    }

    stage('Package') {
      steps {
        sh 'mvn -B -DskipTests package'
      }
    }

    stage('Build Docker Image') {
      when {
        expression { return fileExists('Dockerfile') }   // only if repo has Dockerfile
      }
      steps {
        script {
          // Option A: if docker socket is mounted (fast)
          sh "docker build -t ${IMAGE_NAME}:${env.BUILD_NUMBER} ."
          sh "docker tag ${IMAGE_NAME}:${env.BUILD_NUMBER} ${IMAGE_NAME}:latest"
          // Optional push (requires registry credentials configured in Jenkins)
          // withCredentials([...]) { sh "docker login ...; docker push ..." }
        }
      }
    }
  }

  post {
    success {
      echo "Build succeeded: ${env.BUILD_NUMBER}"
    }
    failure {
      echo "Build failed"
    }
    cleanup {
      cleanWs()
    }
  }
}
