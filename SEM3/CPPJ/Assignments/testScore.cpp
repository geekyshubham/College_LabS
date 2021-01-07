
#include<iostream>

using namespace std;
class TestScores
{
	public:
	int *scores,l;
	TestScores()
	{
		int i;
		cout<<"Enter How Many Test Scores You Want:";
		cin>>l;
		scores=new int[l];
		cout<<"\nEnter "<<l<<" TestScores:-\n";
		for(i=0;i<l;i++)
		{
			cout<<"Enter "<<i+1<<" Test Score:-";
			cin>>scores[i];
		}
	}
	TestScores(TestScores &t2)
	{
		int i;
		l=t2.l;
		scores=new int[l];
		for(i=0;i<l;i++)
		{
			scores[i]=t2.scores[i];
		}
	}
	void show()
	{
		int i;
		cout<<"\n---:Test Scores:---";
		for(i=0;i<l;i++)
		{
			cout<<endl<<scores[i];
		}
	}
	void average()
	{
		float avg=0;
		int i;
		for(i=0;i<l;i++)
		{
			avg=avg+scores[i];
		}
		avg=avg/l;
		cout<<"\n Average:-"<<avg<<"\n";
	}
	void operator [](int i)
	{
		if(i>=l || i<0)
		{
			cout<<"\n---:Array Index Out OF Bound:---\n";
		}
		else
		{
			cout<<"Enter New Value for "<<i<<" Element::";
			cin>>scores[i];
		}
	}
	TestScores operator = (TestScores &t)
	{
		int i;
		l=t.l;
		cout<<"\n---:Overloading =  operator:---\n";
		scores=new int[l];
		for(i=0;i<l;i++)
		{
			scores[i]=t.scores[i];
		}
	}

	~TestScores()
	{
		delete [] scores;
	}
};
int main()
{
	TestScores t1;
	cout<<"\n---:Object 1:---\n";
	t1.show();
	t1.average();
	cout<<"\n---:Object 2:---\n";
	TestScores t2(t1);
	cout<<"After using copy constructor object2:-\n";
	t2.show();
	t2.average();
	cout<<"\nChanging Values Of t2 by Overloading [] Operator:-\n";
	t2[0];
	t2[1];
	t2[10];
	cout<<"\nAfter Changing values Object 2 :-\n";
	t2.show();
	t2.average();
	t2=t1;
	cout<<"\nAfter Using Asignment Operator Object 2:\n";
	t2.show();
	t2;
	t1;
	
}
