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
                  dockerapp = docker.build("fsantaniello/springboot-kubernetes:${env.BUILD_ID}", '-f ./Dockerfile .')
              }
           }
       }
       stage('Docker Push Image'){
           steps{
              script{
                   docker.withRegistry('https://registry.hub.docker.com', 'dockerhub'){
                        dockerapp.push('lastest')
                        dockerapp.push("${env.BUILD_ID}")
                   }
              }
           }
       }
       stage('Deploy Kubernetes') {
                   agent {
                       kubernetes {
                           cloud 'kubernetes'
                       }
                   }
                   environment {
                       tag_version = "${env.BUILD_ID}"
                   }

                   steps {
                       sh 'sed -i "s/{{tag}}/$tag_version/g" ./k8s/api.yaml'
                       sh 'cat ./k8s/api.yaml'
                       kubernetesDeploy(configs: '**/k8s/**', kubeconfigId: 'kubeconfig')
                   }
               }

    }
}