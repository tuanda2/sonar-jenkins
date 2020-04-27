pipeline {
    agent any
    environment {
      // Docker image versioning
      BUILD_NAME = $(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout -U -e)
      BUILD_VERSION = $(mvn help:evaluate -Dexpression=project.version -q -DforceStdout -U -e)
      IMAGE = $BUILD_NAME:$BUILD_VERSION
    }
    stages {
        stage('Checkout Source Code') {
            steps {
                checkout scm
            }
        }
        stage('Build source') {
            steps {
              echo "====== Starting BUILD SOURCE ======"
              sh "mvn clean package -DskipTests --batch-mode -U -e"
            }
        }
        stage('Build image') {
            steps {
                echo "====== Starting BUILD IMAGE ======"
                //sh "docker image ls"
            }
        }
        stage('Get approval') {
            steps {
                /* Using SNS Send email for approver */
                input id: "$IMAGE", message: 'Are you deployment ?', ok: 'Go Ahead', submitter: '',parameters: [string(defaultValue: '', description: '', name: 'Note for this approval', trim: false)], submitterParameter: 'Note for this approval'
            }
        }

        /*
        stage('Deployment') {
            steps {
              echo "Starting Deployment"
            }
        }
        */
    }
}
