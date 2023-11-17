pipeline {
    agent any
    

    stages {
        stage('Checkout') {
            steps {
                // Récupération du code source depuis un dépôt Git
                checkout scm
            }
        }

        /*stage('Build Docker Image') {
            steps {
                script {
                    // Exemple de création d'une image Docker
                    def customImage = docker.build('image_back_jenkins:--', '-f Dockerfile .')
                    // Remplacez 'your-docker-image:tag' par le nom et le tag de votre image Docker
                    // Remplacez 'path/to/Dockerfile' par le chemin relatif ou absolu de votre Dockerfile

                    // Push de l'image vers un registre Docker (facultatif)
                    customImage.push()
                }
            }
        }*/
        
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
        
        stage('Deploy') {
            steps {
                // Déploiement de l'application sur un serveur (exemple avec Maven)
                bat 'gradle deploy'
            }
        }
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