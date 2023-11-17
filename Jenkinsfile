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
        
        stage('Test') {
            steps {
                // Exécution des tests unitaires
                bat 'gradle test'
            }
        }
          
    

    stage('Build Docker Image') {
            steps {
                
                bat 'docker build -t mon_registre/image_back_jenkins:latest .'
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
                script {
                    docker.withRegistry('https://registry-url/', 'credentials-id') {
                        // Pousse l'image Docker vers le registre
                        dockerImage.push()
                    }
                }
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