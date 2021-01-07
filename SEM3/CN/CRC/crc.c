 #include <stdio.h>
 #include <string.h>
 void main()
 {
    char message[20],genKey[8],copyMsg[20],copyKey[8],quot[10],temp[10],rem[30];
    int keyLength,msgLength;
    int i,j;

    printf("\nEnter Raw Message: ");
    gets(message);
    printf("\nEnter CRC Generator Key: ");
    gets(genKey);
    
    keyLength=strlen(genKey);
    msgLength=strlen(message);

    int appendZeros=keyLength-1;

    printf("Raw Message: ");

    for(i=0;i<strlen(message);i++)
        printf(" %c ",message[i]);
    
    for(i=0;i<appendZeros;i++)
        strcat(message,"0");
    
    strcpy(copyMsg,message);
    strcpy(copyKey,genKey);

    printf("\nAfter Appending Zeroes: ");
    
    for(i=0;i<strlen(copyMsg);i++)
        printf(" %c ",copyMsg[i]);

    for(i=0;i<keyLength;i++)
        temp[i]=message[i];

    for(i=0;i<msgLength;i++)
    {                                                                              // 1 001 00000  && 1101
        quot[i]=temp[0];
        if(quot[i]=='0')
            for(j=0;j<keyLength;j++)
                genKey[j]='0';
        else
            for(j=0;j<keyLength;j++)
                genKey[j]=copyKey[j];

            for(j=keyLength-1;j>0;j--)
            {
                if(temp[j]==genKey[j])
                    rem[j-1]='0';
                else
                    rem[j-1]='1';
            }

            rem[keyLength-1]=message[i+keyLength];
            strcpy(temp,rem);
   }
    strcpy(rem,temp);

    printf("\nCRC is ");

    for(i=0;i<keyLength-1;i++)
        printf(" %c ",rem[i]);

    printf("\nFinal data is: ");

    for(i=0,j=msgLength;i<keyLength-1;i++,j++)
        copyMsg[j]=rem[i];

    for(i=0;i<strlen(copyMsg);i++)
        printf(" %c ",copyMsg[i]);

 }