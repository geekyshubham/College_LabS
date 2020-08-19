"""
In this lab we had to split the days in certain parts just like normall a 24h day is splitted into 2 i.e 12h + 12h similarly the the input will
determine the hours in a day as well as no of parts but the number maintains equal partition of a day

also further we need to find the number of pairs from the parts we evaluated are Prime Numbers i.e incase of [2,5] both are prime thus eligible to be counted as a Prime Pair
"""
D=int(input())
P= int(input())

out = int(D/P)

arrays = []
i=1
while i < out:
  for j in range(i,D,out):
    arrays.append(j)
  i += 1
  
lists = [arrays[i:i + P] for i in range(0, len(arrays), P)]  

print("array parts of days:"+str(lists))

#prime number pairs

def isPrime(num):
  if num>1:
    for i in range(2,num):
      if num%i==0:
        return False
        break
    return True
  return False

Pairs = 0

for i in lists:
  count = 0
  for p in i:

    if isPrime(p):
      count += 1
    else:
      break
  if count == P:
    Pairs+=1
  
print("No. of Prime pairs :"+str(Pairs))



