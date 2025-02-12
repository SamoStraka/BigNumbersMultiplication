## TASK

### Option 1 - Calculate multiplication
=======================
Write a program which computes the multiplication of two large numbers (integers) entered as command
line arguments.
Each number can have any number of digits (up to the maximum length of a CLI argument, try at least 20
digits for each).
It is mandatory to provide two implementations of the algorithm computing the multiplication (one of
them can use e.g.: BigInteger class another one should implement the algorithm from scratch).
The program must have an ability to choose one of the implementations by arguments.
It is also mandatory to implement at least one Unit test which computes multiplication using both
algorithms for the same inputs and compares results which must be equal.
E.g. for 12345678901234567890*11111111111111111111:
$ java -jar multiply.jar --alg1 12345678901234567890 11111111111111111111
Or
$ java -jar multiply.jar --alg2 12345678901234567890 11111111111111111111
output:
137174210013717420998628257899862825790