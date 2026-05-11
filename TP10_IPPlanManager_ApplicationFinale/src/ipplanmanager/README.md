TP10: APPLICATION FINALE
Etudiante: SIMO MEUTCHEHE Laura 

Objectif: Assembler toutes les fonctionnalités développées dans les TPs précédents 
afin de produire une application console complète de planification d'adressage IP.

 Fonctionnalités réalisées

- Saisie interactive des besoins réseaux.
- Calcul de plan d'adressage VLSM sans chevauchement.
- Création automatique de VLANs (ID et noms).
- Validation de la cohérence des plages IP.
- Moteur de recommandations techniques (sécurité et broadcast).
- Sauvegarde des résultats en formats CSV et rapport TXT.

 Organisation du projet

- model : Contient les objets métiers (BesoinReseau, VLAN, ResultatVLSM).
- service : Logique de calcul (MoteurVLSM, MoteurRecommandation).
- repository : Gestion de la persistance (lecture/écriture de fichiers).
- exception : Classes de gestion des erreurs personnalisées.
- console : Gestion de l'interface utilisateur et des saisies.
- main : Point d'entrée de l'application.

 Scénarios testés

1. Campus IRT : Test de montée en charge avec 500 hôtes pour le segment Étudiants.
2. PME : Optimisation d'un réseau de classe C pour 5 services administratifs.
3. Entreprise Multi-services : Gestion de flux spécifiques (Caméras, VOIP).

 Fichiers générés

Tous les fichiers sont stockés dans le dossier `exports/` :
- `[NomProjet]_plan.csv` : Tableau détaillé des sous-réseaux.
- `[NomProjet]_vlans.csv` : Liste des VLANs générés.
- `[NomProjet]_rapport.txt` : Rapport technique complet incluant les recommandations.

 Difficultés rencontrées

La principale difficulté a été la gestion précise du décalage des adresses IP dans la boucle VLSM pour éviter tout chevauchement, 
ainsi que la synchronisation entre la création des VLANs et les résultats du plan IP.

Organisation du projet


-ipplanmanager.model:	Classes métier (BesoinRéseau, ResultatVLSM, VLAN, Recommandation)
-ipplanmanager.service:	Logique métier (CalculateurRéseau, MoteurVLSM, GestionnaireVLAN, Validateur, MoteurRecommandation)
-ipplanmanager.repository:	Accès aux fichiers (lecture/écriture CSV)
-ipplanmanager.exception:	Exceptions personnalisées
-ipplanmanager.console:	Interaction utilisateur
-ipplanmanager.main:	Point d'entrée de l'application

Scénarios testés

Scénario 1 : Campus IRT

Besoin   	Hôtels	Adresse	        CIDR	Margarine

ÉTUDIANTS	500	10.10.0.0	/23	10
WIFI_INVITES    200	10.10.2.0	/24	54
ENSEIGNANTS	120	10.10.3.0	/25	6
LABORATOIRES	60	10.10.3.128	/26	2
SERVEURS	30	10.10.3.192	/27	0

Scénario 2 : PME

Besoin  	Hôtels	Adresse	CIDR	Margarine

ADMINISTRATION	50	192.168.1.0	/26	12
COMPABILITÉ	20	192.168.1.64	/27	2
WIFI_INVITES 	80	192.168.1.96	/25	46
SERVEURS	15	192.168.1.160	/27	2
VoIP	        40	192.168.1.192	/26	22

Scénario 3 : Entreprise multiservices

Besoin	Hôtels	Adresse	CIDR	Margarine

TECHNIQUE	120	10.0.0.0	/25	6
DIRECTION	25	10.0.0.128	/27	2
CAMÉRAS	        60	10.0.0.160	/26	2
SOUTIEN	        35	10.0.0.224	/27	2
INVITATIONS	100	10.0.1.0	/25	26


18. Réponses aux questions de compréhension

1-Pourquoi le TP10 représente-t-il une application plus complète ?

Contrairement aux TPs précédents qui se concentraient sur des fonctionnalités isolées 
(le calcul VLSM, la gestion des exceptions ou l'écriture de fichiers), 
le TP10 assemble toutes ces briques pour créer un produit fini, cohérent et prêt à l'emploi.

2-Quel est le rôle de la classe ApplicationIPPlanManager ?

C'est l'orchestrateur de l'application.
 Elle coordonne les interactions entre l'utilisateur (via la console), 
les moteurs de calcul (logic) et la sauvegarde des données (repository).

3-Pourquoi la classe Main doit-elle rester courte ?

Pour respecter les principes de la POO. 
Son rôle unique est de servir de point d'entrée pour instancier et démarrer l'application principale,
laissant la logique métier aux classes spécialisées.

4-Importance de la séparation des packages ?

Cela permet une meilleure maintenabilité et une modularité du code. 
Par exemple, on peut modifier l'interface utilisateur (package console) sans impacter les calculs mathématiques (package service).

5-Pourquoi la saisie utilisateur est-elle dans ConsoleService ?

Cela isole les entrées/sorties du reste du code. 
Si l'on souhaite passer d'une application console à une application graphique (GUI) plus tard, 
il suffira de remplacer ce service.

6-Pourquoi valider l'adresse réseau avant le VLSM ?

Pour garantir l'intégrité des calculs. 
Si l'adresse de départ est invalide (ex: 192.168.1.256), 
tous les sous-réseaux calculés par la suite seraient mathématiquement faux.

7-Pourquoi les recommandations sont-elles après les VLANs ?

Parce que l'analyse du moteur de recommandations se base sur les caractéristiques finales des VLANs (nom, taille, type de service) pour fournir des conseils pertinents.

8-Pourquoi la sauvegarde rend-elle l'application exploitable ?

Un plan d'adressage n'est utile que s'il peut être partagé et conservé. 
Les fichiers CSV et TXT permettent à un administrateur réseau d'utiliser ces données pour configurer réellement ses équipements.

9-Importance du rapport technique en contexte professionnel ?

Il sert de document de référence pour l'audit, la traçabilité et l'aide au dépannage.
Il justifie les choix techniques auprès de la direction ou des clients.

10-Améliorations futures ?

-L'ajout d'une interface graphique, 
-la prise en charge de l'IPv6, 
-l'export direct de scripts de configuration pour routeurs (Cisco, Juniper).


 Conclusion personnelle

Ce projet m'a permis de comprendre comment la Programmation Orientée Objet (POO) s'applique concrètement aux problématiques réseaux. 
L'utilisation des classes et des services permet de transformer des calculs binaires complexes en un outil automatisé fiable. 
La séparation en packages facilite grandement la maintenance et l'évolution du logiciel.