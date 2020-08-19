Q1:write a program to calculate area triangle rectangle and circle using function overloading
==>
#include<stdio.h>
#define pi 3.14
int main()
{
float area(float r){
	return(pi*r*r);
}

float area(float b,float h){
	return((b*h)/2);
}

float area(float w,float h){
	return(w*h);
}

int key;
floar b,w,h = 0;
do{
	printf("Please Choose Appropriate Option");
	print("1.area of circle\n2.area of triangle\n3.area of rectangle\nPRESS 0 TO EXIT");
	scanf("%d",&key);
	switch(key){
		case 1:printf("enter radius of circle");scanf("%f",&r);printf("area of circle is:%f",area(r));break;
		case 2:printf("enter breadth and height of triangle");scanf("%f %f",&b,&h);printf("area of triangle is:%f",area(b,h));break;
		case 3:printf("enter width and height of rectangle);scanf("%f %f",&w,&h);printf("area of rectangle is:%f",area(w,h));break;	
	}
while(key!=0);
return 0;
}


Q2:write a program to find out absolute of integer variable double variable and float variable
==>

#include <stdio.h>

int num
float fnum
double dnum

int main()
{

int abs(int num){
	if (num<0){num=-num;return(num);}
float abs(float num){
	if (num<0){num=-num;return(num);}
double num(double num){
	if (num<0){num=-num;return(num);}
}

}

