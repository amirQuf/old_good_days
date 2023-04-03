#include<iostream>
using namespace std;
int  main(){
	int a,b,a1,b1,n;
	cin>>n;
	a1=n-2;
	b1=n-3;
	if(n<=0)
	system ("pause");
	if(n==1){
	a=0;
	b=0;}
	if(n==2)
	{ a=1;
	b=0;
	}
	if(n>2){
	
	a=(a1/4)+1;
	b=(b1/4)+1;
	
	if(a1%4==2 || a1%4==3)
	{a*=-1;
	}
	if(b1%4==2 || b1%4==3)
	{b*=-1;
	}}
	cout<<a<<" "<<b;
	return 0;
}
