#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	int a,b;
	cin>>a>>b;
	for(int i=2;i<=abs(a-b);i++){
		if(abs(a-b)%i==0){
			cout<<i<<" ";
		}
	}
 
 return 0;
}
