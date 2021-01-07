#include<iostream>
//EXCEPTION HANDLINF

using namespace std;

int main()
{
    //DivideByZero
    int x,y;
    cout<<"Enter First No to divide:";
    cin>>x;
    cout<<"Enter First No to divide:";
    cin>>x;
    try
    {
        if (x==0 || y==0){
        throw "Division by zero Error!";
        }
        else{
        cout<<"Division is:"<<y/x<<endl;

        }
    }

    catch(char const*e)
    {
        cout<<e<<endl;
    }
    
    

    //ArrayOutOfBound
    int arrays[]={1,2,3,4,5};
    cout<<"Array:1,2,3,4,5"<<endl;
    cout<<"Enter Element to Access from Array:";
    int i;
    cin>>i;
    try{
        if(i<0 || i>4){
            throw "Array Index Out Of Bound";
        }
        else{
            for(int i:arrays){
                cout<<i<<" ";
            }
            cout<<endl;
        }
    }
    catch(char const*f){
        cout<<f<<endl;
    }
    //hold screen
    cin>>y;

}