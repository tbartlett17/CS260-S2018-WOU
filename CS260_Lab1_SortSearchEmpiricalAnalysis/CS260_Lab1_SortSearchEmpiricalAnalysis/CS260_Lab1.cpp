//********************************************************************************************
// Author: Tyler Bartlett
// Files: CS260_Lab1.cpp
// Date: 04/21/18
// Course: CS260
// Class time: 10am, M/W
// Lab: 1
// Desc:  
//		
//********************************************************************************************
#include <stdio.h> 
#include <stdlib.h>
#include <time.h>

#define NUM_RUNS_SORT 10
#define NUM_RUNS_SEARCH 30
#define MAX_RUNS 30

//swap two given array elements
void swapper(int* elem1, int * elem2)
{
	int temp = *elem1;
	*elem1 = *elem2;
	*elem2 = temp;
}

//bubble sort the given array and count comparisons 
void bubbleSort(int arrSize, int* arrayPtr, double* ptrToNumComparisons) //sorting in descending order (bubble up)
{
	double numComps = 0;
	bool sorted = false;
	for (int pass = 0; pass < arrSize && !sorted; pass++)
	{
		sorted = true;
		int j;
		for ( j = 0; j < arrSize - pass; j++)
		{
			if (arrayPtr[j] < arrayPtr[j + 1])
			{
				swapper(&arrayPtr[j], &arrayPtr[j + 1]);
				sorted = false;
			}
		}
		numComps += j;
	}
	*ptrToNumComparisons = numComps;
}

//selection sort the given array and count comparaisons
void selectionSort(int arrSize, int* arrayPtr, double* ptrToNumComparisons) //sorted in ascending order
{
	int IndexOfSmallest;
	double numComps = 0;
	for (int i = 0; i < arrSize; i++)
	{
		IndexOfSmallest = i;
		for (int j = i; j < arrSize; j++)
		{
			numComps++;
			if (arrayPtr[j] < arrayPtr[IndexOfSmallest])
			{
				IndexOfSmallest = j;
			}
		}
		swapper(&arrayPtr[IndexOfSmallest], &arrayPtr[i]);
	}
	*ptrToNumComparisons = numComps;
}

//insertion sort the given array and count comparisons
void insertionSort(int arrSize, int* arrayPtr, double* ptrToNumComparisons) //sorted in ascending order
{
	int j;
	double numComps = 0;
	for (int i = 1; i <= arrSize-1; i++)
	{
		j = i;
		numComps++;
		while (j > 0 && arrayPtr[j] < arrayPtr[j-1])
		{
			numComps++;
			swapper(&arrayPtr[j], &arrayPtr[j-1]);
			j--;
		}
	}
	*ptrToNumComparisons = numComps;
}

void linearSearch(int arrSize, int* arrayPtr, double* ptrToNumComparisons)
{
	int randNum = (rand()*rand()) % 99999;
	double numComps = 0;
	//arrayPtr[77] = randNum;
	//printf("linearly searching for %d.\n", randNum);
	for (int i = 0; i < arrSize; i++)
	{
		numComps++;
		if (randNum == arrayPtr[i])
		{
			//printf("found %d at spot arr[%d]\n\n", randNum, i);
			break;
		}
		else
		{
			if (i == arrSize - 1)
			{
				//printf("could not find %d in arr.\n\n", randNum);
			}
		}

	}
	*ptrToNumComparisons = numComps;
}

void binarySearch(int arrSize, int* arrayPtr, double* ptrToNumComparisons)
{
	int randNum = (rand()*rand()) % 99999;
	double numComps = 0;
	int min = 0;
	int max = arrSize - 1;
	int mid = (min+max)/2;
	//printf("binaryily searching for %d.\n", randNum);
	while (min <= max)
	{
		numComps++;
		if (arrayPtr[mid] == randNum)
		{
			//printf("found %d at spot arr[%d]", randNum, mid);
			break;
		}
		else if (arrayPtr[mid] < randNum)
		{
			//printf(" randNum (%d) was larger  than arr[%d] (%d). readjusting min to mid+1 and trying again.\n", randNum, mid, arrayPtr[mid]);
			min = mid + 1;
		}
		else
		{
			//printf(" randNum (%d) was smaller than arr[%d] (%d). readjusting max to mid-1 and trying again.\n", randNum, mid, arrayPtr[mid]);
			max = mid - 1;
		}
		mid = (min + max) / 2;
	}
	if (min > max)
	{
		//printf("could not find %d in arr.\n\n", randNum);
	}
	*ptrToNumComparisons = numComps;
}

//recieve an epty array, generate random numbers from 1 - 100,000, fill array
void randomizeArray(int arrSize, int* arrayPtr)
{
	for (int i = 0; i < arrSize; i++)
	{
		arrayPtr[i] = (rand()*rand()) % 99999;
	}
}

//just a simple array printer (to screen) function
void printArr(int arrSize, int* arrayPtr)
{
	for (int i = 0; i < arrSize; i++)
	{
		printf("arr[%d]: %d\n", i, arrayPtr[i]);
	}
	printf("\n");
}

