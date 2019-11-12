/* Write a function setbits(x,p,n,y) that returns x with the n bits that begin at positionp set to the rightmost n bits of y,leaving the other bits unchanged.*/

#include <stdio.h>

unsigned setbits(unsigned x,int p,int n,unsigned y);

int main() {
  printf("setbits(x=0x%x, p=%d, n=%d, y=0x%x) => 0x%x\n", 0x1234, 15, 8, 0xffff, setbits(0x1234, 15, 8, 0xffff));
  printf("setbits(x=0x%x, p=%d, n=%d, y=0x%x) => 0x%x\n", 0x1234, 14, 3, 2, setbits(0x1234, 14, 3, 2));
  printf("setbits(x=0x%x, p=%d, n=%d, y=0x%x) => 0x%x\n", 0x1234, 20, 6, 0xf2, setbits(0x1234, 20, 6, 0xf2));
  printf("setbits(x=0x%x, p=%d, n=%d, y=0x%x) => 0x%x\n", 0x1234, 31, 4, 0x192f, setbits(0x1234, 31, 4, 0x192f));
}

unsigned setbits(unsigned x,int p,int n,unsigned y)
{
    return (x & ~(~(~0 << n) << (p+1-n))) | ( y & ~(~0<<n)) << (p+1-n);
}
