# The Team
### Team Members
* Team Member 1: Abdelwahab Mohamed Mohamed Zayed
* Team Member 2: Ahmed Ali ElSayed Sharaf Eldin
* Team Member 3 : Esraa Sayed Ahmed Elsayed
* Team Member 4: Nada Mohammed kamal Mohammed Rashad Elmasry

# Tic-Tac-Toe

<p align="center">
   <img src="https://user-images.githubusercontent.com/53404081/158055618-9e562db8-feb4-42ee-965b-32c61512b8e2.png" alt="Build Status" width="300">
   <img src="https://user-images.githubusercontent.com/53404081/158030235-87690d2f-42ab-403d-993e-e74c4f4b3fd2.jpeg" alt="Build Status" width="300">

</p>

## Description:
 
* A Network-based Tic-Tac-Toe application consists mainly of two applications, `server` and `client`. 
* The Application is done mainly using `JavaFX` 
* The server has a `JAVA-DB-SERVER` database that stores all the information about the players. and The games they are played. 
* The application is designed using the  `MVC` pattern. 
* Clients can choose from three choices:
1) Play with a computer with three levels options:-
    - Easy
    - Medium
    - Hard
2) Play locally with someone
3) play online with someone
4) Play snake game with abilty to choose the color of the snake


## main features

- Nice looking User Interface
- Register to the game
- Server-side validation
- Play with `ai computer`
- Updated list with full information about the registered players
- The ability to `play` with any player on the list
- The ability to replay any previous game from the `history` list
- in Server Application, you have the same players  list with the ability to `toggle` server tatus

### Application Features details

- Sign up as a first-time player or Sign in
- Every player have bonus points they gain after winning any game
- player can play in a `single-mode game` with `ai`
- Every player will have an updated list of the whole players in the server database 
this with the information of their `name`, `Score`, `isOnline[online, offline]`, `in Game or not`
- The player can click on any player in the list and `play` with him
only if this player is `online` and if the player is not in `game`.
- The server handles most of the possible scenarios that can happen in the application during the game or because of any issue.
- The player can replay any game from history.

## Designs
### Database Schema
<p align="center">
       <img src="https://user-images.githubusercontent.com/53404081/158031031-b2f5ec7b-c5e1-4998-bb25-41f100f5e57c.png" alt="Build Status">
</p>

### How to play

- First Clone The Project
- Install java 8.1
- Install NetBeans IDE 8.2
- After creating the database you can now build and run the server project using NetBeans
- You can lunch the Client App using the executable jar file or using NetBeans 
- If you have any problems running the game feel free to contact us
- Note that the server is running by default on port 5555  you can change this in the Server class
- Note: you will never be able to try the online game without the server you have to open the server first 
- You can download the jar file from this link: https://drive.google.com/drive/folders/1Oz8-3guxBbwhv6u02cowI5hiMcYwRndV?usp=sharing
## Screenshots
<table>
  <tr>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031389-2fdb8e1c-0594-4c44-9359-be43f64bcfee.jpeg"> </img>
    </td>
   <td>
      <img src="https://user-images.githubusercontent.com/53404081/158031388-3ffbdd34-675c-4bc5-9be6-ba301be8c3c1.jpeg"></img>
   </td>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031387-c0a1970c-6051-4700-94bf-09222c6437b0.jpeg"></img>
    </td>
  </tr>
   <tr>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031386-aa3eca77-972b-4702-942d-c97f09bba0c7.jpeg"></img>
    </td>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031385-9884b8b1-2847-4f66-af4c-6470ff0c3231.jpeg"></img>
    </td>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031384-63e50b73-0ede-49bc-9d30-82050da6ac38.jpeg"></img>
    </td>
  </tr>
  <tr>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031383-84618dbd-d1d9-4d4c-b871-1ac7b2db0dc9.jpeg"></img>
    </td>
      <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031382-3a333960-2636-4e99-8135-b5f3448a5650.jpeg"></img>
    </td>
     <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031380-e964f4af-6cb4-4851-a3a7-1e705b5347bd.jpeg"></img>
    </td>
  </tr>
   <tr>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031378-3dacbbef-f00b-4943-9177-a1ef0e21585a.jpeg"></img>
    </td>
      <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031376-71c90a64-91fd-482d-9b4e-312ed5ae6dde.jpeg"></img>
    </td>
     <td>
       <img src="https://user-images.githubusercontent.com/53404081/158055618-9e562db8-feb4-42ee-965b-32c61512b8e2.png"></img>
    </td>
  </tr>
   <tr>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031393-3174ba8a-5a0e-43cb-bb62-be9a670ee5fd.jpeg"></img>
    </td>
      <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031404-d6d0f753-92a6-4edc-9b8d-13de65d0fa63.jpeg"></img>
    </td>
     <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031403-5d2dc438-6ea5-48ae-8b97-3113e301bc45.jpeg"></img>
    </td>
  </tr>
   <tr>
    <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031401-b3273b81-9daf-4608-ae01-bedcf25c264a.jpeg"></img>
    </td>
      <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031398-33a97b94-f9a8-4f26-bcc0-49e0d906d47e.jpeg"></img>
    </td>
     <td>
       <img src="https://user-images.githubusercontent.com/53404081/158031396-f8c660f4-2475-4880-ac40-9bd6b4250754.jpeg"></img>
    </td>
  </tr>
</table>
