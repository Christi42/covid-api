pipeline {
    agent any
    

    stages {
        stage('Checkout') {
            steps {
                // Récupération du code source depuis un dépôt Git
                //git branch: 'main', url: 'https://github.com/Christi42/covid-api.git/'
                checkout scm

            }
        }
         
        stage('Build') {
            steps {
                // Compilation du projet Java (exemple avec Maven)
                bat 'gradle build'
            }
        }
        
        /*stage('Test') {
            steps {
                // Exécution des tests unitaires
                bat 'gradle test'
            }
        }*/
           

    stage('Build Docker Image') {
            steps {
                
                bat 'docker build -t image_back_jenkins:latest -f Dockerfile .'
                bat 'docker login -u christianna1 -p abdmalagasy'
                bat 'docker push image_back_jenkins:latest'
            }
        }
    
    stage('Deploy') {
            steps {
                // Déploiement de l'application sur un serveur (exemple avec Maven)
                bat 'docker compose up -d'
                
            }
        }

    /*stage('Push') {
            steps {
                // Authentification au registre Docker
                
                    // Docker login to authenticate with Docker Hub
                    bat 'docker login -u christianna1 -p abdmalagasy'
                    // Replace 'your-docker-username' and 'your-docker-password' with your Docker Hub credentials

                    // Build the Docker image
                    //bat 'docker build -t your-docker-image:tag -f path/to/Dockerfile .'
                    // Replace 'your-docker-image:tag' with your image name and tag
                    // Replace 'path/to/Dockerfile' with the path to your Dockerfile

                    // Push the Docker image to Docker Hub
                    bat 'docker push image_back_jenkins:latest'
                    // Replace 'your-docker-image:tag' with your image name and tag
                
                
            }
        }*/
    }

    post {
        success {
            // Actions à exécuter en cas de succès du pipeline
            echo 'Parfait, le pipeline a été executé'
            // Vous pouvez ajouter d'autres actions ici
        }
        failure {
            // Actions à exécuter en cas d'échec du pipeline
            echo 'Vous avez échoué avec succès, essayez à nouveau'
            // Vous pouvez ajouter d'autres actions ici
        }
    }
}