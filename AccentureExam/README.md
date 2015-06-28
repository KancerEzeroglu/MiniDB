This program is GPL Licenced.

#                                               ~MINIDB~

A simple in memory database implemented in this project.

Database has below features;
 - data is loaded via csv files
 - several query methods to query data on several fields
 - simple index functionality is implemented
 - querried data is sorted


> ```<Username>;<First Name>;<Last Name>;<Department>;<Account End Date>;<Telephone Number>```

Sample data row is :
cemadgzl;Ali;Veli;Sales;2015-12-31;+90 533 12345678

Example code is written into  ExamMain method. Below section gives details about methods implemented. 

##int loadData(string fileName)

Loads given csv file into database. Records in the file were checked by compliance with the six rules. At the end, returns the number of records loaded.
The six rules are:

* The file will be stored in UTF-8 format and may contain non-ASCII characters in some fields.
* The username field may only contain alphanumeric ASCII characters and will be between 6
and 10 characters long.
* The first name and last name fields may contain sequences of alphabetic characters
and will not be longer than 30 bytes UTF-8 encoded each.
* The department field may contain any valid printable character and will not be longer
than 20 bytes UTF-8 encoded.
* The telephone numbers will be in the format shown above with the leading
international prefix, spaces are allowed between the digits, but no other special characters.
The field has a maximum capacity of 25 characters.
* The account end date will be in ISO notation <year>-<month>-<day> as shown in
the example.

##Record[] findByName(String firstname, String lastname)

Searches for matching records in memory and returns an array of matching record instances.
The array sorted by end date. DateComparator was used for this issue. 

##Record[] findByDepartment(String department)

Searches for all entries that match the given department name and returns an array of records.
The array sorted by first name and last name. 

##Record[] findByTelNum(String telNum)

Searches for matching records in memory and returns an array of matching record instances. 

##Record[] findEndDate( Date intervalStart, Date IntervalEnd)

Searches for accounts that will expire within the interval given by intervalStart and intervalEnd.
For this issue the array sorted by endDate. 
Returned an array of records matching the search criteria. 
The array sorted by end date.

##Indexing
In order to increase search performance, a simple indexing is implemented. 
While loading data to database at loadData method, keys and corresponding row numbers are stored as keys. 

For example;
a nameSurname index is created as follows; 
  "name-surname" -> [2,3,4,5]
Key for nameSurname index consists of the first name,dash and surname. During the execution of the findByName method, first name-surname key is created using arguments, then nameSurname index is checked for such record and find the rowNumber list of the record. Once the rownumber list is found then records are retreived from database using these indexes..

nameSurname index, department index and telnum indexes are created for performance increase.


##Performance increase for findEndDate method. 

All records are sorted by endDate at the begining. In findEndDate method, when a record having endDate greated than IntervalEnd argument method finishes execution and thus complexity is less then O(n).

