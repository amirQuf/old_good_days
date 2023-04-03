#include<iostream>
#include<string>
using namespace std;
int main(){
int i,a,s,CNT;
int x[4]={0};
string str1;
for(int i=1;i<=5;i++)
{
getline(cin,str1);
	a=str1.find("HAFEZ");
	s=str1.find("MOLANA");
	if(a!=-1||s!=-1)
	{	CNT++;
	x[CNT]=i;
}
}
for(int i=1;i<=CNT;i++){
	cout<<i<<" ";
}
if(CNT==0)
cout<<"NOT FOUND !";
return 0;
}
