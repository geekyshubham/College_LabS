#include<iostream>
#include<string.h>

using namespace std;

class cStrings
{
    char str[100];
    int len;

    public:
    void getdata()
    {
        cout<<"\nEnter string:";
        cin>>str;
    }
    void showdata(){
        cout<<str<<endl;
    }
    void operator+(cStrings str1);
    void operator <(cStrings);
    void operator >(cStrings);
    void operator ==(cStrings);

};

void cStrings::operator==(cStrings str1)
{
    if(strcmp(str,str1.str)==0){
        cout<<"strings are equal"<<endl;
    }
    else{
        cout<<"strings are not equat"<<endl;
    }
}

void cStrings::operator+(cStrings str1)
{
    strcat(str,str1.str);
    cout<<"\nString After Concatination:"<<str<<endl;
}

void cStrings::operator>(cStrings str1)
{
    int tstr1=strlen(str1.str);
    int tstr=strlen(str);
    if(tstr1>tstr){
        cout<<str1.str<<" is greater than "<<str;
    }
    else if (tstr==tstr1)
    {
        cout<<"both are equal of size";
    }
    else{
       cout<<str<<" is greater than "<<str1.str;
    }
}

void cStrings::operator<(cStrings str1)
{
    int tstr1=strlen(str1.str);
    int tstr=strlen(str);
    if(tstr1<tstr){
        cout<<str1.str<<" is smaller than"<<str;
    }
    else if (tstr==tstr1)
    {
        cout<<"both are equal of size";
    }
    else{
       cout<<str<<" is smaller than"<<str1.str;
    }
}

int main(){
    int opt,c;
    cStrings a,b;
    
    while(opt!=5)
    {
        cout<<"\n\t\t---Main Menu---\n\n\t1.Concat\n\t2.Equality";
        cout<<"\n\t3.Greater Length \n\t4.Smaller Length\n\t";
        cout<<"\n\t5.Exit\n\n\t--Enter your choice-->";

        cin>>opt;

        switch(opt)
      {
             case 1:
                      cout<<"\nEnter the 1st string-\n";
                      a.getdata();
                      cout<<"\nEnter the 2nd string-\n";
                      b.getdata();
                    a+b;
                    break;
            case 2:
                 cout<<"\nEnter the 1st string-\n";
                      a.getdata();
                cout<<"\nEnter the 2nd string-\n";
                      b.getdata();
                a==b;
                break;
            case 3:
                 cout<<"\nEnter the 1st string-\n";
                      a.getdata();
                      cout<<"\nEnter the 2nd string-\n";
                      b.getdata();
                    a>b;
                    break;
            case 4:
                 cout<<"\nEnter the 1st string-\n";
                      a.getdata();
                      cout<<"\nEnter the 2nd string-\n";
                      b.getdata();
                      a<b;
                      break;
    case 5: return 0;
			 
			 default: cout<<"Invalid choice..try again\n";
      } 
}
}