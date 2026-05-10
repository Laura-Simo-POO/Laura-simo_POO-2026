 TP9 - Persistance et organisation professionnelle
Etudiante: SIMO MEUTCHEHE Laura

 Objectif: Ajouter la lecture et l'écriture de fichiers afin de sauvegarder les besoins, les plans, les VLANs, les recommandations et les rapports.

 Notions étudiées
Persistance, fichiers CSV, lecture de fichier, écriture de fichier,
repository, service, packages, architecture professionnelle.

 Fichiers utilisés:

 Fichiers d'entrée:
- exports/besoins.csv : besoins de l'université
- exports/besoins_pme.csv : besoins de la PME

 Fichiers générés:
- exports/plan_adressage.csv : plan VLSM universite
- exports/vlans.csv : VLANs generes
- exports/recommandations.txt : recommandations techniques
- exports/rapport_complet.txt : rapport universite
- exports/rapport_pme.txt : rapport PME

 Scénarios testés:

 Scénario 1 : Université (10.10.0.0)
- ETUDIANTS : 500 hôtes
- WIFI_INVITES : 200 hôtes
- ENSEIGNANTS : 120 hôtes
- LABORATOIRES : 60 hôtes
- SERVEURS : 30 hôtes

 Scénario 2 : PME (192.168.1.0)
- ADMINISTRATION : 50 hôtes
- COMPTABILITE : 20 hôtes
- WIFI_INVITES : 80 hôtes
- SERVEURS : 15 hôtes
- VOIP : 40 hôtes

Difficultés rencontrées:

La reorganisation en packages a necessite de corriger tous les imports de chaque classe. Le fichier besoins_pme.csv avait une extension .txt
cachee qui empechait sa lecture.

 18-Réponses aux questions:

1. La persistance des données signifie que les informations produites
par une application sont conservées dans un support durable comme un
fichier ou une base de données, même après l'arrêt du programme.

2. Une application professionnelle doit sauvegarder ses résultats car
les données doivent pouvoir être relues, partagées ou archivées. Sans
sauvegarde, tout le travail est perdu à chaque redémarrage.

3. Un fichier CSV est structuré en colonnes séparées par des points-
virgules, destiné à être traité par un programme ou un tableur. Un
rapport texte est lisible directement par un humain, avec des sections
et des explications.

4. Le package repository regroupe les classes qui lisent et écrivent
les données. Cela sépare l'accès aux données de la logique métier,
ce qui rend le code plus propre et plus facile à modifier.

5. Le package service regroupe les classes qui effectuent les
traitements métier. Cela évite de mélanger les calculs, la gestion
des VLANs et les recommandations dans une seule classe.

6. Mettre tout le code dans Main rendrait la classe illisible et
impossible à maintenir. La séparation en classes spécialisées permet
de modifier une partie sans toucher aux autres.

7. Le fichier besoins.csv rend l'application plus flexible car on
peut changer les besoins sans modifier le code Java. Il suffit
d'éditer le fichier CSV et de relancer le programme.

8. La séparation en packages améliore la maintenabilité car chaque
package a un rôle précis. Un développeur sait immédiatement où
chercher une classe selon sa fonction : model, service, repository,
exception ou main.

RESULTATS OBTENUS:

===== IPPlan-Manager : TP9 - Persistance =====

===== SCENARIO 1 : Universite =====
Fichiers generes : exports/rapport_complet.txt

===== SCENARIO 2 : PME =====
Fichiers generes : exports/rapport_pme.txt

Traitement termine avec succes.
BUILD SUCCESSFUL (total time: 2 seconds)
 