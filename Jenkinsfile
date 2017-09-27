pipeline {
  agent any
  stages {
    stage('stage1') {
      steps {
        parallel(
          "stage1": {
            sh 'echo "stage 1"'
            echo 'stage 1 print message'
            
          },
          "stage 1.1": {
            echo '1.1 OK'
            echo '1.1 - 2e message OK'
            
          }
        )
      }
    }
    stage('stage 2') {
      steps {
        sh '''echo "stage 2"
'''
      }
    }
  }
}