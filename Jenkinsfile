pipeline {
    agent any
    

    stages {
        stage('Checkout') {
            steps {
                // Récupération du code source depuis un dépôt Git
                git branch: 'main', url: 'https://github.com/Christi42/covid-api.git/'

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
                /*dockerBuild(
                    imageName: 'my-image',
                    dockerfile: 'Dockerfile',
                    args: '--build-arg foo=bar'
                )*/
                bat 'docker build -t my-image:latest .'
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