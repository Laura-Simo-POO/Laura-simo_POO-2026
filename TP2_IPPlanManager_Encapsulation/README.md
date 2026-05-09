# TP2 - Encapsulation
ETUDIANT: SIMO MEUTCHEHE LAURA

 Objectif
Introduction de l'encapsulation et des validations.

 Notions étudiées
- private
- getters
- setters
- validation
- this

 Tests réalisés

- Adresse IP vide → remplacée par 0.0.0.0
- Adresse IP null → remplacée par 0.0.0.0
- Masque CIDR invalide (55) → remplacé par 24
- Adresse réseau vide → remplacée par 0.0.0.0
- Equipement sans nom → remplacé par equipement_inconnu
- Interface sans nom → remplacée par interface_inconnue

 Réponses aux questions

1. Pourquoi utilise-t-on private dans les classes ?

On utilise private pour empêcher toute modification directe des attributs depuis l'extérieur de la classe. Cela protège les données contre des valeurs incorrectes ou dangereuses.

2. Quelle différence entre un attribut public et private ?

Un attribut public est accessible et modifiable depuis n'importe quelle classe. Un attribut private n'est accessible que depuis l'intérieur de la classe elle-même.

3. Pourquoi utilise-t-on des getters et setters ?

Les getters permettent de lire les attributs privés. Les setters permettent de les modifier tout en validant les données avant de les accepter.

4. Pourquoi les validations sont-elles importantes dans un logiciel réseau ?

Une adresse IP invalide ou un masque incorrect peut provoquer des erreurs de routage, des conflits réseau ou des pannes. La validation évite ces problèmes.

5. Quel est le rôle du mot-clé this ?

this désigne l'objet courant. Il permet de distinguer un attribut de la classe d'un paramètre portant le même nom.

6. Pourquoi le constructeur appelle-t-il les setters ?

Pour réutiliser la validation déjà écrite dans le setter, évitant ainsi de dupliquer le code de vérification.

7. Pourquoi la validation du masque CIDR est-elle importante ?

Un masque CIDR doit être compris entre 0 et 32. Un masque comme 55 est impossible en IPv4 et provoquerait des erreurs de calcul réseau.

8. Pourquoi l'encapsulation améliore-t-elle la sécurité logicielle ?

Elle empêche les modifications non contrôlées des données. Seules les méthodes autorisées peuvent modifier les attributs, ce qui rend le programme plus fiable et robuste.

RESULTATS OBTENUS (RUN FILE)

run:
===== TP2 : Encapsulation =====
Erreur : adresse IP invalide.
Erreur : adresse IP invalide.
Adresse r�seau invalide.
Masque CIDR invalide.

----- R�seau 1 -----
R�seau : 192.168.1.0/24
Description : R�seau principal

----- R�seau 2 -----
R�seau : 0.0.0.0/24
Description : Aucune description

----- �quipement 1 -----
Nom : R1_EDGE
Type : Routeur
Interface : eth0
Adresse IP : 192.168.1.1
�tat : active

----- �quipement 2 -----
Nom : equipement_inconnu
Type : Type inconnu
Interface : interface_inconnue
Adresse IP : 0.0.0.0
�tat : inactive
BUILD SUCCESSFUL (total time: 0 seconds)