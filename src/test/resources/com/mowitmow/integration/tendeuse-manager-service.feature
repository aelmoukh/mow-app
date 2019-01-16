Feature: Features of my service

 Scenario Outline: Excecution service tendeuse manager 
 Given tendeuse service initié
 When tendeuse service execute "<instructions>"
 Then le resultat doit être "<result>"
Examples:
 |instructions|result|
 |5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA|1 3 N\n5 1 E\n|
