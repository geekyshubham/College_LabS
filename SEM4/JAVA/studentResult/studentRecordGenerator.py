import csv
import random

with open('studentRecords.csv','w') as updateFile:
    writer = csv.writer(updateFile,delimiter=',')
    with open('symca.csv') as csv_file:
        reader = csv.reader(csv_file,delimiter=',')

        line_count=0

        for row in reader:
            if line_count == 0:
                row.append('sub1')
                row.append('sub2')
                row.append('sub3')

                writer.writerow(row)
                line_count += 1
            else:
                row.append(str(random.randrange(10,100)))
                row.append(str(random.randrange(10,100)))
                row.append(str(random.randrange(10,100)))
                
                writer.writerow(row)
                print(row)
                line_count += 1