Q1:write a program to calculate area triangle rectangle and circle using function overloading
==>
#include<iostream>
#define pi 3.14
using namespace std;

float area(float r){
	return(pi*r*r);
}

float area(float b,float h){
	return((b*h)/2);
}

float area(float w,int h){
	return(w*h);
}


int main()
{
float area(float r);
float area(float w,int h);
float area(float b,float h);


int key;
float r,b,w,h = 0;
do{
	cout<<"Please Choose Appropriate Option";
	cout<<"1.area of circle\n2.area of triangle\n3.area of rectangle\nPRESS 0 TO EXIT";
  cin>>key;
	switch(key){
		case 1:cout<<"\nenter radius of circle";
    cin>>r;
    cout<<"\narea of circle is: " << area(r);
    break;
		case 2:cout<<"\nenter breadth and height of triangle";cin>>b>>h;
    cout<<"\narea of triangle is "<< area(b,h);
    break;
		case 3:cout<<"\nenter width and height of rectangle";
    cin>>w>>h;
    cout<<"\narea of rectangle is:%f",area(w,h);
    break;
    default:cout<<"\nenter Appropriate Option";
	}
}
while(key!=0);


return 0;
}




int main()
{
float area(float r);
float area(float w,int h);
float area(float b,float h);


int key;
float r,b,w,h = 0;
do{
	cout<<"Please Choose Appropriate Option";
	cout<<"1.area of circle\n2.area of triangle\n3.area of rectangle\nPRESS 0 TO EXIT";
  cin>>key;
	switch(key){
		case 1:cout<<"\nenter radius of circle";
    cin>>r;
    cout<<"\narea of circle is: " << area(r);
    break;
		case 2:cout<<"\nenter breadth and height of triangle";cin>>b>>h;
    cout<<"\narea of triangle is "<< area(b,h);
    break;
		case 3:cout<<"\nenter width and height of rectangle";
    cin>>w>>h;
    cout<<"\narea of rectangle is:%f",area(w,h);
    break;
    default:cout<<"\nenter Appropriate Option";
	}
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



