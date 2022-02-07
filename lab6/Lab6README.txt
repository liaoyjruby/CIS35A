Yi Jou (Ruby) Liao
CIS 35A - Section 61Y
Assignment 6
Due 7 December 2019
Submitted 7 December 2019

LAB 6 READ ME

Part 1: Exception Fixing

1) Open Lab6 files. Change all path files to appropriate locations on your computer so program can access data. The file path in Driver1 should point to "StudentData2.txt". Run Driver1.java as Java application.

2) Console will notify of an exception (2 - Missing Header) occuring. Program fixes exception automatically, so correct class results are stil displayed. Access "ProblemLog.txt" to see record of Missing Header exception.


Part 2: Serialization

1) The file path in Driver2 should point to "StudentData1.txt". Run Driver2.java as Java application.

2) Console will display serialized data for SID 1234. Change SID on line 28 to access other students' data file.

3) In data/output folder, 15 unique .dat files are generated. If all 45 student data entries were unique, 40 unique .dat files would be generated.


Part 3: Interface

1) The file path in Driver3 should point to "StudentData1.txt". Run Driver3.java as Java application.

2) Student API view is displayed for SID 1234 and SID 3124, showing their individual quiz scores as well as class results.

3) In data/output folder, 15 unique .dat files are generated. If all 45 student data entries were unique, 40 unique .dat files would be generated.


To access DEBUG mode, change all boolean DEBUG values to "true". 
Console will additionally print:
  1) Lines of StudentData.txt as they are being read by FileIO
  2) Each student's ID and quiz score record as stored in Student[] dataArray
  3) Number of student records stored
  4) Every printStats() option