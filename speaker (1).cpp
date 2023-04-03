#include<iostream>
#include<string>
using namespace std;
int main(){
string z;
	cin>>z;
	cout<<z<<endl;
for(int i=2;i<=z.length()+1;i++){
	for(int k=i-1;k;k--){
	z[k-1]=z[k];
	}	
	cout<<z<<endl;
}
return 0;
}
