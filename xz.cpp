#include<iostream>
#include<cmath>
using namespace std;
int main(){
double a,b,c,d,max1,max,min,min1;
double sum,avg,pro;			
cin>>a>>b>>c>>d;
sum=(a+b+c+d);
avg=sum/4;
pro=a*b*c*d;
cout<<fixed<<"Sum : "<<sum<<endl;
cout<<fixed<<"Average : "<<avg<<endl;
cout<<"Product : "<<fixed<<pro<<endl;
if(a>b){
		max=a;
		min=b;
}
else
{
		max=b;
		min=a;
}
if(c>d)
{		
		max1=c;
		min1=d;
}
else
{
		max1=d;
		min1=c;
}
if(max>max1)
		cout<<fixed<<"MAX : "<<max<<endl;
else
		cout<<fixed<<"MAX : "<<max1<<endl;
if(min<min1)
		cout<<fixed<<"MIN : "<<min;
else
		cout<<fixed<<"MIN : "<<min1;
return 0;
}
