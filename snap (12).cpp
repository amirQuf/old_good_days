#include<iostream>
using namespace std;
int main(){
	int n,m,k,l,w,sum=0;
	//cout<<"n=\n";
	cin>>n;
	//cout<<"m=\n";
	cin>>m;
//	cout<<" end1\n";
	int snap[n][m];
	for(int i=1;i<=m;i++)
	for(int j=1;j<=n;j++){
		cin>>snap[i][j];
	}
//	cout<<"end2\n";
	for(int k=1;k<=m;k++){
		cin>>l>>w;
		sum+=snap[l][w];
	}
	cout<<sum;
//	cout<<"the end";	
	return 0;
}
