//Copyright (C) <2015>  <Kancer Gokirmak>
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>

package com.exam;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Record>{

	@Override
	public int compare(Record o1, Record o2) {
		Date date1 = o1.getEndDate();
		Date date2 = o2.getEndDate();

			return date1.compareTo(date2);
		}
}
