#include<iostream>
#include<math.h>
using namespace std;
int main(){
long	int  n, d,a,b,c,g;
	cin>>d;
	d=(d/2)-1;
	g=9+4*d*2;
	n=(double)(-3+sqrt(g))/4;
	if(4*n*n+3*n+1==d)
{	a=2*n+1;
	b=2*n*(n+1);
	c=2*n*n+2*n+1;
	cout<<c<<" "<<b<< " "<<a;}
	else
	cout<<"imposible";
	return 0;
	
}
