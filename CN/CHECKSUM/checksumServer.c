#include <stdio.h>


#include <stdlib.h>


#include <string.h>


#include <sys/types.h>


#include <sys/socket.h>


#include <netinet/in.h>


#include <unistd.h>


#include <arpa/inet.h>


#include "checksum.c"


#define RESET(buff) for (int i = 0; i < 100; i++) {buff[i] = '\0';}



void error(const char *msg)


{


    perror(msg);


    exit(1);


}



int main(int argc, char const *argv[])


{


    int sockfd, newsockfd, i;


    struct sockaddr_in serv_addr, cli_addr;


    char buff[100], temp[100], data[100];


    char res[100];


    int clilen;



    //Checking the provided port no


    if (argc < 2)


        error("Port No not provided");



    serv_addr.sin_family = AF_INET;


    serv_addr.sin_addr.s_addr = INADDR_ANY;


    serv_addr.sin_port = htons(atoi(argv[1]));



    //Socket


    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)


        error("Error in Socket");



    //Binding


    if (bind(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)


        error("Error in binding");



    //Listen


    listen(sockfd, 5);



    while (1)


    {



        clilen = sizeof(cli_addr);



        newsockfd = accept(sockfd, (struct sockaddr *)&cli_addr, &clilen);


        if (newsockfd < 0)


            error("Error in Accept");



        RESET(buff)


        strcpy(buff, " Enter the 1st data : ");


        send(newsockfd, buff, 100, 0);



        RESET(data)


        recv(newsockfd, data, 100, 0);


        RESET(buff);


        strcpy(buff, "Enter the 2nd data : ");


        send(newsockfd, buff, 100, 0);



        RESET(buff);


        recv(newsockfd, buff, 100, 0);



        printf("\n From Client : %s \n", data);


        RESET(res)


        add(data, buff, temp);


        complement(temp, res);


        


        send(newsockfd, res, 100, 0);


        RESET(buff)


        recv(newsockfd, buff, 100, 0);


        printf("\n Message from Client : %s \n", buff);


        close(newsockfd);


    }



    return 0;


}