#include<iostream>
using namespace std;
#define MAX 1000010
#define ll long long
#define f(i,a,b) for(int i=a;i<=b;i++)
#define fd(i,a,b) for(int i=a;i<=b;i+=2)
ll arrA[MAX],arrB[MAX];
ll cal_sum(int start,int left,int right)
{
    if(start==1)
    {
        if(left%2)
            return arrA[right]-arrA[left-1];
        else
            return arrB[right]-arrB[left-1];
    }
    else
    {
        if(left%2==0)
            return arrA[right]-arrA[left-1];
        else
            return arrB[right]-arrB[left-1];
    }
}
int main()
{
    int N,Q;
    cin>>N>>Q;
    int i,j;
    arrA[0]=arrB[0]=0;
    f(i,1,N)
        cin>>arrA[i];
    f(i,1,N)
        cin>>arrB[i];
    fd(i,2,N)
        swap(arrA[i],arrB[i]);
    f(i,2,N)
    {
        arrA[i]+=arrA[i-1];
        arrB[i]+=arrB[i-1];
    }
    int start,left,right;
    f(i,0,Q-1)
    {
        cin>>start>>left>>right;
        cout<<cal_sum(start,left,right)<<endl;
    }
    return 0;
}

