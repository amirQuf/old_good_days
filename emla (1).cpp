#include<iostream>
#include<string>
using namespace std;
int main(){
int i,a,s,CNT;
string str1;
for(int i=1;i<=5;i++)
{
getline(cin,str1);
	a=str1.find("HAFEZ");
	s=str1.find("MOLANA");
	if(a!=-1||s!=-1)
	{cout<<i<<endl;
	
	CNT++;
}
}
if(CNT==0)
cout<<"NOT FOUND";
return 0;
}
