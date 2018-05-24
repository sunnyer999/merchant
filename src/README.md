#  Merchant's Guide to the Galaxy

> qh.luo@foxmail.com

## Introduction

You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
Symbol | Value | 
----|------|
I | 1  | 
V | 5  | 
X | 10  | 
L | 50  | 
C | 100  | 
D | 500  | 
M | 1000  | 
 
## Example
### Test input:
`glob is I` </br>
`prok is V` </br>
`pish is X` </br>
`tegj is L` </br>
`glob glob Silver is 34 Credits` </br>
`glob prok Gold is 57800 Credits` </br> 
`pish pish Iron is 3910 Credits` </br> 
`how much is pish tegj glob glob ?` </br> 
`how many Credits is glob prok Silver ?` </br> 
`how many Credits is glob prok Gold ?` </br>
`how many Credits is glob prok Iron ?` </br>
`how much wood could a woodchuck chuck if a woodchuck could chuck wood ?` </br> 

### Test output:
`pish tegj glob glob is 42` </br>
`glob prok Silver is 68 Credits` </br>
`glob prok Gold is 57800 Credits` </br>
`glob prok Iron is 782 Credits` </br>
`I have no idea what you are talking about` </br>

## Requirements

- Implemented and tested using **JDK8**

- Tests require **JUnit4**