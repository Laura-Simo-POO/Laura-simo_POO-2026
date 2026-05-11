TP5 - Moteur VLSM

Etudiante: SIMO MEUTCHEHE Laura

Objectif: Développer un moteur VLSM capable de proposer automatiquement un plan d'adressage à partir des besoins exprimés.

 Notions étudiées
VLSM, tri de collections, classe de service métier, calcul CIDR, conversion IP-entier, génération automatique de sous-réseaux.

Scénarios testés

Scénario 1 : Entreprise principale (192.168.1.0)
- TECHNIQUE : 120 hôtes
- WIFI : 80 hôtes
- ADMINISTRATION : 50 hôtes
- SERVEURS : 20 hôtes
- DIRECTION : 10 hôtes

Scénario 2 : Petite entreprise (192.168.10.0)
- WIFI_INVITES : 40 hôtes
- ADMIN : 25 hôtes
- COMPTABILITE : 12 hôtes
- SERVEURS : 8 hôtes

Scénario 3 : Campus (172.16.0.0)
- ETUDIANTS : 500 hôtes
- WIFI_PUBLIC : 200 hôtes
- PERSONNEL : 120 hôtes
- LABORATOIRE : 60 hôtes
- ADMINISTRATION : 40 hôtes

 Résultats obtenus:

run:
===== SCENARIO 1 : Entreprise principale =====

Besoins exprimes :
Besoin : TECHNIQUE | H�tes demand�s : 120
Besoin : WIFI | H�tes demand�s : 80
Besoin : ADMINISTRATION | H�tes demand�s : 50
Besoin : SERVEURS | H�tes demand�s : 20
Besoin : DIRECTION | H�tes demand�s : 10

Plan d'adressage propose :
TECHNIQUE -> 192.168.1.0/25 | Plage : 192.168.1.1 - 192.168.1.126 | Capacite : 126 hotes
WIFI -> 192.168.1.128/25 | Plage : 192.168.1.129 - 192.168.1.254 | Capacite : 126 hotes
ADMINISTRATION -> 192.168.2.0/26 | Plage : 192.168.2.1 - 192.168.2.62 | Capacite : 62 hotes
SERVEURS -> 192.168.2.64/27 | Plage : 192.168.2.65 - 192.168.2.94 | Capacite : 30 hotes
DIRECTION -> 192.168.2.96/28 | Plage : 192.168.2.97 - 192.168.2.110 | Capacite : 14 hotes

===== SCENARIO 2 : Petite entreprise =====

Besoins exprimes :
Besoin : ADMIN | H�tes demand�s : 25
Besoin : COMPTABILITE | H�tes demand�s : 12
Besoin : WIFI_INVITES | H�tes demand�s : 40
Besoin : SERVEURS | H�tes demand�s : 8

Plan d'adressage propose :
WIFI_INVITES -> 192.168.10.0/26 | Plage : 192.168.10.1 - 192.168.10.62 | Capacite : 62 hotes
ADMIN -> 192.168.10.64/27 | Plage : 192.168.10.65 - 192.168.10.94 | Capacite : 30 hotes
COMPTABILITE -> 192.168.10.96/28 | Plage : 192.168.10.97 - 192.168.10.110 | Capacite : 14 hotes
SERVEURS -> 192.168.10.112/28 | Plage : 192.168.10.113 - 192.168.10.126 | Capacite : 14 hotes

===== SCENARIO 3 : Campus =====

Besoins exprimes :
Besoin : ETUDIANTS | H�tes demand�s : 500
Besoin : PERSONNEL | H�tes demand�s : 120
Besoin : LABORATOIRE | H�tes demand�s : 60
Besoin : ADMINISTRATION | H�tes demand�s : 40
Besoin : WIFI_PUBLIC | H�tes demand�s : 200

Plan d'adressage propose :
ETUDIANTS -> 172.16.0.0/23 | Plage : 172.16.0.1 - 172.16.1.254 | Capacite : 510 hotes
WIFI_PUBLIC -> 172.16.2.0/24 | Plage : 172.16.2.1 - 172.16.2.254 | Capacite : 254 hotes
PERSONNEL -> 172.16.3.0/25 | Plage : 172.16.3.1 - 172.16.3.126 | Capacite : 126 hotes
LABORATOIRE -> 172.16.3.128/26 | Plage : 172.16.3.129 - 172.16.3.190 | Capacite : 62 hotes
ADMINISTRATION -> 172.16.3.192/26 | Plage : 172.16.3.193 - 172.16.3.254 | Capacite : 62 hotes
BUILD SUCCESSFUL (total time: 0 seconds)

 Difficultés rencontrées
La méthode obtenirClasseReseau() du TP4 était absente dans le nouveau CalculateurReseau du TP5, ce qui causait une erreur dans ReseauIP. 
Elle a été réintégrée dans la classe.

Réponses aux questions

1. Le VLSM attribue à chaque sous-réseau exactement la taille nécessaire. 
Sans VLSM, tous les sous-réseaux auraient le même masque, ce qui gaspillerait beaucoup d'adresses inutilisées.

2. Si on place d'abord les petits réseaux, l'espace disponible se fragmente et les grands blocs ne peuvent plus être placés correctement aux bonnes 
adresses alignées.

3. Un BesoinReseau représente ce que l'utilisateur demande (nom + nombre d'hôtes). Un ResultatVLSM représente ce que l'application calcule et propose 
(adresse réseau, CIDR, masque, plage utilisable).

4. Elle n'est pas un simple conteneur de données. Elle applique une logique algorithmique complète : tri, calcul de CIDR, avancement d'adresse, pour 
produire un plan d'adressage utile.

5. Une adresse IP est un nombre 32 bits. La convertir en entier permet d'utiliser directement les opérations arithmétiques, comme additionner 
la taille d'un bloc pour passer au sous-réseau suivant.

6. Elle cherche automatiquement le plus petit CIDR tel que 2^(32-cidr) - 2 >= nombreHotes. C'est l'algorithme central du moteur VLSM.

7. L'adresse réseau identifie le sous-réseau lui-même. L'adresse de broadcast sert à envoyer un message à toutes les machines du sous-réseau. Les attribuer 
à une machine provoquerait des conflits réseau.

8. C'est la première vraie logique métier du projet. L'application ne fait plus seulement des calculs simples, elle produit automatiquement un plan 
d'adressage complet à partir des besoins de l'utilisateur.