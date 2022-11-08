# EE302LAB2
## statement

This project is only used for the experiment of FZU20 EE308FZ and LAB2. In order to facilitate the test, I closed the verification system. Please do not use xss, sql injection and other ways to attack the project server, which will not make any sense ~~

The open source protocol follows the MIT License, which means you can use it for anything, as long as you add my information.

## Overview of Project Results

| **Grading standards**                  | implementation                                               |
| -------------------------------------- | ------------------------------------------------------------ |
| single machine form                    | YES, You can sign up and play solo at our demo link          |
| support network connection,online from | YES,You can play multiplayer by entering the room number in our demo link |
| Degree of innovation                   | YES,Our innovative use of lightweight design makes joining the game easier |
| Degree of interface beautification     | We designed the interface to be easy to use and made it as beautiful as possible |
| Blog description                       | YES                                                          |
| Code specification                     | YES, Java reference Ali specification manual, MySql design, API document design are in accordance with the corresponding paradigm |
| Git commits                            | YES, My teammates and I all submitted it at least three times |

We have realized multi-player and single-player bobing games, and deployed the project to the ECS server of Ali Cloud. You can register and log in, and choose the corresponding mode to participate in bobing games. 

The game will randomly generate six-sided dice and display them, the results will be judged automatically, and you can view your own historical results. You can throw it every ten seconds.

Multiplayer mode based on the single player mode, can display the results of all players in the same room, a room supports **up to 6** players.





## Document the project development process

### key  functions

**Basic function:** In the game page you could shake six dices and then they will gerenate 6 random values. The web could automativally judge your grades and then display on the screen.

**Advanced function:** If choose stand-alone mode, we could play the game and the result will be recorded. After login in a account, some users could take part into a room. They could play the game toghther, and all grades will be displayed on the ranking board which every participants could see.



### Pair programming experience

At first I have a deep talk about the web product and then choose different parts of it. We made many immediate communication and made changes to alter our product. In this process, we gained a lot of practical measures to coordinate and polish our product. After this experience, wo become better and be capable of conquering harder problems.



### Difficulties and Solutions,and give my great gains.

 It is hard to have a effective way to communicate and reduce the errors between two people. Then we choose anterior and posterior end separation to cover it. It greatly save energy and time. Also we  learned many new knowledge about web which I did not know before.

