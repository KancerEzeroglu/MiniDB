#**                                               ~MINIDB~

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

##** int loadData(string fileName)

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
