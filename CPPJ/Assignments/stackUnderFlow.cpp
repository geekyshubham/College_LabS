#include<iostream>
#define size 5
using namespace std;

  class stack
{
     int data[size];
     int top;
public:
     stack()
     {
          top=-1;
     }
     void push();
     void pop();
     void display();
};

void stack::push()
{try{
     if(top==size-1)
     {
          throw top;
          return;
     }
     else
     {
          top++;
          cout<<"Enter Data : ";
          cin>>data[top];
     }}
     catch(...){
          cout<<"Stack Overflow";
     }
}

void stack::pop()
{   try{
     if(top==-1)
          throw top;

     else
     {
          cout<<data[top]<<"deleted "<<endl;
          top--;
     }
}
catch(int i){
    cout<<"Stack Underflow";
}

}


void stack::display()
{
     int t=top;
     while(t>=0)
     {
          cout<<data[t]<<endl;
          t--;
     }
}

int main()
{
     stack st;
     int ch;
     do
     {
          cout<<"\n1. Push\n2. Pop\n3. Display \n4.Quit\nEnter Choice(1-4) ";
          cin>>ch;
          switch(ch)
          {
               case 1: st.push();break;
               case 2: st.pop();break;
               case 3: st.display();
          }
     }while(ch!=4);
}

