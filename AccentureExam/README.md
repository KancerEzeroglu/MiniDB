#                                               ~MİNİDB~

Bu kucuk projede basit tablo içeren basit bir veritabanını yükleyeceğiz.
Bu veritabanı CSV formatındaki dosyaları depolar. Bu dosyalarda her bir satır aşağıdaki formatta olmalıdır.

> <Username>;<First Name>;<Last Name>;<Department>;<Account End Date>;<Telephone Number>

Örnek içerkite şu şekilde olabilir;

cemadgzl;Ali;Veli;Sales;2015-12-31;+90 533 12345678

Bu dosya içerisindeki bilgiler aşağıdaki kurallara uygun şekilde yüklenmelidir.

1. Dosya UTF-8 formatında depolanmalıdır ve bazı alanlar non-ASCII karakterler içerebilir.
2. 'username' alanı alfenumerik ASCII karakterlerini içermelidir ve 6 ile 10 karakter uzunluğunda olması gerekmektedir.
3. 'firstname' ve lastname alanları alfenümerik karakterleri içermelidir, 30 byte'dan fazla olmamalı ve UTF-8 formatında olmalıdır.
4. 'department' alanı basılabilir(printable) karakter içerebilir ve 20 byte'dan fazla olmamalı ve UTF-8 formatında olmalıdır.
5. 'telephone' numbers alanı uluslararası önek ile başlamalı, boşluklar rakamlar arasında izin verilmeli ancak diğer özel karakterlere izin verilmemeli. Bu alanın kapasitesi 25 karakter olmalıdır.
6. 'account end date' alanı ISO notasyonu şeklinde olmalıdır,yukarıdaki örnekte gösterildiği gibi. <year>-<month>-<day>

