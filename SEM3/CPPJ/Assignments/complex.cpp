#include<iostream>
using namespace std;

class Complex{
private:
  int m_real;
  int m_imag;
public:
  Complex(int i=0,int r=0){
    m_real=r;
    m_imag=i;
  }
  void inputValues(){
    cout<<"\nEnter Real Number: ";
    cin>>m_real;
    cout<<"Enter Imaginary Number: ";
    cin>>m_imag;
  }

  
  Complex operator+(Complex obj){
    Complex temp;
    temp.m_real=m_real+obj.m_real;
    temp.m_imag=m_imag+obj.m_imag;
    return temp;
  }
  void printValues(){
    cout<<"\nOUTPUT: "<<m_real<<"+"<<m_imag;
  }
  Complex operator++(){
    m_real=m_real+1;
    m_imag=m_imag+1;
    cout<<"\nReal no:"<<m_real<<" Imaginary no:"<<m_imag<<" after increment.";
  }
  Complex operator+=(Complex obj){
    m_real=m_real+obj.m_real;
    m_imag=m_imag+obj.m_imag;
    cout<<"\nReal no:"<<m_real<<" Imaginary no:"<<m_imag<<" after adding.";
  }
  Complex operator*=(Complex obj){
    Complex temp;
    m_real=m_real*obj.m_real;
    m_imag=m_imag*obj.m_imag;
    cout<<"\nReal no:"<<m_real<<" Imaginary no:"<<m_imag<<" after multiplication ";
  }
  
};

int main(){
  while(1){
  Complex a,b,c;
  a.inputValues();
  b.inputValues();
  c=a+b;
  c.printValues();
  ++a;
  a+=b;
  a*=b;
  }
}
