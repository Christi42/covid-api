pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Récupération du code source depuis un dépôt Git
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Compilation du projet Java (exemple avec Maven)
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Exécution des tests unitaires
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Déploiement de l'application sur un serveur (exemple avec Maven)
                sh 'mvn deploy'
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