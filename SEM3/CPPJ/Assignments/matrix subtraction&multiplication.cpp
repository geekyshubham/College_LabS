#include<iostream>
using namespace std;

class matrix{
  public:
  int m[3][3];
  matrix(){
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        m[i][j]=0;
      }
    }
  }
  void setMatrix(){
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        cout<<"Enter elment at i:"<<i<<" and j:"<<j<<" =>";
        cin>>m[i][j];
      }
    }
  }
  void printMatrix(){
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        cout<<m[i][j]<<",";
      }
    cout<<"\n";
    }
  }
  matrix operator *(matrix obj){
    matrix temp;
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
  temp.m[i][j]=0;
  for(int k=0;k<3;k++){
        temp.m[i][j]=temp.m[i][j]+m[j][k]* obj.m[k][j];
  }
      }

  }
  return temp;
}
matrix operator -(matrix obj){
    matrix temp;
    for (int i=0;i<3;i++){
      for(int j=0;j<3;j++){
  temp.m[i][j]=m[i][j] -obj.m[i][j];
      }

  }
  return temp;
}
};

int main()
{
  matrix a,b,c,d;
  a.setMatrix();
  b.setMatrix();
  c=a*b;
  cout<<"MATRIX A: \n";
  a.printMatrix();
  cout<<"\nMATRIX B: \n";
  b.printMatrix();
  cout<<"\nRESULT MULTIPLICATION MATRIX C: \n";
  c.printMatrix();
  d=a-b;
  cout<<"\nRESULT SUBSTRACTION MATRIX D: \n";
  d.printMatrix();
}
