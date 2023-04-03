#include<iostream>
using namespace std;
int main(){
	int n,m,k,l,w,sum=0;
	cin>>n;
	cin>>m;
	int snap[n][m];
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
