#include <stdio.h>

int rand(void);
void srand(unsigned int);
void shellsort(int v[*], int n);

int main(int argc, char** argv)
{
  printf(argv[2][1]);

  int i = 0;
  srand((unsigned int)12345);
  int n = 10;
  int v[n];

  // Populate array with random variables
  while (i < n)
  {
    v[i] = rand();
    i++;
  }
  i = 0;
  
  // Sort the array in decreasing order
  shellsort(v, n);

  // Print sorted array
  while (i < n)
  {
    printf("%d\n", v[i]);
    i++;
  }
}

/* shellsort: sort v[0]...v[n-1] into decreasing order */
void shellsort(int v[], int n)
{
  int gap, i, j, temp;
  for (gap = n / 2; gap > 0; gap /= 2)
    for (i = gap; i < n; i++)
      for (j = i - gap; j >= 0 && v[j] < v[j + gap]; j -= gap)
      {
        temp = v[j];
        v[j] = v[j + gap];
        v[j + gap] = temp;
      }
}
unsigned long int next = 1;
/* rand: return pseudo-random integer on 0..32767 */
int rand(void)
{
  next = next * 1103515245 + 12345;
  return (unsigned int)(next / 65536) % 32768;
}
/* srand: set seed for rand() */
void srand(unsigned int seed)
{
  next = seed;
}
