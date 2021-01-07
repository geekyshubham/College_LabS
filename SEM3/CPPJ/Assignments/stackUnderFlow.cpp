#include <iostream>
#define size 4
using namespace std;

class stack{
     int top;
     int data[size];

     public:
     stack(){
          top=-1;
     }
     int push(int x){
          try{
          if (top>=size-1){
               throw "STACK OVERFLOW";
               
          }
          else{
               data[++top]=x;
          }} 
          catch(const char* e){
               cout<<"ERROR:"<<e<<endl;
          }
     }

     int pop(){
          try{
          if (top>=0){
               --top;
               cout<<"Popped Element:"<<data[top+1]<<endl;
          }
          else{
               throw "STACK UNDERFLOW";
          }}
          catch(const char* e){
               cout<<"ERROR:"<<e<<endl;
          }
          
     };
     int display(){
          int i = top;
          cout<<"ELEMENTS ARE:";
          while(i>=0){
               cout<<data[i]<<" ";
               --i;
          }
     }

};

int main(){
     stack s;
     int x=0;
     int temp;
     cout<<"ENTER APPROPRIATE OPTION"<<endl;
     while(x<4){
          cout<<endl;
          cout<<"1.PUSH"<<endl;
          cout<<"2.POP"<<endl;
          cout<<"3.DISPLAY"<<endl;
          cout<<"EXIT WITH ANYTHING ELSE"<<endl;
          cout<<"INPUT:";
          cin>>x;
          switch(x){
               case 1:
               cout<<"Enter Element to Insert:";
               cin>>temp;
               s.push(temp);
               break;
               case 2:
               s.pop();
               break;
               case 3:
               s.display();
               break;
               default:
               return 1;
          }
     }
}

