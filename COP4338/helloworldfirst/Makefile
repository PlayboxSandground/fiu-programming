all: helloworld
helloworld.o: helloworld.c
	gcc -c helloworld.c -o helloworld.o
printhello.o: printhello.c
	gcc -c printhello.c -o printhello.o
helloworld: helloworld.o printhello.o
	gcc helloworld.o printhello.o -o helloworld