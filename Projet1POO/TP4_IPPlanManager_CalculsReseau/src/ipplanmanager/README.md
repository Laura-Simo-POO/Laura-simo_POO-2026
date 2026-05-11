TP4 - Calculs réseau

 Objectif
Introduction des calculs automatiques réseau.

Notions étudiées
Méthodes statiques, calculs réseau, CIDR, logique algorithmique, classes utilitaires.

Tests réalisés

- Calcul du nombre d'hôtes pour différents CIDR (/8, /16, /24, /25, /26).
- Detection de la classe réseau (A, B, C) selon le premier octet.
- Conversion du CIDR en masque decimal (255.255.255.0, etc).
- Test estReseauPrive : 192.168.1.0 = true, 8.8.8.8 = false.

 Difficultés rencontrées

- Comprendre la formule 2^(32-CIDR) - 2 pour le calcul des hotes.
- Corriger les erreurs de comparaison dans estReseauPrive (>= au lieu de <=).
- Bien fermer les accolades du switch dans obtenirMasqueDecimal.

 Réponses aux questions

1. On a créé une classe utilitaire pour centraliser les calculs réseau
   et éviter les répétitions dans le reste du code.

2. Le mot-clé static permet d'appeler une méthode sans créer d'objet.
   Exemple : CalculateurReseau.calculerNombreHotes(24).

3. Les calculs réseau sont importants dans un outil IPAM pour éviter
   les erreurs manuelles et automatiser la planification des adresses.

4. Le CIDR permet d'indiquer la taille d'un réseau en un seul chiffre.
   Exemple : /24 signifie 254 hotes disponibles.

5. Le nombre d'hotes dépend du masque car le masque définit combien
   de bits sont réservés aux hotes. Plus le CIDR est grand, moins
   il y a d'hotes disponibles.

6. Certaines adresses IP sont privées car elles sont réservées aux
   réseaux internes et ne sont pas routables sur Internet.

7. La séparation entre logique métier et logique de calcul améliore
   le projet car chaque classe a un rôle précis, ce qui facilite
   la maintenance et les modifications futures.

8. Les outils de planification réseau doivent automatiser les calculs
   pour éviter les erreurs humaines, gagner du temps et gérer
   efficacement de grands parcs d'adresses IP.

RESULTATS OBTENUS: 

run:

Infrastructure : Infrastructure YFY

===== SOUS-R�SEAUX =====
Sous-r�seau : ADMIN
R�seau : 192.168.1.0/24
Description : Reseau Administration
Classe r�seau : Classe C
Masque d�cimal : 255.255.255.0
Capacit� maximale : 254 h�tes

Sous-r�seau : TECH
R�seau : 172.16.0.0/16
Description : Reseau Technique
Classe r�seau : Classe B
Masque d�cimal : 255.255.0.0
Capacit� maximale : 65534 h�tes

Sous-r�seau : WIFI
R�seau : 10.0.0.0/8
Description : Reseau WiFi
Classe r�seau : Classe A
Masque d�cimal : 255.0.0.0
Capacit� maximale : 16777214 h�tes

Sous-r�seau : SERVEURS
R�seau : 192.168.2.0/25
Description : Reseau Serveurs
Classe r�seau : Classe C
Masque d�cimal : 255.255.255.128
Capacit� maximale : 126 h�tes

Sous-r�seau : DMZ
R�seau : 192.168.3.0/26
Description : Reseau DMZ
Classe r�seau : Classe C
Masque d�cimal : 255.255.255.192
Capacit� maximale : 62 h�tes


===== �QUIPEMENTS =====
===== TEST RESEAU PRIVE =====
192.168.1.0 prive : true
172.16.0.0 prive  : true
10.0.0.0 prive    : true
8.8.8.8 prive     : false
BUILD SUCCESSFUL (total time: 0 seconds)
