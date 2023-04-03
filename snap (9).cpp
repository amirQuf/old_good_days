#include<iostream>
using namespace std;
int main(){
	int n,m,k,l,w,sum=0;
	cin>>n;
	cin>>m;
	if(n>=2&&n<=10)
	return 0;
	if(m>=1&&m<=20)
	return 0;
	int snap[n+1][m+1];
	for(int i=1;i<=m;i++)
	for(int j=1;j<=n;j++){
		cin>>snap[i][j];
	}
	for(int k=1;k<=m;k++){
		cin>>l>>w;
		sum+=snap[l][w];
	}
	cout<<sum;	
	return 0;
}
