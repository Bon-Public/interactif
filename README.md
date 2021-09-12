# interactif

# Stack

**Back**
Meteor.JS API
MongoDB

**Front**
React



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

**v1 /api/effects/mask**
GET

returns :
x1,y1,x2,y2 (pixels)

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