#include<stdio.h>

#define IN 1
#define OUT 0

int main()
{
   int c,nl,nw,nc,state,ndigits[10]={0},i;
  
   state=OUT;
   nl=nw=nc=0;
   while((c=getchar())!=EOF)
   {
       ++nc;
       if(c=='\n')
           ++nl;
       if(c>='0' && c<='9')
           ++ndigits[c-'0'];       //counting the number of occurrences for each digit.
       if( c==' ' || c=='\n' || c=='\t')
           state=OUT;
       else if(state==OUT)
       {
           state=IN;
           ++nw;
       }
   }
   printf("number of lines=%d\nnumber of words=%d\nnumber of characters=%d\n",nl,nw,nc);
   printf("number of occurences of each digit:\n");
   for(i=0;i<10;i++)
       printf("%d %d\n",i,ndigits[i]);
}