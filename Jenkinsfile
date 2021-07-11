pipeline{
    agent any

    stages{
       stage('Get Source'){
           steps{
              git url: 'https://github.com/santaniello/springboot-kubernetes.git', branch: 'master'
           }
       }
       stage('Docker Build'){
           steps{
              script{
                  dockerapp = docker.build("fsantaniello/springboot-kubernetes:${env.BUILD_ID}", '-f ./Dockerfile')
              }
           }
       }
       stage('Docker Push Image'){
           steps{
              script{
                   docker.withRegistry('https://registry.hub.docker.com', 'dockerhub')
                   dockerapp.push('lastest')
                   dockerapp.push("${env.BUILD_ID}")
              }
           }
       }
    }
}