pipeline {
    agent any
    environment {
            DOCKER_IMAGE_NAME = "alpha-tech-repo/my-app" // Docker image name
            DOCKER_TAG = "latest"  // Docker tag (can be dynamic, like commit hash or build number)
            KUBERNETES_DEPLOYMENT_NAME = "spring-boot-my-app"  // Kubernetes deployment name
            KUBERNETES_NAMESPACE = "default"  // Kubernetes namespace
            K8S_CLUSTER_CONFIG = "/path/to/kube/config"  // Path to Kubernetes config file (if needed)
            REGISTRY_CREDENTIALS = 'docker-hub-credentials'  // Jenkins credentials for Docker registry
       }

    stages {
        stage("clone") {
            steps {
                echo 'Clone repository'
                git 'git@github.com:ddumbre01/my-app.git'
            }
        }
        stage("test") {
            steps {
                echo 'testing application..'
                script {
                      sh './gradlew test'
                 }
            }
        }
        stage('Build Spring Boot Application') {
                    steps {
                          echo 'Building application..'
                          script {
                                 sh './gradlew clean build'
                          }
                    }
        }
        stage('Build Docker Image') {
                    steps {
                        echo 'Building docker file..'
                        script {

                            sh """
                                docker buildx build -t ${DOCKER_IMAGE_NAME}:${DOCKER_TAG} .
                            """
                        }
                    }
        }

         stage('Push Docker Image to Registry') {
                    steps {
                        echo 'Pushing docker file to docker hub..'
                        script {
                            sh """
                                docker push ${DOCKER_IMAGE_NAME}:${DOCKER_TAG}
                            """
                        }
                    }
         }

    }

    post {
            success {
                echo "Deployment successful!"
            }
            failure {
                echo "Deployment failed. Please check the logs!"
            }
    }

}