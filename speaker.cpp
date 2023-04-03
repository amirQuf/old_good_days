#include<iostream>
#include<string>
using namespace std;
int main(){
string z;
getline(cin,z);
	cout<<z<<endl;
for(int i=2;i<=z.length();i++){
	for(int k=i-1;k;k--){
	z[k-1]=z[k];
	}	
	if(i==z.length())
	cout<<z;
	else
	cout<<z<<endl;
}
return 0;
}
