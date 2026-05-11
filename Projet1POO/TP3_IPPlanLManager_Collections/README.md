TP 3: IPPlanManager Collection
etudiant: SIMO MEUTCHEHE LAURA

 Objectif
Introduction des collections et des relations entre objets.

 Notions étudiées
Composition, ArrayList, collections, parcours de listes, relations entre objets.

 Tests réalisés

- Affichage de l'infrastructure complète avec 3 sous-reseaux et 6 equipements.
- Recherche d'un equipement existant (SW1_CORE) : trouve avec ses 3 interfaces.
- Recherche d'un equipement inexistant : message "Equipement introuvable".
- Verification que chaque equipement possede plusieurs interfaces.

 Difficultés rencontrées

- Initialiser correctement les ArrayList dans le constructeur.
- Bien respecter la casse des noms de variables en Java.
- Comprendre la relation de composition entre les classes.
- Corriger les erreurs de noms de variables (sw2, sw3 au lieu de sw1).
16-Réponses aux questions

1. La composition est une relation où un objet contient d'autres objets.
   Exemple : un Equipement contient une liste d'InterfaceReseau.

2. On utilise ArrayList car le nombre d'objets est inconnu a l'avance.
   Elle permet d'ajouter dynamiquement des objets sans taille fixe.

3. Une variable simple contient un seul objet.
   Une collection comme ArrayList peut contenir plusieurs objets
   et grandit automatiquement.

4. Un equipement reel possede plusieurs interfaces pour se connecter
   a plusieurs reseaux differents (WAN, LAN, WiFi).

5. Une infrastructure reseau est decoupee en zones logiques distinctes
   pour des raisons de securite et d'organisation (ADMIN, TECH, WIFI).

6. La boucle for-each parcourt automatiquement tous les elements
   d'une collection sans gerer manuellement un indice.

7. InfrastructureReseau est le coeur du projet car elle regroupe
   tous les equipements et sous-reseaux et centralise toutes
   les operations comme l'ajout, l'affichage et la recherche.

8. Les collections sont indispensables car les donnees sont en nombre
   variable et inconnu. Elles permettent d'ajouter, supprimer et
   parcourir des objets dynamiquement sans limite fixe.

RESULTATS OBTENUS:
run:

Infrastructure : Infrastructure YFY

===== SOUS-R�SEAUX =====
Sous-r�seau : ADMIN
R�seau : 192.168.1.0/24
Description : R�seau administration

Sous-r�seau : TECH
R�seau : 192.168.2.0/24
Description : R�seau technique

Sous-r�seau : WIFI
R�seau : 192.168.3.0/24
Description : Reseau WiFi


===== �QUIPEMENTS =====
Nom : R1_EDGE
Type : Routeur
Nombre d'interfaces : 2
Interface : eth0
Adresse IP : 192.168.1.1
�tat : active

Interface : eth1
Adresse IP : 10.0.0.1
�tat : active


Nom : SW1_CORE
Type : Switch
Nombre d'interfaces : 3
Interface : GigaEthernet0/0
Adresse IP : 192.168.1.2
�tat : active

Interface : GigaEthernet0/1
Adresse IP : 192.168.2.2
�tat : active

Interface : GigaEthernet0/2
Adresse IP : 192.168.3.2
�tat : active


Nom : SRV_WEB
Type : Serveur
Nombre d'interfaces : 2
Interface : eth0
Adresse IP : 192.168.1.10
�tat : active

Interface : eth1
Adresse IP : 192.168.2.10
�tat : inactive


Nom : SRV_DB
Type : Serveur
Nombre d'interfaces : 2
Interface : eth0
Adresse IP : 192.168.1.20
�tat : active

Interface : eth1
Adresse IP : 192.168.2.20
�tat : active


Nom : AP_WIFI_01
Type : Point d'acces WiFi
Nombre d'interfaces : 2
Interface : eth0
Adresse IP : 192.168.3.1
�tat : active

Interface : wlan0
Adresse IP : 192.168.1.100
�tat : active


Nom : FW_BORDER
Type : Firewall
Nombre d'interfaces : 3
Interface : WAN
Adresse IP : 10.0.0.2
�tat : active

Interface : LAN1
Adresse IP : 192.168.1.254
�tat : active

Interface : LAN2
Adresse IP : 192.168.2.254
�tat : active


===== TEST RECHERCHE =====
=== Equipement trouv� ===
Nom : SW1_CORE
Type : Switch
Nombre d'interfaces : 3
Interface : GigaEthernet0/0
Adresse IP : 192.168.1.2
�tat : active

Interface : GigaEthernet0/1
Adresse IP : 192.168.2.2
�tat : active

Interface : GigaEthernet0/2
Adresse IP : 192.168.3.2
�tat : active


Equipement introuvable.
BUILD SUCCESSFUL (total time: 0 seconds)
