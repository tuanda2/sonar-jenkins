pipeline {
    agent any
    environment {
      // Docker image versioning
      BUILD_NAME = echo sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout --batch-mode -U -e').trim()
      BUILD_VERSION = echo sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout --batch-mode -U -e').trim()
      IMAGE = $BUILD_NAME:$BUILD_VERSION
    }
    stages {
        stage('Checkout Source Code') {
            steps {
                echo "IMAGE: $IMAGE"
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
