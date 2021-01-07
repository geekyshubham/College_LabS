#include <stdio.h>

#include <stdlib.h>

#include <string.h>

#include <sys/types.h>

#include <sys/socket.h>

#include <netinet/in.h>

#include <unistd.h>

#include <arpa/inet.h>

#include "checksum.c"

#define RESET(buff)               \
    for (int i = 0; i < 100; i++) \
    {                             \
        buff[i] = '\0';           \
    }

void error(const char *msg)

{

    perror(msg);

    exit(1);
}

int main(int argc, char const *argv[])

{

    int sockfd, i, j;

    struct sockaddr_in serv_addr;

    char buff[100], data2[100], data[100];

    char res[100], temp[100];

    //Checking the provided port no

    if (argc < 3)

        error("Port No not provided");

    serv_addr.sin_family = AF_INET;

    serv_addr.sin_addr.s_addr = inet_addr(argv[1]);

    serv_addr.sin_port = htons(atoi(argv[2]));

    //Socket

    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)

        error("Error in Socket");

    //Connect

    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)

        error("Error in connecting");

    //sending the data

    RESET(buff)

    recv(sockfd, buff, 100, 0);

    printf(" %s ", buff);

    scanf("%s", data);

    send(sockfd, data, 100, 0);

    //Sending the data2

    RESET(buff)

    recv(sockfd, buff, 100, 0);

    printf("%s", buff);

    scanf("%s", data2);

    send(sockfd, data2, 100, 0);

    //Get the checksum from server

    RESET(buff)

    recv(sockfd, buff, 100, 0);

    printf("From The server : %s \n", buff);

    //Check the checksum at receiver side

    RESET(res)

    RESET(temp)

    add(data, data2, res);

    add(res, buff, temp);

    complement(temp, res);

    printf("\nAt the receiver End : \n");

    for (i = 0; res[i] != '\0'; i++)

        printf("%c", res[i]);

    for (i = strlen(res) - 1, j = 1; j < strlen(data2); i--, j++)

    {

        if (res[i] == '1')

            break;
    }

    if (j < strlen(data2))

        send(sockfd, "Error", 100, 0);

    else

    {

        send(sockfd, "OKAY ", 100, 0);
    }

    close(sockfd);

    printf("\n");

    return 0;
}
