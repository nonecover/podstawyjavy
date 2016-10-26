package com.jakomulski.daofactory;

import com.jakomulski.daofactory.models.Person;

interface DataAccessObject {

	Person getPersonById(int id);
}
