# interactif

## install 

### server

#### manual install
cd  into **server/src**

install requirments with pip
> pip install -r requirements.txt

Run the server with 
> flask run 

#### docker
cd into server

build and launch the container
> docker-compose up



## usage


## MVP
### User scenario :

The user can crop the image on the left or the right

- v2 flashes qr code
- v2 goes on domain.com/roomcode
- v1 clicks on squeeze
- v1 can see that the image starts to be masked on the top and bottom edge of the image
- tries to click on squeeze again => has to wait 10 seconds

#### Routes
v2 /api/room/check => checks if the room is created and available

**v1 /api/effects/mask/pitterboxing**
POST
params :
letterboxing : integer
pillarboxing : integer


returns :
status 200


**v1 /api/novel/responses**

## back
python flask server or laravel ? or node ?
no db just text files ?

### DB structure




## front

### web interface
laravel ? react ?







## Media server
### chataigne 
interface between the api and Resolume

### processing layers


# Applications
## Visual novel

### Outils
Textes interactifs générés avec [SayWhat](https://nathanhoad.itch.io/saywhat)
Pour l'instant on se cantonne à 1 séquence.

Jeu lui-même créé avec Godot https://godotengine.org/

### Objectifs & features
- Histoire interactive
- Choix multiples
- Spectateurs votent pour les choix lors d'une réplique d'un personnage joueur
- Portraits de personnages
- Arrière-plans représentatifs de la scène

### Extensions
- Explorer la possibilité de plusieurs personnages joueurs.
	- Utilisateurs verrouillés sur l'un des personnages joueurs => dialogue indirect entre les utilisateurs

### Documentation

#### Scènes
Héritent de la scène `TEMPLATE.tscn`.
La première ligne est renseignée dans le noeud `Control` > `first_line` (les séquences de SayWhat sont ignorées lors de l'export, elles n'existent que pour l'organisation lors de l'écriture).

#### Chargement de scène
Instruction dans SayWhat pour charger la scèene suivante: `do load_scene SceneName`

Les scènes dans Godot sont à mettre dans `res://scenes`. Les nommer sans espaces.