//write times and comparisons for each run from the sorts/searches into a an excel sheet 
void writeFile(FILE* fp, float* timeArr, double* comparisonsArr, int algoNum)
{
	
	//print run 1-MAX
	for (int i = 0; i < NUM_RUNS_SEARCH; i++)
	{
		//only print length 10 for searchs
		if (algoNum <= 3)
		{
			if (i == NUM_RUNS_SORT)
			{
				break;
			}
		}
		fprintf(fp, "%d,", i+1);
		
	}
	fprintf(fp, "\n");
	//print times
	for (int i = 0; i < NUM_RUNS_SEARCH; i++)
	{
		//only print length 10 for searchs
		if (algoNum <= 3)
		{
			if (i == NUM_RUNS_SORT)
			{
				break;
			}
		}
			fprintf(fp, "%f,", timeArr[i]);	
	}
	fprintf(fp, "\n");
	//print comparisons
	for (int i = 0; i < NUM_RUNS_SEARCH; i++)
	{
		//only print length 10 for searchs
		if (algoNum <= 3)
		{
			if (i == NUM_RUNS_SORT)
			{
				break;
			}
		}
		fprintf(fp, "%f,", comparisonsArr[i]);	
	}
	fprintf(fp, "\n\n");
}

//create array of size passed in, call the passed in sort/search, record time and comparisons to arrays
void playGround(int arrSize, float* timeArr, double* comparisonsArr, int algoNum)
{
	srand(time(NULL));
	clock_t start, end;
	float algoRunTime = 0;

	int* theArr = (int*)malloc(arrSize * sizeof(int));//dynamically sized array
	double numComparisons;
	double* ptrToNumComparisons = &numComparisons;
	// 1=bubble, 2=selection, 3=insertion, 4=linear, 5=binary
	switch (algoNum) {
		case 1:
			for (int i = 0; i < NUM_RUNS_SORT; i++)
			{
				*ptrToNumComparisons = 0;
				randomizeArray(arrSize, theArr);
				//printArr(arrSize, theArr);
				start = clock();
				bubbleSort(arrSize, theArr, ptrToNumComparisons);
				end = clock();
				//printArr(arrSize, theArr);
				timeArr[i] = (float)(end - start) / CLOCKS_PER_SEC;
				comparisonsArr[i] = numComparisons;
			}
			break;
		case 2:
			for (int i = 0; i < NUM_RUNS_SORT; i++)
			{
				*ptrToNumComparisons = 0;
				randomizeArray(arrSize, theArr);
				//printArr(arrSize, theArr);
				start = clock();
				selectionSort(arrSize, theArr, ptrToNumComparisons);
				end = clock();
				//printArr(arrSize, theArr);
				timeArr[i] = (float)(end - start) / CLOCKS_PER_SEC;
				comparisonsArr[i] = numComparisons;
			}
			break;
		case 3:
			for (int i = 0; i < NUM_RUNS_SORT; i++)
			{
				*ptrToNumComparisons = 0;
				randomizeArray(arrSize, theArr);
				//printArr(arrSize, theArr);
				start = clock();
				insertionSort(arrSize, theArr, ptrToNumComparisons);
				end = clock();
				//printArr(arrSize, theArr);
				timeArr[i] = (float)(end - start) / CLOCKS_PER_SEC;
				comparisonsArr[i] = numComparisons;
			}
			break;
		case 4:
			randomizeArray(arrSize, theArr);
			selectionSort(arrSize, theArr, ptrToNumComparisons);
			for (int i = 0; i < NUM_RUNS_SEARCH; i++)
			{
				*ptrToNumComparisons = 0;				
				start = clock();
				linearSearch(arrSize, theArr, ptrToNumComparisons);
				end = clock();
				timeArr[i] = (float)(end - start) / CLOCKS_PER_SEC;
				comparisonsArr[i] = numComparisons;
			}
			break;
		case 5:
			randomizeArray(arrSize, theArr);
			selectionSort(arrSize, theArr, ptrToNumComparisons);
			for (int i = 0; i < NUM_RUNS_SEARCH; i++)
			{
				*ptrToNumComparisons = 0;
				start = clock();
				binarySearch(arrSize, theArr, ptrToNumComparisons);
				end = clock();
				timeArr[i] = (float)(end - start) / CLOCKS_PER_SEC;
				comparisonsArr[i] = numComparisons;
			}
			break;
		default:
			printf("unknown algorithm selected. exiting program...");
			exit(-1);
	}
}

int main()
{
	/* JUST SOME SETUP */
	float* timeTracker = (float*)malloc(MAX_RUNS * sizeof(float));
	double* comparisonTracker = (double*)malloc(MAX_RUNS * sizeof(double));

	FILE* fp;
	if (!(fp = fopen("timeRecordings.csv", "w")))
	{
		printf(" can not open file\n");//prind and exit if file open error
		exit(-1);
	}

	//playGround(100, timeTracker, comparisonTracker, 5);
	//for (int i = 0; i < 1; i++)
	//{
	//	printf("run: %d, time (s): %.3f, comps: %.0f\n", i + 1, timeTracker[i], comparisonTracker[i]);
	//}

	//cycle through the sorts/searches
	// 1=bubble, 2=selection, 3=insertion, 4=linear, 5=binary
	for (int algoNum = 4; algoNum <= 5; algoNum ++)
	{
		printf("working on algo: %d ...\n", algoNum);

		//arr size start at 10k, increment by 10k up to 100k
		for (int arrSize = 10000; arrSize <= 100000; arrSize += 10000)
		{
			printf("\tworking on arrSize: %d ... ", arrSize);
			playGround(arrSize, timeTracker, comparisonTracker, algoNum);
			writeFile(fp, timeTracker, comparisonTracker, algoNum);
			printf("done\n");
		}
		printf("... algo: %d done\n\n", algoNum);
	}

	fclose(fp);
	return 0;
}