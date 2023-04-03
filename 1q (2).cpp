#include<iostream>
using namespace std;
int main(){int a,b;
cin>>a>>b;
for(int i=a;i<=a;i--){int s,d;
s=a%i; 
d=b%i;
if(s==d)
cout<<i<<" ";
}
return 0;
}
