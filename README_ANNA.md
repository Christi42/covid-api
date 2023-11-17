# Voici un readme qui explique les étapes d'un Build sur un projet java
# On executera ensuite des builds dans un conteneur docker pour l'application
# Application Covid-api

# 1- Build en local
1- Récupérer le projet sur githut grâce à cette commande
git clone https://github.com/Christi42/covid-api.git

2- Faire un gradle build
gradle build

Un fichier jar sera créé dans build/libs

3- Créer une image docker avec le build
docker build -t nom_image .

4- Executer l'image docker créée prédemment 
docker run -p 8080:8080 nom_image

Un build est souvent executé avec docker car il sert à 'emballé' un projet et un conteneur aura souvent un rôle d'emballage de projet pour offrir un environnement facilitant le travail d'un programmeur. Si tout se passe bien, une image pour la base de donnée devrait être créée automatiquement. 

5- Lancer la commande suivante pour executer toutes les images
docker compose up

S'il n'y a pas d'erreur alors notre build local a été réussi, félicitations. Il est à présent possible d'améliorer la création d'une image en la créant de façon automatique avec à Jenkins. Une image se créera sans notre intervention même après des modifications dans le projet. 

# 2- Build sur Jenkins - Utilisation de docker avec jenkins
Les différentes étapes pour la création d'une image docker à partir de Jenkins se trouvent dans le fichier Jenkinsfile.
1- Télécharger et installer Jenkins

2- Créer un nouveau Job (pipeline), configurer la parti Git dans ce job en y ajoutant le lien du dépot, https://github.com/Christi42/covid-api.git. 

3- Choisir entre écire le pipeline en ligne sur l'interface (un script) ou en créant un fichier Jenkinsfile qui se trouve dans le root du projet. Pour notre cas, il s'agit de la deuxième option. 

4- Installer tous les plugins en rapport avec Git, Docker dans Tableau de bord> Administrer Jenkins> Plugins

5- Configurer le chemin qui permet d'utiliser Git sur Jenkins en copiant le chemin qui mène à git.exe, généralement C:\Program Files\Git\bin\git.exe. Cela se trouve dans Tableau de bord> Administrer Jenkins> Tools et dans la partie Git, ne pas changer le nom seulement le chemin.

6- Remplir le pipeline (qui est le fichier Jenkinsfile) par les différentes étapes de création d'une image docker. Ajouter les différentes steps et commandes. Ajouter la partie Test comme dans le fichier si on souhaite faire un test unitaire. Ne pas oublier de faire un commit & push.

7- Aller sur l'interface Jenkins en ligne, aller dans le job, faire un build du job. 

8- Cliquer sur le numéro du build effectué, et observer les différentes étapes de la création d'une image dans Stage View.
