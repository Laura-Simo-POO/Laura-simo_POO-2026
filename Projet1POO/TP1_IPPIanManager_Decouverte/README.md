TP1 : IPPlan-Manager
Étudiant : SIMO MEUTCHEHE LAURA WITNEY

1. Objectif du TP
L'objectif de ce travail pratique est de modéliser les composants de base d'un réseau informatique en utilisant la Programmation Orientée Objet (POO) en Java.

2. Architecture du projet 
Le projet est structuré autour de quatre classes principales :
AdresseIP 
ReseauIP 
InteraceReseau
Equipement
Main

3. Travail effectué (Partie 13)

resultat obtenu:

===== IPPlan-Manager : TP1 =====
D�couverte des premi�res classes du projet

----- R�seau cr�� -----
Reseau : 192.168.1.0/24
Description : R�seau principal du laboratoire IRT

----- �quipements cr��s -----

Nom de l'�quipement : R1_EDGE
Type d'�quipement : Routeur
Interface : eth0
Adresse IP : 192.168.1.1
Etat : active

Nom de l'�quipement : SRV_DNS
Type d'�quipement : Serveur
Interface : eth0
Adresse IP : 192.168.1.10
Etat : active

Nom de l'�quipement : PC_ADMIN
Type d'�quipement : Poste client
Interface : wlan0
Adresse IP : 192.168.1.50
Etat : inactive

Nom de l'�quipement : SW
Type d'�quipement : Switch
Interface : vlan1
Adresse IP : non configur�e
Etat : inactive

Nom de l'�quipement : AP-Bureau
Type d'�quipement : Access Point
Interface : wlan0
Adresse IP : 10.0.0.2
Etat : active

----- Deuxi�me r�seau cr�� -----
Reseau : 10.0.0.0/8
Description : WiFi Invit�s
BUILD SUCCESSFUL (total time: 0 seconds)


14-QUESTIONS DE COMPREHENSION

1-Pourquoi une adresse IP est-elle une classe au lieu d'un simple String ?
        
L'utilisation d'une classe permet d'encapsuler des données et des comportements.
Cela permettra, dans les prochains TP, d'ajouter des méthodes de validation (vérifier si le format est correct) et
d'effectuer des calculs réseaux complexes qu'un simple texte ne pourrait pas faire seul.

2-Quelle est la différence entre une classe et un objet ?
        
La classe est le modèle, le plan de construction ou le "moule" défini dans le code (ex: la classe Equipement). 
L'objet est l'instance concrète et réelle créée en mémoire à partir de ce plan (ex: votre routeur R1_EDGE ou votre serveur SRV_DNS).

3-Quel est le rôle du constructeur ?
        
Le constructeur est une méthode spéciale qui est appelée au moment de la création d'un objet avec le mot-clé new. 
Son rôle est d'initialiser les attributs de l'objet avec des valeurs de départ 
(comme donner un nom et une adresse IP à une interface dès sa naissance).

4-Pourquoi la classe InterfaceReseau contient-elle un objet AdresseIP ?
        
C'est une relation de composition ou d'agrégation. 
Dans la réalité, une interface réseau ne peut pas fonctionner sans une adresse IP configurée ; en programmation, on reflète cela en intégrant l'objet AdresseIP directement dans l'objet InterfaceReseau.

5-Pourquoi la classe Equipement contient-elle un objet InterfaceReseau ?

De la même manière, un équipement physique (ordinateur, routeur) possède physiquement une carte réseau pour communiquer. 
Inclure InterfaceReseau dans Equipement permet de simuler ce lien matériel.

6-Quelle est la limite actuelle de la classe Equipement ?

Dans ce TP, la classe Equipement ne possède qu'une seule interface appelée interfacePrincipale. 
Or, dans un réseau réel, certains équipements comme les routeurs possèdent plusieurs interfaces pour relier différents réseaux entre eux.  
        
7-Pourquoi cette version est-elle insuffisante pour un plan d'adressage ?
        
Actuellement, le programme ne fait que stocker et afficher des informations textuelles.
Il ne contient pas encore la logique algorithmique nécessaire pour calculer automatiquement les masques, les adresses de diffusion (broadcast) 
ou pour générer des plages d'adresses sans erreurs
