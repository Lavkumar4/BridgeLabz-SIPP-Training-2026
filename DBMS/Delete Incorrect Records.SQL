//Delete an Incorrect Country Name
DELETE FROM covid_cases
WHERE country = 'IN';

//. Delete Duplicate Records
DELETE c1
FROM covid_cases c1
JOIN covid_cases c2
ON c1.country = c2.country
AND c1.report_date = c2.report_date
AND c1.case_id > c2.case_id;